package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptReviewerCommentsVO;
import com.digi.uniprr.model.ManuscriptReviewerComments;
import com.digi.uniprr.repository.ManuscriptReviewerCommentsRepo;
import com.digi.uniprr.service.ManuscriptReviewerCommentsService;

@Service
@Transactional
public class ManuscriptReviewerCommentsServiceImpl implements ManuscriptReviewerCommentsService {

	@Autowired
	ManuscriptReviewerCommentsRepo manuscriptReviewerCommentsRepo; 

	@Override
	public String addReviewerCommentsDeatils(ManuscriptReviewerComments manuScriptReviewerComments) {
		manuscriptReviewerCommentsRepo.save(manuScriptReviewerComments);
		return "Added Data Successfully";
	}

	@Override
	public boolean isExist(Integer manuscriptId, Integer reviewerId, Integer manuscriptVersion) {
		List<ManuscriptReviewerComments> isExist = manuscriptReviewerCommentsRepo.getmanuScriptReviewerById(manuscriptId, reviewerId, manuscriptVersion);

		if (isExist != null || isExist.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String updateReviewerDeatils(ManuscriptReviewerCommentsVO manuScriptReviewerCommentsVO) {
		List<ManuscriptReviewerComments> data = manuscriptReviewerCommentsRepo.getmanuScriptReviewerById(manuScriptReviewerCommentsVO.getManuscriptId(), manuScriptReviewerCommentsVO.getReviewerId(), manuScriptReviewerCommentsVO.getManuscriptVersion());
		ManuscriptReviewerComments manuScriptReviewerCommentsData1 = data.get(0);
		
		ManuscriptReviewerComments manuScriptReviewerCommentsData = manuscriptReviewerCommentsRepo.getOne(manuScriptReviewerCommentsData1.getId());
		if (manuScriptReviewerCommentsVO.getDecisionLetter() != null) {
			manuScriptReviewerCommentsData.setDecisionLetter(manuScriptReviewerCommentsVO.getDecisionLetter());
		}
		if (manuScriptReviewerCommentsVO.getCommentsToEditor() != null) {
			manuScriptReviewerCommentsData.setCommentsToEditor(manuScriptReviewerCommentsVO.getCommentsToEditor());
		}
		if (manuScriptReviewerCommentsVO.getCommentsToAuthor() != null) {
			manuScriptReviewerCommentsData.setCommentsToAuthor(manuScriptReviewerCommentsVO.getCommentsToAuthor());
		}
		if (manuScriptReviewerCommentsVO.getUpdatedOn() != null) {
			manuScriptReviewerCommentsData.setUpdatedOn(manuScriptReviewerCommentsVO.getUpdatedOn());
		}
		
		if (manuScriptReviewerCommentsVO.getUpdatedBy() != null) {
			manuScriptReviewerCommentsData.setUpdatedBy(manuScriptReviewerCommentsVO.getUpdatedBy());
		}

		manuscriptReviewerCommentsRepo.save(manuScriptReviewerCommentsData);
		return "Updated Data Sucessfully";
	}

	

	@Override
	public List<ManuscriptReviewerComments> getManuscriptReviewerCommentsById(Integer id) {
		
		return manuscriptReviewerCommentsRepo.getManuscriptReviewerCommentsById(id);
	}

}
