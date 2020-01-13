package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalMailTemplates;

public interface JournalMailTemplatesRepo extends JpaRepository<JournalMailTemplates, Integer> {

	@Query(value="select * from journal_mail_templates m where m.journal_email_template_id=:id" , nativeQuery = true)
	List<JournalMailTemplates> getJournalMailTemplatesById(Integer id);

	@Query("SELECT ju FROM JournalMailTemplates ju  WHERE ju.journalId=:journalId")
	public List<JournalMailTemplates> getTemplate(Integer journalId);
}
