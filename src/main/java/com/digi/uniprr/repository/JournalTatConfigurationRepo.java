package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalTatConfiguration;

public interface JournalTatConfigurationRepo extends JpaRepository<JournalTatConfiguration, Integer>{

	@Query("SELECT jC FROM JournalTatConfiguration jC WHERE jC.journalId=:journalId")
	List<JournalTatConfiguration> journalTatConfiguration(Integer journalId);
}
