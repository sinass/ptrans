package com.cloudview.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cloudview.model.AppExamination;


public class StudyRepository {

	@SuppressWarnings("unchecked")
	public static List<AppExamination> findExaminations(int idStudy){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		return em.createQuery("select E from AppExamination E,AppStudy S "
				+ "where S.id=E.appStudy.id and S.id= :idStudy")
				.setParameter("idStudy", idStudy)
				.getResultList();
	}
	
}
