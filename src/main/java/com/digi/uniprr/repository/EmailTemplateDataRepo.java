package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.EmailTemplateData;

public interface EmailTemplateDataRepo extends JpaRepository<EmailTemplateData, Integer>{

	@Query("SELECT u FROM EmailTemplateData u WHERE u.key=:key")
	List<EmailTemplateData> getEmailTemplateData(String key);
}
