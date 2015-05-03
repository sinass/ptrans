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
	public static void deleteById(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		AppUser user = em.find(AppUser.class,id);
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}
	public static AppUser findById(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		AppUser user = em.find(AppUser.class,id);
		em.close();
		return user;
	}
	public static AppUser authenticate(String login,String password){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		AppUser user = new AppUser();
		try{
			user = (AppUser)em.createQuery("select A from AppUser A where A.login= :login and A.password= :password").
					setParameter("login", login).setParameter("password", password).
					getSingleResult();
		}
		catch(Exception e){
			
		}
		em.close();
		return user;
	}
	
}
