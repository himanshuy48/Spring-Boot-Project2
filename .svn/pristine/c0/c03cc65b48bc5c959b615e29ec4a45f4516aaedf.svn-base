package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.KeywordsVO;
import com.digi.uniprr.model.Keywords;

public class KeywordsTransformationUtils {
	
	public static Keywords mapVOToModel(KeywordsVO vo) {
		Keywords keywords = new Keywords();
		keywords.setId(vo.getId());
		keywords.setKeyword(vo.getKeyword());
		keywords.setJournalId(vo.getJournalId());
		keywords.setType(vo.getType());
		keywords.setIsActive(vo.getIsActive());
		return keywords;
	}
	
	public static KeywordsVO mapModelToVO(Keywords keywords) {
		KeywordsVO vo = new KeywordsVO();
		vo.setId(keywords.getId());
		vo.setKeyword(keywords.getKeyword());
		vo.setType(keywords.getType());
		vo.setJournalId(keywords.getJournalId());
		vo.setIsActive(keywords.getIsActive());
		return vo;
	}
	
	public static List<KeywordsVO> mapModelListToVOList(List<Keywords> keywordList) {
		List<KeywordsVO> voList = new ArrayList<KeywordsVO>();
		for (Keywords keywords : keywordList) 
			voList.add(mapModelToVO(keywords));
		
		return voList;
	}
	
	public static List<Keywords> mapVoListToModelList(List<KeywordsVO> voList) {
		List<Keywords> keywordList = new ArrayList<Keywords>();
		for (KeywordsVO vo : voList) 
			keywordList.add(mapVOToModel(vo));
		
		return keywordList;
	}

}
