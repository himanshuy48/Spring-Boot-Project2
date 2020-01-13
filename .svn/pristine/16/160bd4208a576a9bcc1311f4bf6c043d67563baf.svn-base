package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.MasterAttributes;

public interface MasterAttributesRepo extends JpaRepository<MasterAttributes, Integer>{

	@Query("SELECT mec from MasterAttributes mec WHERE mec.category=:category")
	List<MasterAttributes> getCheckList(String category);

}
