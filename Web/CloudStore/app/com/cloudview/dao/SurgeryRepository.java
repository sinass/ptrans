package com.cloudview.dao;

import javax.persistence.EntityManager;

import com.cloudview.model.AppUser;
import com.cloudview.model.Surgery;

public class SurgeryRepository {
	public static void save(Surgery s){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
		em.close();
	}
	public static void delete(Surgery s){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}
	public static Surgery deleteById(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Surgery s = em.find(Surgery.class,id);
		em.close();
		return s;
	}
	public static Surgery findById(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Surgery s = em.find(Surgery.class,id);
		em.close();
		return s;
	}
	
}
