package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalconfigFileUpload;

public interface JournalconfigFileUploadRepo extends JpaRepository<JournalconfigFileUpload, Integer>{

	@Query("select m from JournalconfigFileUpload m where m.id=:id")
	public JournalconfigFileUpload JournalconfigFileByID(Integer id);
	
	@Query("select m from JournalconfigFileUpload m where m.journalId=:journalId")
	public List<JournalconfigFileUpload> getFileList(Integer journalId);
	
	@Modifying
	@Query("update JournalconfigFileUpload m set m.docType=:docType where m.id=:id")
	void updateJournalconfigFileUpload(Integer id, String docType);
	
	
}
