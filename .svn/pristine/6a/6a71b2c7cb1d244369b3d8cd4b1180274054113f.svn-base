package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuscriptType;

public interface ManuscriptTypeRepo extends JpaRepository<ManuscriptType, Integer>{
	
	@Query("SELECT m FROM ManuscriptType m WHERE m.isActive=1")
	public List<ManuscriptType> getActiveManuscriptTypes();

}
