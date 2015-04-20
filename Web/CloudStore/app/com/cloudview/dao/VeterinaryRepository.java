package com.cloudview.dao;

import javax.persistence.EntityManager;

import com.cloudview.model.AppUser;
import com.cloudview.model.Veterinary;

public class VeterinaryRepository {
	public static void save(Veterinary v){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
		em.close();
	}
	public static void delete(Veterinary v){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}
	public static void deleteById(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Veterinary v = em.find(Veterinary.class,id);
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}
	public static Veterinary findById(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Veterinary v = em.find(Veterinary.class,id);
		em.close();
		return v;
	}
}
