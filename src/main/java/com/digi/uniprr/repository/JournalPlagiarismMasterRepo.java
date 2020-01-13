package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalPlagiarismMaster;
import com.digi.uniprr.model.JournalPlagirism;

public interface JournalPlagiarismMasterRepo extends JpaRepository<JournalPlagiarismMaster, Integer> {

	@Query("SELECT u FROM JournalPlagiarismMaster u WHERE u.journalId=:jornalId")
	List<JournalPlagiarismMaster> getjournalPlagiarismlist (Integer jornalId);
	
}
