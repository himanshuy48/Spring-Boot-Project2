package com.digi.uniprr.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.JournalsConfigurationVO;
import com.digi.uniprr.model.JournalManuscriptTypeCharge;
import com.digi.uniprr.repository.JournalManuscriptTypeChargeRepo;
import com.digi.uniprr.service.ManuscriptTypeChargeService;

@Service
@Transactional
public class JournalManuscriptTypeChargeServiceImpl implements ManuscriptTypeChargeService{
	
	@Autowired
	JournalManuscriptTypeChargeRepo journalManuscriptTypeChargeRepo;

	@Override
	public void saveJournalManuscriptTypeCharge(
			JournalsConfigurationVO journalsConfigurationVO) {
		
		for(JournalManuscriptTypeCharge data : journalsConfigurationVO.getManusriptTypeCharge()) {
			JournalManuscriptTypeCharge manuscriptTypeCharge = new JournalManuscriptTypeCharge();
			if(data!=null && data.getFixedCharges().equalsIgnoreCase("yes")) {
				manuscriptTypeCharge.setJournalId(data.getJournalId());
				manuscriptTypeCharge.setManuscriptTypeId(data.getManuscriptTypeId());
				manuscriptTypeCharge.setFixedCharges("Yes");
				manuscriptTypeCharge.setCurrency("USD");
				manuscriptTypeCharge.setFixedChargeAmount(data.getFixedChargeAmount());
				manuscriptTypeCharge.setIsActive(1);
			}else {
				manuscriptTypeCharge.setJournalId(data.getJournalId());
				manuscriptTypeCharge.setManuscriptTypeId(data.getManuscriptTypeId());
				manuscriptTypeCharge.setFixedCharges("No");
				manuscriptTypeCharge.setTablesCharges(data.getTablesCharges());
				manuscriptTypeCharge.setFigureCharges(data.getFigureCharges());
				manuscriptTypeCharge.setColorFigureCharges(data.getColorFigureCharges());
				manuscriptTypeCharge.setTypeSettingCharges(data.getTypeSettingCharges());
				manuscriptTypeCharge.setCurrency("USD");
				manuscriptTypeCharge.setAdditionalCharges(data.getAdditionalCharges());
				manuscriptTypeCharge.setIsActive(1);
			}
			journalManuscriptTypeChargeRepo.save(manuscriptTypeCharge);
		}
		
		//return journalManuscriptTypeChargeRepo.save(manuscriptTypeCharge);
	}

	@Override
	public JournalManuscriptTypeCharge updateJournalManuscriptTypeCharge(
			JournalManuscriptTypeCharge journalManuscriptTypeCharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteJournalManuscriptTypeCharge() {
		// TODO Auto-generated method stub
		
	}

}
