package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Keywords;

import javassist.compiler.ast.Keyword;

public interface KeywordsRepo extends JpaRepository<Keywords, Integer> {

	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM Keywords key WHERE key.id=:id")
	public void deleteKeyword(Integer id);

	public Keywords save(Keyword keywords);

	@Query("SELECT k FROM Keywords k WHERE k.id=:id")
	public List<Keywords> getKeywordsListById(Integer id);

	@Query("SELECT k FROM Keywords k WHERE k.journalId=:id AND k.isActive=1")
	public List<Keywords> getKeywordsById(Integer id);

	@Query("SELECT k FROM Keywords k WHERE k.journalId= null OR k.type='JOURNALSPECIFIC , USERSPECIFIC'")
	public List<Keywords> getKeywordsDetails();

	@Query("SELECT k FROM Keywords k WHERE k.journalId=:journalId")
	public List<Keywords> getKeywordsByJournalId(Integer journalId);

	@Query("select  k FROM Keywords k where k.id IN :keywordId AND k.isActive=1")
	public List<Keywords> getKeywordListByIdList(List<Integer> keywordId);

	@Modifying
	@Query("UPDATE Keywords k set k.isActive=0 where k.id=:id")
	public void deleteKeywordById(Integer id);
	
	@Query("SELECT k FROM Keywords k WHERE k.keyword=:keyword")
	public void getUniqueKeywordForManuscript(String keyword);

}
