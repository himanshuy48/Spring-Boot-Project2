package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.JournalChargeDetails;
import com.digi.uniprr.repository.JournalChargeDetailsRepo;
import com.digi.uniprr.service.JournalChargeDetailsService;

@Service
@Transactional
public class JournalChargeDetailsServiceImpl implements JournalChargeDetailsService {

	@Autowired
	JournalChargeDetailsRepo journalChargeDetailsRepo;

	@Override
	public void createJournalChargeDetails(JournalChargeDetails journalChargeDetails) {
		journalChargeDetailsRepo.save(journalChargeDetails);
	}

	@Override
	public List<JournalChargeDetails> getJournalChargeDetailsList() {
		return journalChargeDetailsRepo.findAll();
	}

	@Override
	public JournalChargeDetails getJournalChargeDetailsById(JournalChargeDetails journalChargeDetails) {
		JournalChargeDetails journalChargeDetail = journalChargeDetailsRepo.getJournalChargeDetailsByJournal(journalChargeDetails.getJournalId());
		return journalChargeDetail;
	}

	@Override
	public void updateJournalChargeDetails(JournalChargeDetails journalChargeDetails) {
		journalChargeDetailsRepo.save(journalChargeDetails);
	}

	@Override
	public boolean isExist(Integer journalChargeId) {
		return journalChargeDetailsRepo.existsById(journalChargeId);
	}

}
