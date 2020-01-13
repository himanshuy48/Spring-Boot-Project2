package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuScriptKeywords;

public interface ManuScriptKeywordsRepo extends JpaRepository<ManuScriptKeywords, Integer> {
	
	@Query("SELECT mk FROM ManuScriptKeywords mk WHERE manuscript_id=:manuscriptId AND isActive=1")
	List<ManuScriptKeywords> getManuscriptKeywordsFromManuscriptId(Integer manuscriptId);
	
	@Query("UPDATE ManuScriptKeywords mk SET mk.isActive=0 WHERE mk.manukeyId=:manukeyId")
	@Modifying
	void deleteManuscriptTypeKeyword(Integer manukeyId);

}
