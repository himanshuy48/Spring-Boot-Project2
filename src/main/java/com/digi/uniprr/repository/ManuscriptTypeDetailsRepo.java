package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuscriptTypeDetails;

public interface ManuscriptTypeDetailsRepo extends JpaRepository<ManuscriptTypeDetails, Integer> {

	@Query("SELECT mt FROM ManuscriptTypeDetails mt WHERE mt.manuscriptId=:manuscriptId")
	List<ManuscriptTypeDetails> getManuscriptTypeDetailsById(Integer manuscriptId);
	
	@Query("SELECT mt FROM ManuscriptTypeDetails mt WHERE mt.manuscriptId=:manuscriptId")
	ManuscriptTypeDetails getDetailsFromManuscriptId(Integer manuscriptId);

}