package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.controller.ManuscriptFunder;

public interface ManuscriptFunderRepo extends JpaRepository<ManuscriptFunder, Integer>{

	
	@Query("SELECT f FROM ManuscriptFunder f WHERE f.manuscriptId=:manuscriptId AND f.funderId=:funderId")
	ManuscriptFunder getManuscriptFunder(Integer manuscriptId,Integer funderId);
	
	@Query("SELECT f FROM ManuscriptFunder f WHERE f.manuscriptId=:manuscriptId")
	List<ManuscriptFunder> getManuscriptFundersList(Integer manuscriptId);
}                                                                                                     
