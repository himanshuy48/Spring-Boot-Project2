package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Specialization;

public interface SpecializationRepo extends JpaRepository<Specialization, Integer>{

	@Query("SELECT s from Specialization s where s.specialization LIKE %:name%")
	List<Specialization> getSpecializationByName(String name);

}
