package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuScriptEditorCommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerCommonVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuScriptReviewerChecklist;
import com.digi.uniprr.model.ManuscriptEditor;
import com.digi.uniprr.model.ManuscriptEditorChecklist;
import com.digi.uniprr.model.ManuscriptEditorComments;
import com.digi.uniprr.model.ManuscriptReviewerComments;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.ManuscriptEditorChecklistRepo;
import com.digi.uniprr.repository.ManuscriptEditorCommentsRepo;
import com.digi.uniprr.repository.ManuscriptEditorRepo;
import com.digi.uniprr.service.ManuscriptEditorService;

@Service
@Transactional
public class ManuscriptEditorServiceImpl implements ManuscriptEditorService {

	@Autowired
	ManuscriptEditorRepo manuscriptEditorRepo;
	
	@Autowired
	ManuscriptEditorChecklistRepo manuscriptEditorChecklistRepo;
	
	@Autowired
	ManuscriptEditorCommentsRepo manuscriptEditorCommentsRepo;
	
	@Autowired
	ManuScriptRepo manuScriptRepo;
	

	@Override
	public void createManuscriptEditor(ManuscriptEditor manuscriptEditor) {
		manuscriptEditorRepo.save(manuscriptEditor);

	}

	@Override
	public List<ManuscriptEditor> getManuscriptEditor(UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ManuscriptEditor> dataList = new ArrayList<>();
		for (Integer statusList : userJournalManuscriptVo.getManuscriptStatusId()) {
			List<ManuscriptEditor> list = new ArrayList<>();
			Integer status = statusList;
			list = manuscriptEditorRepo.getManuscriptEditor(status, userJournalManuscriptVo.getUserId(),
					userJournalManuscriptVo.getJournalId());
			if (list != null && !list.isEmpty()) {
				for (ManuscriptEditor listOfData : list) {
					dataList.add(listOfData);
				}
			}

		}
		return dataList;
	}

	@Override
	public List<ManuscriptEditor> getManuscriptEditorListById(UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ManuscriptEditor> dataList = new ArrayList<>();
		if (userJournalManuscriptVo.getJournalId() != null && userJournalManuscriptVo.getManuscriptStatusId() != null) {
			for (Integer statusList : userJournalManuscriptVo.getManuscriptStatusId()) {
				List<ManuscriptEditor> list = new ArrayList<>();
				Integer status = statusList;
				list = manuscriptEditorRepo.getManuscriptEditorById(status, userJournalManuscriptVo.getJournalId());
				if (list != null && !list.isEmpty()) {
					for (ManuscriptEditor listOfData : list) {
						dataList.add(listOfData);
					}
				}
			}
		}
		return dataList;
	}

	@Override
	public void saveManuScriptReviewerDetails(ManuscriptEditor manuscriptEditor) {
		manuscriptEditorRepo.save(manuscriptEditor);
	}

	@Override
	public void updateEditorDetails(ManuscriptListVO manuscriptListVO) {
		manuscriptEditorRepo.updateEditorDetails(manuscriptListVO.getManuStatusId(), manuscriptListVO.getManuScriptId());
	}

	@Override
	public ManuscriptEditor findManuscriptEditorDetails(Integer manuScriptId, Integer manuscriptVersion,
			Integer journalId, Integer userId, Integer assignToId) {
		return manuscriptEditorRepo.findManuscriptEditorDetails(manuScriptId, manuscriptVersion, journalId,
				assignToId);
	}

