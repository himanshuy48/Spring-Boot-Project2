package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuscriptEditorComments;

public interface ManuscriptEditorCommentsRepo extends JpaRepository<ManuscriptEditorComments, Integer>{

	@Modifying(clearAutomatically = true)
	@Query("update ManuscriptEditorComments wrs set wrs.status =:statusCode,wrs.comments=:comments where wrs.manuscriptId =:manuscriptId and wrs.manuscriptVersion=:manuscriptVersion")
	void updateManuScriptEditorComments(Integer manuscriptId,Integer manuscriptVersion,Integer statusCode,String comments);

	@Query("SELECT mec from ManuscriptEditorComments mec WHERE mec.manuscriptId=:id")
	List<ManuscriptEditorComments> getManuscriptEditorCommentsById(Integer id);

	@Query(value = "SELECT * FROM manuscript_editor_comments r WHERE r.manuscript_id=:manuscriptId AND r.editor_id=:editorId AND r.manuscript_version=:manuscriptVersion", nativeQuery = true)
	List<ManuscriptEditorComments> addsendBackToAuthor(Integer manuscriptId, Integer editorId,Integer manuscriptVersion);
	
}
