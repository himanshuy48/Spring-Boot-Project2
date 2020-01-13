package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.JournalListVO;
import com.digi.uniprr.VO.JournalVO;
import com.digi.uniprr.model.Journal;
import com.digi.uniprr.model.JournalChargeDetails;
import com.digi.uniprr.repository.JournalChargeDetailsRepo;
import com.digi.uniprr.repository.JournalMetadataRepo;
import com.digi.uniprr.repository.JournalsRepo;
import com.digi.uniprr.service.JournalService;
import com.digi.uniprr.utils.JournalListTransformationUtils;
import com.digi.uniprr.utils.JournalTransformationUtils;

@Service
@Transactional
public class JournalServiceImpl implements JournalService {
	@Autowired
	JournalsRepo journalsRepo;
	
	@Autowired
	JournalMetadataRepo journalMetadataRepo;
	
	@Autowired
	JournalChargeDetailsRepo journalChargeDetailsRepo;

	@Override
	public String createJournal(Journal journals) {
		journalsRepo.save(journals);
		return "Journal updated";
	}

	@Override
	public List<JournalListVO> getJournalDetails() {
		List<Journal> list = journalsRepo.getActiveJournals();
		List<JournalListVO> voList = JournalListTransformationUtils.mapModelListToVoList(list);
		return voList;
	}

	@Override
	public String updateJournal(Journal journals) {
		journalsRepo.save(journals);
		return "Journal created";
	}

	@Override
	public String deleteJournalById(Integer id) {
		journalsRepo.deleteById(id);
		return "Journal deleted";
	}

	@Override
	public boolean isIdExist(Integer id) {

		return journalsRepo.existsById(id);
	}

	@Override
	public JournalVO getJournalById(Integer id) {
		JournalVO journalVo = null;
		Journal journalDetail = journalsRepo.getJournalById(id);
		if(journalDetail != null) {
			journalVo = JournalTransformationUtils.mapJournalModelToJournalVo(journalDetail);
		}
		
		return journalVo;
	}

	@Override
	public JournalChargeDetails getJournalChargeDetailsByJournalId(Integer id) {
		return journalChargeDetailsRepo.getJournalChargeDetailsByJournal(id);
	}


}