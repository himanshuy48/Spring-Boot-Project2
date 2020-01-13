package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptEditor;

public interface ManuscriptEditorRepo extends JpaRepository<ManuscriptEditor, Integer> {

	@Query("SELECT m FROM ManuscriptEditor m WHERE m.manuscriptStatus=:manuscriptStatus AND m.editorId=:editorId AND m.journalId=:journalId")
	List<ManuscriptEditor> getManuscriptEditor(Integer manuscriptStatus, Integer editorId, Integer journalId);

	@Query("SELECT me FROM ManuscriptEditor me WHERE me.manuscriptStatus=:status AND me.journalId=:journalId")
	List<ManuscriptEditor> getManuscriptEditorById(Integer status, Integer journalId);

	@Modifying
	@Query("UPDATE ManuscriptEditor m SET m.manuscriptStatus=:manuscriptStatus")
	void updateDetails(Integer manuscriptStatus);

	@Query("SELECT me from ManuscriptEditor me where me.journalId=:journalId AND me.manuscriptId=:manuScriptId")
	List<ManuscriptEditor> getByJournalAndManuscript(Integer manuScriptId, Integer journalId);

	@Modifying
	@Query("UPDATE ManuscriptEditor me SET me.manuscriptStatus=:manuStatusId where me.id=:id")
	void updateEditorDetails(Integer manuStatusId, Integer id);

	@Query("SELECT me FROM ManuscriptEditor me WHERE me.manuscriptId=:manuScriptId AND me.manuscriptVersion=:manuscriptVersion AND me.journalId=:journalId AND me.editorId=:assignToId")
	ManuscriptEditor findManuscriptEditorDetails(Integer manuScriptId, Integer manuscriptVersion, Integer journalId,
			Integer assignToId);
	
	@Query(value = "SELECT * FROM manuscript_editor r WHERE r.manuscript_id=:manuscriptId AND r.editor_id=:editorId AND r.manuscript_version=:manuscriptVersion", nativeQuery = true)
	List<ManuscriptEditor> getmanuScriptEditorByIdAddMultiple(Integer manuscriptId, Integer editorId,Integer manuscriptVersion);
	
	@Query("SELECT me FROM ManuscriptEditor me WHERE me.manuscriptId=:manuScriptId AND me.manuscriptVersion=:manuscriptVersion AND me.journalId=:journalId AND me.editorId IN:assignToId")
	List<ManuscriptEditor> findManuscriptEditorDetailsList(Integer manuScriptId, Integer manuscriptVersion,
			Integer journalId, List<Integer> assignToId);
	
	@Modifying
	@Query("UPDATE ManuscriptEditor me SET me.manuscriptStatus=:manuStatusId where me.id IN:manuscriptReviewrId")
	void updateEditorDetailsList(Integer manuStatusId, List<Integer> manuscriptReviewrId);
	
	@Query("SELECT me FROM ManuscriptEditor me WHERE me.manuscriptId=:manuScriptId AND me.manuscriptVersion=:manuscriptVersion")
	List<ManuscriptEditor> getByVersion(Integer manuScriptId, Integer manuscriptVersion);

	@Query("SELECT me from ManuscriptEditor me WHERE me.editorId=:id")
	List<ManuscriptEditor> getManuscriptEditorById(Integer id);
}