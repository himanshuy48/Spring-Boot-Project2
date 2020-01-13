package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.KeywordsVO;
import com.digi.uniprr.model.KeywordMaster;
import com.digi.uniprr.model.Keywords;
import com.digi.uniprr.repository.KeywordMasterRepo;
import com.digi.uniprr.repository.KeywordsRepo;
import com.digi.uniprr.service.KeywordsService;
import com.digi.uniprr.utils.KeywordsTransformationUtils;

@Service
@Transactional
public class KeywordsServiceImpl implements KeywordsService {

	@Autowired
	KeywordsRepo keywordsRepo;

	@Autowired
	KeywordMasterRepo keywordMasterRepo;

	@Override
	public Keywords createKeywords(Keywords keywords) {
		return keywordsRepo.save(keywords);
	}

	@Override
	public List<Keywords> getKeywordsList() {
		return keywordsRepo.findAll();
	}

	@Override
	public List<Keywords> getKeywordsListById(Integer id) {
		return keywordsRepo.getKeywordsListById(id);
	}

	@Override
	public boolean isExistByJournalId(Integer id) {
		boolean result = false;
		try {
			if (keywordsRepo.getKeywordsById(id).isEmpty())
				return true;
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	@Override
	public void updateKeywords(Keywords keywords) {
		keywordsRepo.save(keywords);
	}

	@Override
	public boolean isExist(Integer id) {
		return keywordsRepo.existsById(id);
	}

	@Override
	public List<Keywords> getDetails() {
		return keywordsRepo.getKeywordsDetails();

	}

	@Override
	public List<KeywordsVO> getKeywordsDetails() {
		List<KeywordsVO> arrayList = new ArrayList<>();
		List<Keywords> keywordsList = keywordsRepo.findAll();

		for (Keywords k : keywordsList) {
			KeywordsVO Vo = new KeywordsVO();
			Vo.setKeyword(k.getKeyword());
			Vo.setJournalId(k.getJournalId());
			Vo.setType(k.getType());
			arrayList.add(Vo);
		}

		return arrayList;
	}

	@Override
	public List<KeywordsVO> listByJournalId(IDVO id) {
		List<Keywords> data = keywordsRepo.getKeywordsById(id.getId());
		List<KeywordsVO> tempdata = KeywordsTransformationUtils.mapModelListToVOList(data);
		return tempdata;
	}

	@Override
	public void deleteKeyword(IDVO vo) {

		keywordsRepo.deleteKeywordById(vo.getId());
	}

	@Override
	public KeywordMaster getKeyeordMaster(IDVO id) {
		return keywordMasterRepo.getKeywordMaster(id.getId());
	}

	@Override
	public List<KeywordMaster> getKeyeordMasterList() {
		return keywordMasterRepo.getKeywordMasterList();
	}

	@Override
	public void updateKeywordMaster(KeywordMaster keywordMaster) {
		keywordMasterRepo.save(keywordMaster);
	}

	@Override
	public void deleteKeywordMaster(IDVO id) {
		keywordMasterRepo.deleteKeywordMaster(id.getId());
	}

	@Override
	public KeywordMaster cretaeKeywordMaster(KeywordMaster keywordMaster) {
		keywordMaster.setIsActive(1);
		KeywordMaster keywordMasterData = keywordMasterRepo.save(keywordMaster);
		return keywordMasterData;
	}

}
