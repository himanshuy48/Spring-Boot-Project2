package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.KeywordsVO;
import com.digi.uniprr.model.KeywordMaster;
import com.digi.uniprr.model.Keywords;

public interface KeywordsService {

	Keywords createKeywords(Keywords keywords);

	List<Keywords> getKeywordsList();

	List<Keywords> getKeywordsListById(Integer id);

	boolean isExistByJournalId(Integer id);

	void updateKeywords(Keywords keywords);

	boolean isExist(Integer id);

	List<Keywords> getDetails();

	List<KeywordsVO> getKeywordsDetails();
	
	List<KeywordsVO> listByJournalId(IDVO id);
	
	//KeywordMaster
	
	KeywordMaster getKeyeordMaster(IDVO id);
	
	List<KeywordMaster> getKeyeordMasterList();
	
	void updateKeywordMaster(KeywordMaster keywordMaster);
	
	void deleteKeywordMaster(IDVO id);
	
	KeywordMaster cretaeKeywordMaster(KeywordMaster keywordMaster);

	void deleteKeyword(IDVO vo);

}
