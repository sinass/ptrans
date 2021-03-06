package com.cloudview.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
	private static EntityManagerProvider singleton = new EntityManagerProvider();
	private static String persistenceUnit = "cloudviewPersistenceUnit";
	private  EntityManagerFactory emf;
	private EntityManagerProvider(){
		
	}
	public static EntityManagerProvider getInstance(){
		return singleton;
	}
	public EntityManagerFactory getEntityManagerFactory() {
		if(emf == null ) emf = Persistence.createEntityManagerFactory(persistenceUnit);
		return emf;
	}
	public void closeEntityManagerFactory(){
		if(emf.isOpen()||emf !=null) emf.close();
		emf = null;
	}
}
