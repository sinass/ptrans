package com.cloudview.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cloudview.model.AppStudy;

public class AnimalRepository {

	@SuppressWarnings("unchecked")
	public static List<AppStudy> findStudies(int idVeterinary,int idAnimal){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		return em.createQuery("select S from AppStudy S,AppAnimalFile b "
				+ "where b.appAnimal.id= :idAnimal and b.appVeterinary.id= :idVeterinary and S.appAnimalFile.id=b.id")
				.setParameter("idAnimal", idAnimal)
				.setParameter("idVeterinary", idVeterinary)
				.getResultList();
	}
	
}
