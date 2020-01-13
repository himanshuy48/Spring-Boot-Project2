package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.JournalListVO;

public interface AutoCompleteService {
	
	List<JournalListVO> getJournalList(IDVO name);

	List<IDVO> getExpertiseList(IDVO name);

	List<IDVO> getSpecialization(IDVO name);
	
	List<IDVO> getInstitution();
}
