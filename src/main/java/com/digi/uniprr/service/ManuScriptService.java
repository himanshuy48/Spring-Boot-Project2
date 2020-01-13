package com.digi.uniprr.service;

import java.util.Date;
import java.util.List;

import com.digi.uniprr.VO.AuthorDashboardVO;
import com.digi.uniprr.VO.EditorDashboardVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManuScriptVO;
import com.digi.uniprr.VO.ManuscriptCoAuthorVO;
import com.digi.uniprr.VO.ManuscriptEditorVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ManuscriptTypeJournalVO;
import com.digi.uniprr.VO.ManuscriptTypeTitleAbstractVO;
import com.digi.uniprr.VO.ReviewerDecisionVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptTypeDetails;

public interface ManuScriptService {

//List<ManuScript> getJournalId = null;
//List<ManuScript> getJournalId(Integer authorId);

public List<ManuScript> getManuScriptList();

public ManuScript createManuScript(ManuScript manuScript);

public String updateManuScript(ManuScript manuScript);

public String deleteManuScriptById(Integer id);

public boolean isExist(Integer id);

public List<ManuScript> getManuScriptListById(Integer id);

public void updateStage(ManuScript manuScript);

public List<ManuScript> getListByStatusId(Integer manuscriptId);

public List<ManuScript> trackManuScript(Integer id);

public List<ManuScript> gettrackManuScriptList(Integer id, Integer journalId, Date date);

public List<ManuScript> gettrackManuScriptListDate(String submissionDateTo, String submissionDateFrom);

public List<ManuScript> gettrackManuScriptListTitle(String manuscriptTitle);

public List<ManuScript> gettrackManuScriptListCode(String manuscriptCode);

public List<ManuScript> gettrackManuScriptJtitle(String journalTitle);

public List<ManuScript> getAllManuScriptRecord();

// Reviewer Dashboard
public List<ManuScript> reviewerInvitationList(Integer reviewerId);

public List<ManuScript> reviewerReviewList(Integer reviewerId);

public List<ManuScript> reviewerRevisionList(Integer reviewerId);

public List<ManuScript> reviewerCompletedList(Integer reviewerId);

public void reviewerAccept(IDVO vo);

public void reviewerReject(IDVO vo);

//Author Dashboard
public List<AuthorDashboardVO> authorTask(Integer authorId);

public List<AuthorDashboardVO> authorUnderReview(Integer authorId); 

public List<AuthorDashboardVO> authorManuscriptAccepted(Integer authorId);

public List<AuthorDashboardVO> authorManuscriptRejected(Integer authorId);

//Editor Dashboard
public List<ManuScript> getEditorSubmitted(Integer id);

public List<ManuScript> getEditorReSubmitted(Integer groupId);

public List<ManuScriptReviewer> getEditorSentForReview(Integer groupId);

public List<ManuScriptReviewer> getEditorAllList(Integer groupId);

//
public String updateManuScriptEditor(ManuscriptEditorVO manuscriptEditorVO);

public List<ManuScript> getUniqueManuScript(Integer journalId);

public List<ManuscriptListVO> getManuscriptByStatus(ManuscriptListVO manuscriptVO);

public List<EditorDashboardVO> getManuscriptByData(UserJournalManuscriptVo userJournalManuscriptVo);

public List<EditorDashboardVO> getAssignedManuscriptData(UserJournalManuscriptVo userJournalManuscriptVo);

public void saveManuscriptDetails(ManuScript manuscriptData);

public List<ManuscriptTypeJournalVO> getManuscriptTypeJournalListByJournalId(Integer manuscriptId);

/***********Manuscript Author Form save**********/
public ManuscriptTypeTitleAbstractVO getManuscriptTypeAbstractDetails(IDVO vo);

public void saveTypeTitleAbstractDetails(ManuscriptTypeTitleAbstractVO vo);

public List<ManuscriptCoAuthorVO> getCoAuthorList(Integer manuscriptId);

public void saveCoAuthorOrderList(List<ManuscriptCoAuthorVO> voList);

public ManuscriptTypeDetails getManuscriptTypeDetailsByManuscriptId(Integer manuscriptId);

public void saveWordCountDetails(ManuScriptVO vo);

public void deleteCoAuthor(Integer authorId);

public void submitManuscript(ManuScriptVO vo);

public List<ReviewerDecisionVO> getReviewerDecision(UserJournalManuscriptVo userJournalManuscriptVo);

public void resubmissionSaveTypeTitleAbstract(ManuscriptTypeTitleAbstractVO vo);

public void resubmissionSaveWordCountDetails(ManuScriptVO vo);

}