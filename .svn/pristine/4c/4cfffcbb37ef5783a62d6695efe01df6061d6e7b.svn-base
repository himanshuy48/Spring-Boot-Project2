package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuscriptManagingEditorChecklist;

public interface ManuscriptManagingEditorChecklistRepo extends JpaRepository<ManuscriptManagingEditorChecklist, Integer>{

	@Query(value = "SELECT * FROM manuscript_managingeditor_checklist r WHERE r.manuscript_id=:manuscriptId AND r.managingeditor_id=:managingeditorId AND r.manuscript_version=:manuscriptVersion", nativeQuery = true)
	List<ManuscriptManagingEditorChecklist> getmanuScriptManagingEditorById(Integer manuscriptId, Integer managingeditorId,Integer manuscriptVersion);
}
