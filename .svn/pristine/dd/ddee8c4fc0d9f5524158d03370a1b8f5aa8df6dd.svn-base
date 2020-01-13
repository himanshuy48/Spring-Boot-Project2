package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalPlagirism;

public interface JournalPlagirismRepo extends JpaRepository<JournalPlagirism, Integer> {

	@Query("SELECT u FROM JournalPlagirism u WHERE u.journalId=:jornalId AND u.plaId=:plaId")
	JournalPlagirism getjournalPlagiarismlist (Integer jornalId,Integer plaId);
	
	
	@Modifying(clearAutomatically = true)
	@Query("update JournalPlagirism wrs set wrs.orginalSubmission =:orginalSubmission,wrs.revisedSubmission=:revisedSubmission,wrs.resubmissionSubmission=:resubmissionSubmission,wrs.acceptedSubmission=:acceptedSubmission where wrs.journalId =:journalId and wrs.plaId=:plaId")
	void updatePlagiarism(Integer journalId,Integer plaId,Integer orginalSubmission,Integer revisedSubmission,Integer resubmissionSubmission,Integer acceptedSubmission);
}
