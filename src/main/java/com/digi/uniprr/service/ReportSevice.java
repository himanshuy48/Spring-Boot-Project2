package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManuScriptByJournalVo;
import com.digi.uniprr.VO.ReportVO;
import com.digi.uniprr.VO.ReviewerDataWithCommentVO;
import com.digi.uniprr.VO.ReviewerOverviewVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;

public interface ReportSevice {

	List<ReportVO> getReport(UserJournalManuscriptVo userJournalManuscriptVo);
	
	public List<ManuScriptByJournalVo> getManuScriptByJournal(ManuScriptByJournalVo manuScriptByJournalVo);
	
	public List<ReviewerOverviewVO> getReviewerOverview(Integer userId);
	
	public List<List<ReportVO>> getReportByUserId(IDVO userId);

	List<ReviewerDataWithCommentVO> getReviewerOverviewReport(IDVO userId);
	
	
}
