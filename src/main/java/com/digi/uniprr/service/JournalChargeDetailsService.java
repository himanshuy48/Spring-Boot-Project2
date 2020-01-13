package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.JournalChargeDetails;

public interface JournalChargeDetailsService {

	public void createJournalChargeDetails(JournalChargeDetails journalChargeDetails);

	public List<JournalChargeDetails> getJournalChargeDetailsList();

	public JournalChargeDetails getJournalChargeDetailsById(JournalChargeDetails journalChargeDetails);

	public void updateJournalChargeDetails(JournalChargeDetails journalChargeDetails);

	public boolean isExist(Integer journalChargeId);

}
