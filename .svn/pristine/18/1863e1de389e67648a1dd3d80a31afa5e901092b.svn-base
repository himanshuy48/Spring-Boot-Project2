package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.MailTemplates;

public interface MailTemplatesRepo extends JpaRepository<MailTemplates, Integer> {

	@Query("select m from MailTemplates m where m.emailTemplateId=:id")
	List<MailTemplates> getMailTemplatesById(Integer id);
	
	@Query("SELECT m FROM MailTemplates m WHERE m.isActive=1")
	List<MailTemplates> getActiveMailTemplates();
	
	@Query("UPDATE MailTemplates m SET m.isActive=0 WHERE m.emailTemplateId=:id")
	@Modifying
	void deleteMailTemplate(Integer id);
	

}
