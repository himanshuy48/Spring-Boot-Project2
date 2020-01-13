package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuscriptManagingEditor;

public interface ManuscriptManagingEditorRepo extends JpaRepository<ManuscriptManagingEditor, Integer> {

	@Query("Select mme from ManuscriptManagingEditor mme where mme.journalId=:journalId AND mme.manuscriptId=:manuScriptId")
	List<ManuscriptManagingEditor> getByJournalAndManuscriptId(Integer manuScriptId, Integer journalId);
}
