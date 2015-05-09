package com.cloudview.dao;

import java.util.List;

import javax.persistence.EntityManager;



import com.cloudview.model.AppAnimal;


public class VeterinaryRepository {

	@SuppressWarnings("unchecked")
	public static List<AppAnimal> findAnimals(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		return em.createQuery("select A from AppAnimal A,AppAnimalFile b "
				+ "where b.appAnimal.id=A.id and b.appVeterinary.id= :id")
				.setParameter("id", id)
				.getResultList();
	}
	
}
