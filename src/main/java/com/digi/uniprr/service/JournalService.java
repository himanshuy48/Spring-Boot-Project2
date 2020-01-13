package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.JournalListVO;
import com.digi.uniprr.VO.JournalVO;
import com.digi.uniprr.model.Journal;
import com.digi.uniprr.model.JournalChargeDetails;

public interface JournalService 
{
    public String createJournal(Journal journals);
    
    public List<JournalListVO> getJournalDetails();
    
    public String updateJournal(Journal journals);
    
    public String deleteJournalById(Integer id);
    
    public boolean isIdExist(Integer id);

	public JournalVO getJournalById(Integer id);
	
	public JournalChargeDetails getJournalChargeDetailsByJournalId(Integer id);

}
