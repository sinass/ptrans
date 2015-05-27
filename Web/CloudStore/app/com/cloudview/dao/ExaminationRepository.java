package com.cloudview.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cloudview.model.AppImage;
import com.cloudview.model.AppStudy;

public class ExaminationRepository {

	@SuppressWarnings("unchecked")
	public static List<AppImage> findImages(int id){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		return em.createQuery("select S.appImages from AppImageSerie S,AppExamination E "
				+ "where S.appExamination.id= :id")
				.setParameter("id", id)
				.getResultList();
	}
	
}
