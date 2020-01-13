package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.FunderDetails;

public interface FunderDetailsRepo extends JpaRepository<FunderDetails, Integer> {

	@Query("SELECT f FROM FunderDetails f WHERE f.funderName=:funderName")
	Object getFunderName(String funderName);

	@Modifying
	@Query("UPDATE FunderDetails f SET f.isActive=0 WHERE f.funderId=:funderId")
	void deleteFunderById(Integer funderId);

	@Query("SELECT f FROM FunderDetails f WHERE f.isActive=:isActive")
	List<FunderDetails> getFunderByStatus(Integer isActive);

	//Dev Here
	
	@Query("SELECT f FROM FunderDetails f WHERE f.funderId=:funderId")
	FunderDetails getResearchFunderByFunderId(String funderId);
	
	@Query("SELECT f FROM FunderDetails f WHERE f.funderName=:funderName")
	List<FunderDetails> getResearchFunderByFunderName(String funderName);
	
	
}