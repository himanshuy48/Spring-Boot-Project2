package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.ManuScriptKeywords;
import com.digi.uniprr.repository.ManuScriptKeywordsRepo;
import com.digi.uniprr.service.ManuScriptKeywordsService;

@Service
@Transactional
public class ManuScriptKeywordsServiceImpl implements ManuScriptKeywordsService {

	@Autowired
	ManuScriptKeywordsRepo  manuScriptKeywordsRepo;
	@Override
	public List<ManuScriptKeywords> getManuScriptKeywordsList() {
		return manuScriptKeywordsRepo.findAll();
		
	}

}
