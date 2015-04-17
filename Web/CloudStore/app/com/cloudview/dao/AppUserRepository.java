package com.cloudview.dao;
import javax.persistence.EntityManager;

import com.cloudview.model.*;

public class AppUserRepository {
	public static void save(AppUser user){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}
	public static void delete(AppUser user){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}
	
}
