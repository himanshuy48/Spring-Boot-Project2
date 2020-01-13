package com.digi.uniprr.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.digi.uniprr.VO.CommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerCommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerVO;
import com.digi.uniprr.VO.ReviewerAvailabilityStatusVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.ManuScriptReviewer;

public interface ManuScriptReviewerService {

	public String addReviewerDeatils(ManuScriptReviewer manuScriptReviewer);

	String updateReviewerDeatils(ManuScriptReviewerVO manuScriptReviewerVo);

	public boolean isExist(Integer manuscriptId, Integer reviewerId, Integer manuscriptVersion);

	JSONObject saveManuScriptReviewer(ManuScriptReviewerVO manuScriptReviewerVo);

	String addAllDetailsMultipleTableRCC(ManuScriptReviewerCommonVO manuScriptReviewerCommonVO);

	public List<ManuScriptReviewer> getManuscriptReviewer(UserJournalManuscriptVo userJournalManuscriptVo);

	public List<ManuScriptReviewer> getManuscriptReviewerListById(UserJournalManuscriptVo userJournalManuscriptVo);

	public void saveManuScriptReviewerDetails(ManuScriptReviewer manuscriptReviewer);

	public List<ManuScriptReviewerCommonVO> getReviewerByManuScriptIdAndVersion(Integer manuscriptId, Integer manuscriptVersion);

	public List<ReviewerAvailabilityStatusVO> getReviewerDataById(CommonVO id);

	public List<ManuScriptReviewerCommonVO> getReviewerDataByManuscriptVersion(Integer manuscriptId, Integer manuscriptVersion,
			Integer journalId);

	public List<ManuScriptReviewerCommonVO> getAssignedReviewer(Integer manuscriptId, Integer manuscriptVersion,
			Integer journalId);

}