package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptReviewerChecklistVO;
import com.digi.uniprr.model.ManuScriptReviewerChecklist;
import com.digi.uniprr.repository.ManuscriptReviewerChecklistRepo;
import com.digi.uniprr.service.ManuscriptReviewerChecklistService;

@Service
@Transactional
public class ManuscriptReviewerChecklistServiceImpl implements ManuscriptReviewerChecklistService {

	@Autowired
	ManuscriptReviewerChecklistRepo manuscriptReviewerChecklistRepo;
	
	@Override
	public String addReviewerChecklistDeatils(ManuScriptReviewerChecklist manuScriptReviewerChecklist) {
		manuscriptReviewerChecklistRepo.save(manuScriptReviewerChecklist);
		return "Added Data Successfully";
	}

	@Override
	public String updateReviewerChecklistDeatils(ManuscriptReviewerChecklistVO manuscriptReviewerChecklistVO) {
		List<ManuScriptReviewerChecklist> data = manuscriptReviewerChecklistRepo.getmanuScriptReviewerById(manuscriptReviewerChecklistVO.getManuscriptId(), manuscriptReviewerChecklistVO.getReviewerId());
		
		ManuScriptReviewerChecklist manuscriptReviewerChecklist = data.get(0);
		
		ManuScriptReviewerChecklist manuScriptReviewerChecklistData = manuscriptReviewerChecklistRepo.getOne(manuscriptReviewerChecklist.getId());
		if (manuscriptReviewerChecklistVO.getManuscriptVersion() != null) {
			manuScriptReviewerChecklistData.setManuscriptVersion(manuscriptReviewerChecklistVO.getManuscriptVersion());
		}
		if (manuscriptReviewerChecklistVO.getChkId() != null) {
			manuScriptReviewerChecklistData.setChkId(manuscriptReviewerChecklistVO.getChkId());
		}
		if (manuscriptReviewerChecklistVO.getChckComments() != null) {
			manuScriptReviewerChecklistData.setChckComments(manuscriptReviewerChecklistVO.getChckComments());
		}
		if (manuscriptReviewerChecklistVO.getUpdatedOn() != null) {
			manuScriptReviewerChecklistData.setUpdatedOn(manuscriptReviewerChecklistVO.getUpdatedOn());
		}
		if (manuscriptReviewerChecklistVO.getUpdatedBy() != null) {
			manuScriptReviewerChecklistData.setUpdatedBy(manuscriptReviewerChecklistVO.getUpdatedBy());
		}

		manuscriptReviewerChecklistRepo.save(manuScriptReviewerChecklistData);
		return "Updated Data Sucessfully";
	}

	@Override
	public boolean isExist(Integer manuscriptId, Integer reviewerId) {
		List<ManuScriptReviewerChecklist> isExist = manuscriptReviewerChecklistRepo.getmanuScriptReviewerById(manuscriptId, reviewerId);

		if (isExist != null || isExist.isEmpty()) {
			return true;
		}
		return false;
	}

}
