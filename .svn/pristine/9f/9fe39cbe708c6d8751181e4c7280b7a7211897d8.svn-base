package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.ManuScriptEditorCommonVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.ManuscriptEditor;

public interface ManuscriptEditorService {

	public void createManuscriptEditor(ManuscriptEditor manuscriptEditor);

	public List<ManuscriptEditor> getManuscriptEditor(UserJournalManuscriptVo userJournalManuscriptVo);

	public List<ManuscriptEditor> getManuscriptEditorListById(UserJournalManuscriptVo userJournalManuscriptVo);

	public void saveManuScriptReviewerDetails(ManuscriptEditor manuscriptEditor);

	public void updateEditorDetails(ManuscriptListVO manuscriptListVO);

	public ManuscriptEditor findManuscriptEditorDetails(Integer manuScriptId, Integer manuscriptVersion,
			Integer journalId, Integer userId, Integer assignToId);
	
	public String addAllDetailsMultipleTableRCC(ManuScriptEditorCommonVO manuScriptEditorCommonVO);

	public void addsendBackToAuthor(ManuScriptEditorCommonVO manuScriptEditorCommonVO);
}