	@Override
	public String addAllDetailsMultipleTableRCC(ManuScriptEditorCommonVO manuScriptEditorCommonVO) {

			List<ManuscriptEditor> data =  manuscriptEditorRepo.getmanuScriptEditorByIdAddMultiple(
					manuScriptEditorCommonVO.getManuscriptId(), manuScriptEditorCommonVO.getEditorId(),
					manuScriptEditorCommonVO.getManuscriptVersion());

			if (data != null && !data.isEmpty()) {
				ManuscriptEditor manuScriptEditorData1 = data.get(0);
				ManuscriptEditor manuScriptEditorData =  manuscriptEditorRepo.getOne(manuScriptEditorData1.getId());

				if (manuScriptEditorCommonVO.getManuscriptStatus() != null) {
					manuScriptEditorData.setManuscriptStatus(manuScriptEditorCommonVO.getManuscriptStatus());
				}
				if (manuScriptEditorCommonVO.getDueDate() != null) {
					manuScriptEditorData.setDueDate(manuScriptEditorCommonVO.getDueDate());
				}
				if (manuScriptEditorCommonVO.getJournalId() != null) {
					manuScriptEditorData.setJournalId(manuScriptEditorCommonVO.getJournalId());
				}
				if (manuScriptEditorCommonVO.getDecisionLetter() != null) {
					manuScriptEditorData.setDecisionLetter(manuScriptEditorCommonVO.getDecisionLetter());
				}
				if (manuScriptEditorCommonVO.getCommentsForEditor() != null) {
					manuScriptEditorData.setCommentsForEditor(manuScriptEditorCommonVO.getCommentsForEditor());
				}
				if (manuScriptEditorCommonVO.getCommentsForAuthor() != null) {
					manuScriptEditorData.setCommentsForAuthor(manuScriptEditorCommonVO.getCommentsForAuthor());
				}
				if (manuScriptEditorCommonVO.getCommentsForReviewer() != null) {
					manuScriptEditorData.setCommentsForReviewer(manuScriptEditorCommonVO.getCommentsForReviewer());
				}
				if (manuScriptEditorCommonVO.getCommentsForManagingEditor() != null) {
					manuScriptEditorData.setCommentsForManagingEditor(manuScriptEditorCommonVO.getCommentsForManagingEditor());
				}
				if (manuScriptEditorCommonVO.getCreatedBy() != null) {
					manuScriptEditorData.setCreatedBy(manuScriptEditorCommonVO.getCreatedBy());
				}
				if (manuScriptEditorCommonVO.getCreatedOn() != null) {
					manuScriptEditorData.setCreatedOn(manuScriptEditorCommonVO.getCreatedOn());
				}
				if (manuScriptEditorCommonVO.getUpdatedBy() != null) {
					manuScriptEditorData.setUpdatedBy(manuScriptEditorCommonVO.getUpdatedBy());
				}
				if (manuScriptEditorCommonVO.getUpdatedOn() != null) {
					manuScriptEditorData.setUpdatedOn(manuScriptEditorCommonVO.getUpdatedOn());
				}
				if (manuScriptEditorCommonVO.getIsActive() != null) {
					manuScriptEditorData.setIsActive(manuScriptEditorCommonVO.getIsActive());
				}
				manuscriptEditorRepo.save(manuScriptEditorData);
			} else {
				ManuscriptEditor manuScriptEditorData = new ManuscriptEditor();
				manuScriptEditorData.setManuscriptId(manuScriptEditorCommonVO.getManuscriptId());
				manuScriptEditorData.setManuscriptVersion(manuScriptEditorCommonVO.getManuscriptVersion());
				manuScriptEditorData.setEditorId(manuScriptEditorCommonVO.getEditorId());
				manuScriptEditorData.setManuscriptStatus(manuScriptEditorCommonVO.getManuscriptStatus());
				manuScriptEditorData.setJournalId(manuScriptEditorCommonVO.getJournalId());
				manuScriptEditorData.setDecisionLetter(manuScriptEditorCommonVO.getDecisionLetter());
				manuScriptEditorData.setCommentsForAuthor(manuScriptEditorCommonVO.getCommentsForAuthor());
				manuScriptEditorData.setCommentsForEditor(manuScriptEditorCommonVO.getCommentsForEditor());
				manuScriptEditorData.setCommentsForReviewer(manuScriptEditorCommonVO.getCommentsForReviewer());
				manuScriptEditorData.setCommentsForManagingEditor(manuScriptEditorCommonVO.getCommentsForManagingEditor());
				manuScriptEditorData.setCreatedBy(manuScriptEditorCommonVO.getCreatedBy());
				manuScriptEditorData.setCreatedOn(manuScriptEditorCommonVO.getCreatedOn());
				manuScriptEditorData.setUpdatedBy(manuScriptEditorCommonVO.getUpdatedBy());
				manuScriptEditorData.setUpdatedOn(manuScriptEditorCommonVO.getUpdatedOn());
				manuScriptEditorData.setIsActive(manuScriptEditorCommonVO.getIsActive());
				manuscriptEditorRepo.save(manuScriptEditorData);

			}

			for (int i = 0; i <= manuScriptEditorCommonVO.getEditor().size() - 1; i++) {
				ManuscriptEditorChecklist saved1 = new ManuscriptEditorChecklist();
				saved1.setManuscriptId(manuScriptEditorCommonVO.getManuscriptId());
				saved1.setManuscriptVersion(manuScriptEditorCommonVO.getManuscriptVersion());
				saved1.setEditorId(manuScriptEditorCommonVO.getEditorId());
				saved1.setChkId(manuScriptEditorCommonVO.getEditor().get(i).getChkId());
				saved1.setChkType(manuScriptEditorCommonVO.getEditor().get(i).getChkType());
				saved1.setChckComments(manuScriptEditorCommonVO.getEditor().get(i).getChckComments());
				saved1.setCreatedBy(manuScriptEditorCommonVO.getCreatedBy());
				saved1.setCreatedOn(manuScriptEditorCommonVO.getCreatedOn());
				saved1.setUpdatedBy(manuScriptEditorCommonVO.getUpdatedBy());
				saved1.setUpdatedOn(manuScriptEditorCommonVO.getUpdatedOn());
				manuscriptEditorChecklistRepo.save(saved1);
			}

			return "Data Insert Succesfully";
	 }

