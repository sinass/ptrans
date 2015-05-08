package com.cloudview.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cloudview.model.AppUser;


public class UserRepository {
	
	public static List<AppUser> findAll(){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<AppUser> query = em.createNamedQuery("AppUser.findAll", AppUser.class);
		return query.getResultList();
	}
	
	public static AppUser findByLoginAndPassword(String login,String password){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		AppUser u = new AppUser();
		try{
			u = (AppUser)em.createQuery("select A from AppUser A where A.login= :login and A.password= :password")
					.setParameter("login", login)
					.setParameter("password", password)
					.getSingleResult();
		}
		catch(Exception ex){
			
		}
		return u;
	}
}
