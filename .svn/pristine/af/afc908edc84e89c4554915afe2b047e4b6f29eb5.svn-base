package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalMetadata;

public interface JournalMetadataRepo extends JpaRepository<JournalMetadata, Integer>{
//
//	@Query(value="SELECT * FROM journal_metadata a WHERE a.journal_id=:journalId",nativeQuery = true)
//	JournalMetadata metaDatalistByJournalId(Integer jornalId);
//	
	

	@Query("SELECT a FROM JournalMetadata a WHERE a.journalId=:jornalID")
	JournalMetadata metaDatalistByJournalId(Integer jornalID);
	
	@Modifying(clearAutomatically = true)
	@Query("update JournalMetadata a set a.journalBlindType=:type where a.journalId =:jornalId")
	void updateBlind(Integer jornalId,String type);

	//@Query("SELECT j from JournalMetadata j where j.journalSpeciality LIKE %:specializationName% OR j.journalSubject LIKE %:subjectName%")
	@Query("SELECT s from JournalMetadata s where s.journalSpeciality IN :specializationName OR s.journalSubject IN :subjectName")
	List<JournalMetadata> getSpecilaizationByJournal(List<String> specializationName, List<String> subjectName);
	
	@Query("SELECT s from JournalMetadata s where s.journalSubject IN :subjectName")
	List<JournalMetadata> getSpecilaizationByJournalOne(List<String> subjectName);
	
}
