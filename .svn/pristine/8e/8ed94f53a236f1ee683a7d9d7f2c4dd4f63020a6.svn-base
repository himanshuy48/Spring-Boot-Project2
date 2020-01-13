package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.KeywordMaster;

public interface KeywordMasterRepo extends JpaRepository<KeywordMaster, Integer>{

	@Modifying
	@Query("Update KeywordMaster km set km.isActive=0 where km.id=:id")
	void deleteKeywordMaster(Integer id);
	
	@Query("Select km from KeywordMaster km where km.isActive=1")
	List<KeywordMaster> getKeywordMasterList();
	
	@Query("Select km from KeywordMaster km where km.id=:id AND km.isActive=1")
	KeywordMaster getKeywordMaster(Integer id);

}
