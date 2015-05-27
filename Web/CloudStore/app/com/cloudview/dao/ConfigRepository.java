package com.cloudview.dao;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cloudview.model.AppConfig;


public class ConfigRepository {
	
	public static AppConfig find(){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<AppConfig> query = em.createNamedQuery("AppConfig.findAll", AppConfig.class);
		return query.getResultList().get(0);
	}
	
}