	@Override
	public void addsendBackToAuthor(ManuScriptEditorCommonVO manuScriptEditorCommonVO) {
		List<ManuScript> Data1 = manuScriptRepo.getAllDetails(manuScriptEditorCommonVO.getManuscriptId());
		

		if(Data1 != null && !Data1.isEmpty())
		{
			ManuScript manuData1 = Data1.get(0);
			ManuScript manuData =  manuScriptRepo.getOne(manuData1.getManuScriptId());
			
			if (manuScriptEditorCommonVO.getManuscriptStatus() != null) {
				manuData.setManuscriptStatusId(manuScriptEditorCommonVO.getManuscriptStatus());
			}
			
			if (manuScriptEditorCommonVO.getUpdatedOn() != null) {
				manuData.setUpdatedOn(manuScriptEditorCommonVO.getUpdatedOn());
			}
			
		}
		List<ManuscriptEditor> data2 = manuscriptEditorRepo.getmanuScriptEditorByIdAddMultiple(manuScriptEditorCommonVO.getManuscriptId(), manuScriptEditorCommonVO.getEditorId(),
				manuScriptEditorCommonVO.getManuscriptVersion());
		if (data2 != null && !data2.isEmpty()) {
			ManuscriptEditor manuScriptEditorData1 = data2.get(0);
			ManuscriptEditor manuScriptEditorData =  manuscriptEditorRepo.getOne(manuScriptEditorData1 .getId());

			if (manuScriptEditorCommonVO.getManuscriptStatus() != null) {
				manuScriptEditorData.setManuscriptStatus(manuScriptEditorCommonVO.getManuscriptStatus());
			}
			if (manuScriptEditorCommonVO.getUpdatedOn() != null) {
				manuScriptEditorData.setUpdatedOn(manuScriptEditorCommonVO.getUpdatedOn());
			}
			if (manuScriptEditorCommonVO.getUpdatedBy() != null) {
				manuScriptEditorData.setUpdatedBy(manuScriptEditorCommonVO.getUpdatedBy());
			}
			if (manuScriptEditorCommonVO.getCreatedOn() != null) {
				manuScriptEditorData.setCreatedOn(manuScriptEditorCommonVO.getCreatedOn());
			}
			if (manuScriptEditorCommonVO.getCreatedBy() != null) {
				manuScriptEditorData.setCreatedBy(manuScriptEditorCommonVO.getCreatedBy());
			}
			if (manuScriptEditorCommonVO.getCommentsForAuthor() != null) {
				manuScriptEditorData.setCommentsForAuthor(manuScriptEditorCommonVO.getCommentsForAuthor());
			}
		
			manuscriptEditorRepo.save(manuScriptEditorData);
			manuScriptRepo.updateStage(manuScriptEditorCommonVO.getManuscriptStatus(), manuScriptEditorCommonVO.getManuscriptId());
			 
		}else {
			ManuscriptEditor manuScriptEditorData  = new ManuscriptEditor();
			
			manuScriptEditorData.setManuscriptId(manuScriptEditorCommonVO.getManuscriptId());
			manuScriptEditorData.setManuscriptVersion(manuScriptEditorCommonVO.getManuscriptVersion());
			manuScriptEditorData.setEditorId(manuScriptEditorCommonVO.getEditorId());
			manuScriptEditorData.setManuscriptStatus(manuScriptEditorCommonVO.getManuscriptStatus());
			manuScriptEditorData.setCommentsForAuthor(manuScriptEditorCommonVO.getCommentsForAuthor());
			manuScriptEditorData.setUpdatedOn(manuScriptEditorCommonVO.getUpdatedOn());
			manuScriptEditorData.setUpdatedBy(manuScriptEditorCommonVO.getUpdatedBy());
			manuScriptEditorData.setCreatedOn(manuScriptEditorCommonVO.getCreatedOn());
			manuScriptEditorData.setCreatedBy(manuScriptEditorCommonVO.getCreatedBy());
			manuScriptEditorData.setJournalId(manuScriptEditorCommonVO.getJournalId());
			
			manuscriptEditorRepo.save(manuScriptEditorData);
			manuScriptRepo.updateStage(manuScriptEditorCommonVO.getManuscriptStatus(), manuScriptEditorCommonVO.getManuscriptId());
			
		}
		
	}
	
}
