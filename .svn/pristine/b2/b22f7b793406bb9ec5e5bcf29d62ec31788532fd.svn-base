package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.JournalKeyword;

public interface JournalKeywordRepo extends JpaRepository<JournalKeyword, Integer>{

	@Query("select m from JournalKeyword m where m.id=:journalId")
	public List<JournalKeyword> getJournalKeyWordList(Integer journalId);
}
