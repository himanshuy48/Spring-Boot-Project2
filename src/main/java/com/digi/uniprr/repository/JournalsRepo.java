package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Journal;

public interface JournalsRepo extends JpaRepository<Journal, Integer> {
	
	@Query("SELECT j from Journal j WHERE j.isActive=1")
	public List<Journal> getActiveJournals();

	@Query("SELECT j from Journal j where j.journalTitle LIKE %:name% AND j.isActive=1")
	public List<Journal> getJournalByName(String name);
	
	@Query("Select j from Journal j where j.journalId=:id AND j.isActive=1")
	public Journal getJournalById(Integer id);
	
	@Query("SELECT j from Journal j WHERE j.createdBy=:userId")
	public List<Journal> getJournalByUserId(Integer userId);
}
 