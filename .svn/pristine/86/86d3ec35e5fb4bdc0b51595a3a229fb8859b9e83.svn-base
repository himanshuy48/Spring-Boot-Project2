package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuscriptEditorChecklist;

public interface ManuscriptEditorChecklistRepo extends JpaRepository<ManuscriptEditorChecklist, Integer>{
	
	@Query(value = "SELECT * FROM manuscript_editor_checklist r WHERE r.manuscript_id=:manuscriptId AND r.editor_id=:editorId", nativeQuery = true)
	List<ManuscriptEditorChecklist> getmanuScriptEditorById(Integer manuscriptId, Integer editorId);

}
