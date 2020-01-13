package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuScriptCoAuthor;

public interface ManuScriptCoAuthorRepo extends JpaRepository<ManuScriptCoAuthor, Integer>{
	
	@Query("SELECT mk FROM ManuScriptCoAuthor mk where mk.coAuthorManuscriptId=:manuscriptId")
	public List<ManuScriptCoAuthor> getCoAuthorListFromManuscriptId(Integer manuscriptId);
	
	@Modifying
	@Query("UPDATE ManuScriptCoAuthor SET coAuthorStatus=0 WHERE id=:id")
	public void deactivateCoAuthor(Integer id);
	
}
