package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Specialization;

public interface SpecilizationRepo extends JpaRepository<Specialization, Integer> {

	@Query(value = "SELECT * FROM specialization r WHERE r.subject_id=:id", nativeQuery = true)
	List<Specialization> getSpecializationById(Integer id);

	/*
	 * @Query("select s from Specialization s where s.expertiseId IN :expertiseid")
	 * List<Specialization> getSpecializationByIdList(List<Integer> expertiseid);
	 */

	@Modifying
	@Query("UPDATE Specialization s set s.isActive=0 where s.id=:id")
	void deleteSpecilization(Integer id);
	
	@Query("SELECT s from Specialization s where s.subjectId IN :id AND s.isActive=1")
	List<Specialization> getSpecializationByIdList(List<Integer> id);

}