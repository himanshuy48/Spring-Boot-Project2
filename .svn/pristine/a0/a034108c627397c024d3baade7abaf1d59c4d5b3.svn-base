package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.ManuscriptKeywordsVO;
import com.digi.uniprr.model.ManuScriptKeywords;

public class ManuscriptKeywordsTransformationUtils {
	
	public static ManuscriptKeywordsVO mapModelToVo(ManuScriptKeywords manuscriptKeywords) {
		ManuscriptKeywordsVO vo = new ManuscriptKeywordsVO();
		vo.setId(manuscriptKeywords.getManukeyId());
		vo.setKeyword(manuscriptKeywords.getKeywords().getKeyword());
		return vo;
	}
	
	public static List<ManuscriptKeywordsVO> mapModelListToVoList(List<ManuScriptKeywords> list) {
		List<ManuscriptKeywordsVO> voList = new ArrayList<ManuscriptKeywordsVO>();
		for (ManuScriptKeywords keywords : list) 
			voList.add(mapModelToVo(keywords));
		
		return voList;
	}
	

}
