package com.digi.uniprr.controller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.digi.uniprr.VO.ReviewerFilterVO;
import com.digi.uniprr.model.User;

@Repository
public class UserDao {
	
	@PersistenceContext
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<User> reviewerFilterImplementation(String queryString, ReviewerFilterVO vo) {
		
		Query query = manager.createQuery(queryString);
		if (vo.getJournalId() != null && !vo.getJournalId().isEmpty()) 
			query.setParameter("journalList", vo.getJournalId());
			
		if (vo.getExpertiseId() != null && !vo.getExpertiseId().isEmpty()) 
			query.setParameter("expertiseList", vo.getExpertiseId());
		
		if (vo.getSpecializationId() != null && !vo.getSpecializationId().isEmpty()) 
			query.setParameter("specializationList", vo.getSpecializationId());
		
		if (vo.getInstitutionId() != null && !vo.getInstitutionId().isEmpty()) 
			query.setParameter("instituteList", vo.getInstitutionId());
		
		if (vo.getName() != null && !vo.getName().isEmpty())
			query.setParameter("name", "%" + vo.getName() + "%");
		
		List<User> list = (List<User>) query.getResultList();
		return list;
	}

}
