package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Cities;

public interface CitiesRepo extends JpaRepository<Cities, Integer>{

	@Query("SELECT c FROM Cities c WHERE c.id=:id")
	List<Cities> findCityById(Integer id);
	
	@Query("select s from Cities s WHERE s.stateId=:stateId")
	List<Cities> getCityByStateId(Integer stateId);

}
