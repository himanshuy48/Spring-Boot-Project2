package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalEditorMapping;

public interface JournalEditorMappingRepo extends JpaRepository<JournalEditorMapping, Integer>{
	
	@Query("select j from JournalEditorMapping j where j.groupId=:id")
	public JournalEditorMapping getJournalEditorMappingById(Integer id);
}
