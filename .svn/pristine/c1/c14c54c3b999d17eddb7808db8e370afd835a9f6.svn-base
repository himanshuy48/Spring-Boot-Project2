package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.States;

public interface StatesRepo extends JpaRepository<States, Integer> {

	@Query("select s from States s WHERE s.countryId=:countryId")
	List<States> getStatesByCoutryId(Integer countryId);
	
	
}
