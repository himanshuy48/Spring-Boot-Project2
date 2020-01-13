package com.digi.uniprr.serviceImpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptManagingEditorChecklistVO;
import com.digi.uniprr.model.ManuScriptReviewerChecklist;
import com.digi.uniprr.model.ManuscriptManagingEditorChecklist;
import com.digi.uniprr.repository.ManuscriptManagingEditorChecklistRepo;
import com.digi.uniprr.service.ManuscriptManagingEditorChecklistService;

@Service
@Transactional
public class ManuscriptManagingEditorChecklistServiceImpl implements ManuscriptManagingEditorChecklistService {

	@Autowired
	ManuscriptManagingEditorChecklistRepo manuscriptManagingEditorChecklistRepo;
	
	@Override
	public String addManagingEditorChecklistDeatils(ManuscriptManagingEditorChecklist manuscriptManagingEditorChecklist) {
		manuscriptManagingEditorChecklistRepo.save(manuscriptManagingEditorChecklist);
		return "Added Data Successfully";
	}

	@Override
	public String updateManagingEditorChecklistDeatils(ManuscriptManagingEditorChecklistVO manuscriptManagingEditorChecklistVO) {
		List<ManuscriptManagingEditorChecklist> data = manuscriptManagingEditorChecklistRepo.getmanuScriptManagingEditorById(manuscriptManagingEditorChecklistVO.getManuscriptId(),manuscriptManagingEditorChecklistVO.getManagingeditorId(),manuscriptManagingEditorChecklistVO.getManuscriptVersion());
		ManuscriptManagingEditorChecklist manuscriptManagingEditorChecklist = data.get(0);
		
		ManuscriptManagingEditorChecklist manuScriptManagingEditorChecklistData = manuscriptManagingEditorChecklistRepo.getOne(manuscriptManagingEditorChecklist.getId());
		if (manuscriptManagingEditorChecklistVO.getChkId() != null) {
			manuScriptManagingEditorChecklistData.setChkId(manuscriptManagingEditorChecklistVO.getChkId());
		}
		if (manuscriptManagingEditorChecklistVO.getChckComments() != null) {
			manuScriptManagingEditorChecklistData.setChckComments(manuscriptManagingEditorChecklistVO.getChckComments());
		}
		if (manuscriptManagingEditorChecklistVO.getUpdatedOn() != null) {
			manuScriptManagingEditorChecklistData.setUpdatedOn(manuscriptManagingEditorChecklistVO.getUpdatedOn());
		}
		if (manuscriptManagingEditorChecklistVO.getUpdatedBy() != null) {
			manuScriptManagingEditorChecklistData.setUpdatedBy(manuscriptManagingEditorChecklistVO.getUpdatedBy());
		}
		if (manuscriptManagingEditorChecklistVO.getIsActive() != null) {
			manuScriptManagingEditorChecklistData.setIsActive(manuscriptManagingEditorChecklistVO.getIsActive());
		}

		manuscriptManagingEditorChecklistRepo.save(manuScriptManagingEditorChecklistData);
		return "Updated Data Sucessfully";
	}

	@Override
	public boolean isExist(Integer manuscriptId, Integer managingeditorId,Integer manuscriptVersion) {
		List<ManuscriptManagingEditorChecklist> isExist = manuscriptManagingEditorChecklistRepo.getmanuScriptManagingEditorById(manuscriptId, managingeditorId, manuscriptVersion);
		if (isExist != null ||  isExist.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String addAllDetailsMultipleTable(ManuscriptManagingEditorChecklistVO manuscriptManagingEditorChecklistVO) {
		for ( int i = 0; i <= manuscriptManagingEditorChecklistVO.getManagingEditor().size() - 1; i++)
		{
		  ManuscriptManagingEditorChecklist saved1 = new ManuscriptManagingEditorChecklist();
		  saved1.setManuscriptId(manuscriptManagingEditorChecklistVO.getManuscriptId());
		  saved1.setManuscriptVersion(manuscriptManagingEditorChecklistVO.getManuscriptVersion());
		  saved1.setManagingeditorId(manuscriptManagingEditorChecklistVO.getManagingeditorId());
		  saved1.setChkId(manuscriptManagingEditorChecklistVO.getManagingEditor().get(i).getChkId());
		  saved1.setChkType(manuscriptManagingEditorChecklistVO.getManagingEditor().get(i).getChkType());
		  saved1.setChckComments(manuscriptManagingEditorChecklistVO.getManagingEditor().get(i).getChckComments());
		  saved1.setCreatedBy(manuscriptManagingEditorChecklistVO.getCreatedBy());
		  saved1.setCreatedOn(manuscriptManagingEditorChecklistVO.getCreatedOn());
		  saved1.setUpdatedBy(manuscriptManagingEditorChecklistVO.getUpdatedBy());
		  saved1.setUpdatedOn(manuscriptManagingEditorChecklistVO.getUpdatedOn());
		  saved1.setIsActive(manuscriptManagingEditorChecklistVO.getIsActive());
		  manuscriptManagingEditorChecklistRepo.save(saved1);
		}
		return "Data SuccessFully Inserted....";
	}

}
