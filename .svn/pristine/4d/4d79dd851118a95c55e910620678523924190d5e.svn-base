package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Institution;

public interface InstitutionRepo extends JpaRepository<Institution, Integer> {

	@Query("select a from Institution a where a.id=:id")
	List<Institution> listByIdInstitution(Integer id);

}
