package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptEditorChecklistVO;
import com.digi.uniprr.model.ManuscriptEditorChecklist;
import com.digi.uniprr.repository.ManuscriptEditorChecklistRepo;
import com.digi.uniprr.service.ManuscriptEditorChecklistService;

@Service
@Transactional
public class ManuscriptEditorChecklistServiceImpl implements ManuscriptEditorChecklistService {

	@Autowired
	ManuscriptEditorChecklistRepo manuscriptEditorChecklistRepo;
	
	@Override
	public String addEditorChecklistDeatils(ManuscriptEditorChecklist manuScriptEditorChecklist) {
		manuscriptEditorChecklistRepo.save(manuScriptEditorChecklist);
		return "Added Data Successfully";
	}

	@Override
	public String updateEditorChecklistDeatils(ManuscriptEditorChecklistVO manuscriptEditorChecklistVO) {
        List<ManuscriptEditorChecklist> data = manuscriptEditorChecklistRepo.getmanuScriptEditorById(manuscriptEditorChecklistVO.getManuscriptId(), manuscriptEditorChecklistVO.getEditorId());
        ManuscriptEditorChecklist manuscriptEditorChecklist = data.get(0);
		
		ManuscriptEditorChecklist manuScriptEditorChecklistData = manuscriptEditorChecklistRepo.getOne(manuscriptEditorChecklist.getId());
		if (manuscriptEditorChecklistVO.getManuscriptVersion() != null) {
			manuScriptEditorChecklistData.setManuscriptVersion(manuscriptEditorChecklistVO.getManuscriptVersion());
		}
		if (manuscriptEditorChecklistVO.getChkId() != null) {
			manuScriptEditorChecklistData.setChkId(manuscriptEditorChecklistVO.getChkId());
		}
		if (manuscriptEditorChecklistVO.getChckComments() != null) {
			manuScriptEditorChecklistData.setChckComments(manuscriptEditorChecklistVO.getChckComments());
		}
		if (manuscriptEditorChecklistVO.getUpdatedOn() != null) {
			manuScriptEditorChecklistData.setUpdatedOn(manuscriptEditorChecklistVO.getUpdatedOn());
		}
		if (manuscriptEditorChecklistVO.getUpdatedBy() != null) {
			manuScriptEditorChecklistData.setUpdatedBy(manuscriptEditorChecklistVO.getUpdatedBy());
		}
		
		if (manuscriptEditorChecklistVO.getIsActive() != null) {
			manuScriptEditorChecklistData.setIsActive(manuscriptEditorChecklistVO.getIsActive());
		}

		manuscriptEditorChecklistRepo.save(manuScriptEditorChecklistData);
		return "Updated Data Sucessfully";
    }

	@Override
	public boolean isExist(Integer manuscriptId, Integer editorId) {
		List<ManuscriptEditorChecklist> isExist = manuscriptEditorChecklistRepo.getmanuScriptEditorById(manuscriptId, editorId);

		if (isExist != null ||  isExist.isEmpty()) {
			return true;
		}
		return false;
	}

}
