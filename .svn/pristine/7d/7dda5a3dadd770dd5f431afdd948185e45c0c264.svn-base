package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalChargeDetails;

public interface JournalChargeDetailsRepo extends JpaRepository<JournalChargeDetails, Integer> {

	@Query("SELECT jc FROM JournalChargeDetails jc WHERE jc.journalChargeId=:journalChargeId")
	JournalChargeDetails getJournalChargeDetailsById(Integer journalChargeId);
	
	@Query("Select jc from JournalChargeDetails jc where jc.journalId=:id")
	JournalChargeDetails getJournalChargeDetailsByJournal(Integer id);

}
