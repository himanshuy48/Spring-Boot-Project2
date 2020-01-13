package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuscriptManagingEditorComments;

public interface ManuscriptManagingEditorCommentsRepo extends JpaRepository<ManuscriptManagingEditorComments, Integer> {

	@Query("SELECT mec FROM ManuscriptManagingEditorComments mec WHERE mec.id=:id")
	List<ManuscriptManagingEditorComments> getManuscriptManagingEditorCommentsById(Integer id);

}
