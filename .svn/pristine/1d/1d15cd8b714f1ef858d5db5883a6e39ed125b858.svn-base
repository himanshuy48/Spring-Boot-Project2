package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Expertise;

public interface ExpertiseRepo extends JpaRepository<Expertise,Integer>{

	@Query("SELECT e from Expertise e where e.areaExpertise LIKE %:name%")
	List<Expertise> getExpertiseListByName(String name);


}
