package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.CommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerCommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerVO;
import com.digi.uniprr.VO.ReviewerAvailabilityStatusVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuScriptReviewerChecklist;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.model.StatusMaster;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.ManuScriptReviewerRepo;
import com.digi.uniprr.repository.ManuscriptReviewerChecklistRepo;
import com.digi.uniprr.repository.ManuscriptReviewerCommentsRepo;
import com.digi.uniprr.repository.ReviewerAvailabilityRepo;
import com.digi.uniprr.repository.StatusMasterRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ManuScriptReviewerService;

@Service
@Transactional
public class ManuScriptReviewerServiceImpl implements ManuScriptReviewerService {

	@Autowired
	ManuScriptReviewerRepo manuScriptReviewerRepo;

	@Autowired
	ManuscriptReviewerChecklistRepo manuscriptReviewerChecklistRepo;

	@Autowired
	ManuscriptReviewerCommentsRepo manuscriptReviewerCommentsRepo;
	
	@Autowired
	StatusMasterRepo statusMasterRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ManuScriptRepo manuScriptRepo;
	
	@Autowired
	ReviewerAvailabilityRepo reviewerAvailabilityRepo;

	JSONObject obj = new JSONObject();

	@Override
	public String addReviewerDeatils(ManuScriptReviewer manuScriptReviewer) {

		manuScriptReviewerRepo.save(manuScriptReviewer);
		return "Added successfully";
	}

	@Override
	public JSONObject saveManuScriptReviewer(ManuScriptReviewerVO manuScriptReviewerVo) {
		for (int i = 0; i <= manuScriptReviewerVo.getReviewer().size() - 1; i++)
			manuScriptReviewerRepo.saveManuScriptReviewer(manuScriptReviewerVo.getManuscriptId(),
					manuScriptReviewerVo.getManuscriptVersion(),
					manuScriptReviewerVo.getReviewer().get(i).getReviewerId(), manuScriptReviewerVo.getEditorId(),
					manuScriptReviewerVo.getManuscriptStatus(), manuScriptReviewerVo.getPublonCredit(),
					manuScriptReviewerVo.getAssignedDate(), manuScriptReviewerVo.getJournalId(),
					manuScriptReviewerVo.getIsAssigned());
		obj.put("message", "manuscriptReviewer added data successfully");
		return obj;
	}

	/*
	 * @Override public String updateReviewerDeatils(ManuScriptReviewer
	 * manuScriptReviewer) { manuScriptReviewerRepo.save(manuScriptReviewer); return
	 * "Updated successfully"; }
	 */

	@Override
	public boolean isExist(Integer manuscriptId, Integer reviewerId, Integer manuscriptVersion) {
		List<ManuScriptReviewer> isExist = manuScriptReviewerRepo.getmanuScriptReviewerById(manuscriptId, reviewerId,
				manuscriptVersion);

		if (isExist != null || isExist.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String updateReviewerDeatils(ManuScriptReviewerVO manuScriptReviewerVo) {

		List<ManuScriptReviewer> data = manuScriptReviewerRepo.getmanuScriptReviewerById(
				manuScriptReviewerVo.getManuscriptId(), manuScriptReviewerVo.getReviewerId(),
				manuScriptReviewerVo.getManuscriptVersion());
		ManuScriptReviewer manuScriptReviewerData1 = data.get(0);
		ManuScriptReviewer manuScriptReviewerData = manuScriptReviewerRepo.getOne(manuScriptReviewerData1.getId());
		if (manuScriptReviewerVo.getEditorId() != null) {
			manuScriptReviewerData.setEditorId(manuScriptReviewerVo.getEditorId());
		}

		if (manuScriptReviewerVo.getManuscriptStatus() != null) {
			manuScriptReviewerData.setManuscriptStatus(manuScriptReviewerVo.getManuscriptStatus());
		}

		if (manuScriptReviewerVo.getPublonCredit() != null) {
			manuScriptReviewerData.setPublonCredit(manuScriptReviewerVo.getPublonCredit());
		}
		if (manuScriptReviewerVo.getUnassignedDate() != null) {
			manuScriptReviewerData.setUnassignedDate(manuScriptReviewerVo.getUnassignedDate());
		}
		if (manuScriptReviewerVo.getStartDate() != null) {
			manuScriptReviewerData.setStartDate(manuScriptReviewerVo.getStartDate());
		}
		if (manuScriptReviewerVo.getCompleteDate() != null) {
			manuScriptReviewerData.setCompleteDate(manuScriptReviewerVo.getCompleteDate());
		}
		if (manuScriptReviewerVo.getRejectDate() != null) {
			manuScriptReviewerData.setRejectDate(manuScriptReviewerVo.getRejectDate());
		}
		if (manuScriptReviewerVo.getAcceptDate() != null) {
			manuScriptReviewerData.setAcceptDate(manuScriptReviewerVo.getAcceptDate());
		}
		if (manuScriptReviewerVo.getIsAssigned() != null) {
			manuScriptReviewerData.setIsAssigned(manuScriptReviewerVo.getIsAssigned());
		}
		if (manuScriptReviewerVo.getRejectionReason() != null) {
			manuScriptReviewerData.setRejectionReason(manuScriptReviewerVo.getRejectionReason());
		}
		if (manuScriptReviewerVo.getUpdatedBy() != null) {
			manuScriptReviewerData.setUpdatedBy(manuScriptReviewerVo.getUpdatedBy());
		}
		if (manuScriptReviewerVo.getUpdatedOn() != null) {
			manuScriptReviewerData.setUpdatedOn(manuScriptReviewerVo.getUpdatedOn());
		}
		if (manuScriptReviewerVo.getDecisionLetter() != null) {
			manuScriptReviewerData.setDecisionLetter(manuScriptReviewerVo.getDecisionLetter());
		}
		if (manuScriptReviewerVo.getCommentsToAuthor() != null) {
			manuScriptReviewerData.setCommentsToAuthor(manuScriptReviewerVo.getCommentsToAuthor());
		}
		if (manuScriptReviewerVo.getCommentsToEditor() != null) {
			manuScriptReviewerData.setCommentsToEditor(manuScriptReviewerVo.getCommentsToEditor());
		}
		
		manuScriptReviewerRepo.save(manuScriptReviewerData);
		return "Updated Data Sucessfully";
	}

	@Override
	public String addAllDetailsMultipleTableRCC(ManuScriptReviewerCommonVO manuScriptReviewerCommonVO) {

		List<ManuScriptReviewer> data = manuScriptReviewerRepo.getmanuScriptReviewerById(
				manuScriptReviewerCommonVO.getManuscriptId(), manuScriptReviewerCommonVO.getReviewerId(),
				manuScriptReviewerCommonVO.getManuscriptVersion());

		if (data != null && !data.isEmpty()) {
			ManuScriptReviewer manuScriptReviewerData1 = data.get(0);
			ManuScriptReviewer manuScriptReviewerData = manuScriptReviewerRepo.getOne(manuScriptReviewerData1.getId());

			if (manuScriptReviewerCommonVO.getEditorId() != null) {
				manuScriptReviewerData.setEditorId(manuScriptReviewerCommonVO.getEditorId());
			}
			if (manuScriptReviewerCommonVO.getManuscriptStatus() != null) {
				manuScriptReviewerData.setManuscriptStatus(manuScriptReviewerCommonVO.getManuscriptStatus());
			}
			if (manuScriptReviewerCommonVO.getPublonCredit() != null) {
				manuScriptReviewerData.setPublonCredit(manuScriptReviewerCommonVO.getPublonCredit());
			}
			if (manuScriptReviewerCommonVO.getAssignedDate() != null) {
				manuScriptReviewerData.setRejectDate(manuScriptReviewerCommonVO.getAssignedDate());
			}
			if (manuScriptReviewerCommonVO.getIsAssigned() != null) {
				manuScriptReviewerData.setIsAssigned(manuScriptReviewerCommonVO.getIsAssigned());
			}
			if (manuScriptReviewerCommonVO.getRejectionReason() != null) {
				manuScriptReviewerData.setRejectionReason(manuScriptReviewerCommonVO.getRejectionReason());
			}
			if (manuScriptReviewerCommonVO.getJournalId() != null) {
				manuScriptReviewerData.setJournalId(manuScriptReviewerCommonVO.getJournalId());
			}
			if (manuScriptReviewerCommonVO.getAcceptDate() != null) {
				manuScriptReviewerData.setAcceptDate(manuScriptReviewerCommonVO.getAcceptDate());
			}
			if (manuScriptReviewerCommonVO.getIsActive() != null) {
				manuScriptReviewerData.setIsActive(manuScriptReviewerCommonVO.getIsActive());
			}
			if (manuScriptReviewerCommonVO.getUpdatedBy() != null) {
				manuScriptReviewerData.setUpdatedBy(manuScriptReviewerCommonVO.getUpdatedBy());
			}
			if (manuScriptReviewerCommonVO.getUpdatedOn() != null) {
				manuScriptReviewerData.setUpdatedOn(manuScriptReviewerCommonVO.getUpdatedOn());
			}
			if (manuScriptReviewerCommonVO.getDecisionLetter() != null) {
				manuScriptReviewerData.setDecisionLetter(manuScriptReviewerCommonVO.getDecisionLetter());
			}
			if (manuScriptReviewerCommonVO.getCommentsToAuthor() != null) {
				manuScriptReviewerData.setCommentsToAuthor(manuScriptReviewerCommonVO.getCommentsToAuthor());
			}
			if (manuScriptReviewerCommonVO.getCommentsToEditor() != null) {
				manuScriptReviewerData.setCommentsToEditor(manuScriptReviewerCommonVO.getCommentsToEditor());
			}
			manuScriptReviewerRepo.save(manuScriptReviewerData);
		} else {
			ManuScriptReviewer manuScriptReviewerData = new ManuScriptReviewer();
			manuScriptReviewerData.setManuscriptId(manuScriptReviewerCommonVO.getManuscriptId());
			manuScriptReviewerData.setManuscriptVersion(manuScriptReviewerCommonVO.getManuscriptVersion());
			manuScriptReviewerData.setReviewerId(manuScriptReviewerCommonVO.getReviewerId());
			manuScriptReviewerData.setManuscriptStatus(manuScriptReviewerCommonVO.getManuscriptStatus());
			manuScriptReviewerData.setJournalId(manuScriptReviewerCommonVO.getJournalId());
			manuScriptReviewerData.setEditorId(manuScriptReviewerCommonVO.getEditorId());
			manuScriptReviewerData.setIsAssigned(manuScriptReviewerCommonVO.getIsAssigned());
			manuScriptReviewerData.setPublonCredit(manuScriptReviewerCommonVO.getPublonCredit());
			manuScriptReviewerData.setAssignedDate(manuScriptReviewerCommonVO.getAssignedDate());
			manuScriptReviewerData.setAcceptDate(manuScriptReviewerCommonVO.getAcceptDate());
			manuScriptReviewerData.setRejectionReason(manuScriptReviewerCommonVO.getRejectionReason());
			manuScriptReviewerData.setDecisionLetter(manuScriptReviewerCommonVO.getDecisionLetter());
			manuScriptReviewerData.setCommentsToAuthor(manuScriptReviewerCommonVO.getCommentsToAuthor());
			manuScriptReviewerData.setCommentsToEditor(manuScriptReviewerCommonVO.getCommentsToEditor());
			manuScriptReviewerData.setIsActive(manuScriptReviewerCommonVO.getIsActive());
			manuScriptReviewerRepo.save(manuScriptReviewerData);

		}

		for (int i = 0; i <= manuScriptReviewerCommonVO.getReviewer().size() - 1; i++) {
			ManuScriptReviewerChecklist saved1 = new ManuScriptReviewerChecklist();
			saved1.setManuscriptId(manuScriptReviewerCommonVO.getManuscriptId());
			saved1.setManuscriptVersion(manuScriptReviewerCommonVO.getManuscriptVersion());
			saved1.setReviewerId(manuScriptReviewerCommonVO.getReviewerId());
			saved1.setChkId(manuScriptReviewerCommonVO.getReviewer().get(i).getChkId());
			saved1.setChkType(manuScriptReviewerCommonVO.getReviewer().get(i).getChkType());
			saved1.setChckComments(manuScriptReviewerCommonVO.getReviewer().get(i).getChckComments());
			saved1.setCreatedBy(manuScriptReviewerCommonVO.getCreatedBy());
			saved1.setCreatedOn(manuScriptReviewerCommonVO.getCreatedOn());
			saved1.setUpdatedBy(manuScriptReviewerCommonVO.getUpdatedBy());
			saved1.setUpdatedOn(manuScriptReviewerCommonVO.getUpdatedOn());
			manuscriptReviewerChecklistRepo.save(saved1);
		}

		return "Data Insert Succesfully";
	}

	@Override
	public List<ManuScriptReviewer> getManuscriptReviewer(UserJournalManuscriptVo userJournalManuscriptVo) {

		List<ManuScriptReviewer> dataList = new ArrayList<>();
		for (Integer statusList : userJournalManuscriptVo.getManuscriptStatusId()) {
			List<ManuScriptReviewer> list = new ArrayList<>();
			Integer status = statusList;
			list = manuScriptReviewerRepo.getManuscriptReviewer(status, userJournalManuscriptVo.getJournalId(),
					userJournalManuscriptVo.getUserId());
			if (list != null && !list.isEmpty()) {
				for (ManuScriptReviewer listOfData : list) {
					dataList.add(listOfData);
				}
			}

		}

		return dataList;
	}

	@Override
	public List<ManuScriptReviewer> getManuscriptReviewerListById(UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ManuScriptReviewer> dataList = new ArrayList<>();
		for (Integer statusList : userJournalManuscriptVo.getManuscriptStatusId()) {
			List<ManuScriptReviewer> list = new ArrayList<>();
			Integer status = statusList;
			list = manuScriptReviewerRepo.getManuscriptReviewerListById(status, userJournalManuscriptVo.getJournalId());
			if (list != null && !list.isEmpty()) {
				for (ManuScriptReviewer listOfData : list) {
					dataList.add(listOfData);
				}
			}
		}
		return dataList;
	}

	@Override
	public void saveManuScriptReviewerDetails(ManuScriptReviewer manuscriptReviewer) {

		manuScriptReviewerRepo.save(manuscriptReviewer);
	}

	@Override
	public List<ManuScriptReviewerCommonVO> getReviewerByManuScriptIdAndVersion(Integer manuscriptId,Integer manuscriptVersion) {
		 List<ManuScriptReviewerCommonVO> rsd = new ArrayList<>();
		 List<ManuScriptReviewer> reviewerData = manuScriptReviewerRepo.getManuscriptReviewerListByManuScriptIdAndVersion(manuscriptId, manuscriptVersion);
		 if (reviewerData != null && !reviewerData.isEmpty()) {
			 for (ManuScriptReviewer list : reviewerData) {
				 ManuScriptReviewerCommonVO commonvo = new ManuScriptReviewerCommonVO();
				 commonvo.setManuscriptId(list.getManuscriptId());
				 commonvo.setManuscriptVersion(list.getManuscriptVersion());
				 commonvo.setReviewerId(list.getReviewerId());
				 commonvo.setManuscriptStatus(list.getManuscriptStatus());
				 commonvo.setDecisionLetter(list.getDecisionLetter());
			     commonvo.setCommentsToAuthor(list.getCommentsToAuthor());
			     commonvo.setCommentsToEditor(list.getCommentsToEditor());
				 
				 StatusMaster st = statusMasterRepo.getOne(list.getManuscriptStatus());
				 commonvo.setStatusValue(st.getStatusValue());
				  if (list.getReviewerId() != null) {
					 
					  User user = userRepo.getOne(list.getReviewerId());
						if (user != null && user.getFirstName() != null) {
							 commonvo.setName(user.getFirstName()+" "+user.getLastName());
						}	
				  }
				 ManuScript ms = manuScriptRepo.getOne(list.getManuscriptId());
				 commonvo.setManuscriptCode(ms.getManuscriptCode());
				 
				 rsd.add(commonvo);
			 } 
		 }
		return rsd;
	}
	
	@Override
	public List<ReviewerAvailabilityStatusVO> getReviewerDataById(CommonVO id) {
		
		List<ReviewerAvailabilityStatusVO> reviewerAvailabilityStatus = new ArrayList<>();
		
		for (Integer reviewerId : id.getRoleId()) {
			ReviewerAvailabilityStatusVO tempReviewerAvailabilityStatus = new ReviewerAvailabilityStatusVO();
			Integer acceptedByReviewer = 0;
			Integer rejectedByReviewer = 0;
			Integer minorRevisionReviewer = 0;
			Integer majorRevisionReviewer = 0;
			Integer acceptReviewInvitation = 0;
			Integer rejectReviewInvitation = 0;
			
			List<ManuScriptReviewer> reviewerData = manuScriptReviewerRepo.getReviewerDataById(reviewerId);
			
			for (ManuScriptReviewer ManuScriptReviewer : reviewerData) {
				
				if (ManuScriptReviewer.getManuscriptStatus() == 12) {
					acceptedByReviewer+=1;
				} else if (ManuScriptReviewer.getManuscriptStatus() == 13) {
					rejectedByReviewer+=1;
				} else if (ManuScriptReviewer.getManuscriptStatus() == 14) {
					minorRevisionReviewer+=1;
				} else if (ManuScriptReviewer.getManuscriptStatus() == 15) {
					majorRevisionReviewer+=1;
				} else if (ManuScriptReviewer.getManuscriptStatus() == 35) {
					acceptReviewInvitation+=1;
				} else if (ManuScriptReviewer.getManuscriptStatus() == 36) {
					rejectReviewInvitation+=1;
				}
			}
			tempReviewerAvailabilityStatus.setAcceptedByReviewer(acceptedByReviewer);
			tempReviewerAvailabilityStatus.setAcceptReviewInvitation(acceptReviewInvitation);
			tempReviewerAvailabilityStatus.setMajorRevisionReviewer(majorRevisionReviewer);
			tempReviewerAvailabilityStatus.setMinorRevisionReviewer(minorRevisionReviewer);
			tempReviewerAvailabilityStatus.setRejectedByReviewer(rejectedByReviewer);
			tempReviewerAvailabilityStatus.setRejectReviewInvitation(rejectReviewInvitation);
			tempReviewerAvailabilityStatus.setEmail(reviewerData.get(0).getManuscript().getUser().getEmail());
			tempReviewerAvailabilityStatus.setName(reviewerData.get(0).getManuscript().getUser().getFirstName() +" " +reviewerData.get(0).getManuscript().getUser().getLastName());
			reviewerAvailabilityStatus.add(tempReviewerAvailabilityStatus);
		}
		return reviewerAvailabilityStatus;
	}

	@Override
	public List<ManuScriptReviewerCommonVO> getReviewerDataByManuscriptVersion(Integer manuscriptId, Integer manuscriptVersion,
			Integer journalId) {
		List<ManuScriptReviewerCommonVO> rsd = new ArrayList<>();
		List<ManuScriptReviewer> reviewerData = manuScriptReviewerRepo.getReviewerDataByManuscriptVersion(manuscriptId, manuscriptVersion, journalId);
		List<ReviewerAvailability> reviewerAvailability = reviewerAvailabilityRepo.getAllReviewerAvailability();
		for (ManuScriptReviewer list : reviewerData) {
			 ManuScriptReviewerCommonVO commonvo = new ManuScriptReviewerCommonVO();
			 commonvo.setManuscriptId(list.getManuscriptId());
			 commonvo.setManuscriptVersion(list.getManuscriptVersion());
			 commonvo.setReviewerId(list.getReviewerId());
			 commonvo.setManuscriptStatus(list.getManuscriptStatus());
			 commonvo.setDecisionLetter(list.getDecisionLetter());
		     commonvo.setCommentsToAuthor(list.getCommentsToAuthor());
		     commonvo.setCommentsToEditor(list.getCommentsToEditor());
		     commonvo.setAssignedDate(list.getAssignedDate());
		     commonvo.setAcceptDate(list.getAcceptDate());
		     commonvo.setRejectDate(list.getRejectDate());
		     commonvo.setIsAssigned(list.getIsAssigned());
		     commonvo.setDueDate(list.getDueDate());
		     commonvo.setEmail(list.getManuscript().getUser().getEmail());
			 
			 StatusMaster st = statusMasterRepo.getOne(list.getManuscriptStatus());
			 commonvo.setStatusValue(st.getStatusValue());
			  if (list.getReviewerId() != null) {
				 
				  User user = userRepo.getOne(list.getReviewerId());
					if (user != null && user.getFirstName() != null) {
						 commonvo.setName(user.getFirstName()+" "+user.getLastName());
						 commonvo.setEmail(user.getEmail());
					}	
			  }
			 ManuScript ms = manuScriptRepo.getOne(list.getManuscriptId());
			 commonvo.setManuscriptCode(ms.getManuscriptCode());
			 
			 if(reviewerAvailability != null && !reviewerAvailability.isEmpty()) {
				 List<ReviewerAvailability> tempReviewer = new ArrayList<>();
				 for(ReviewerAvailability rva : reviewerAvailability) {
					 if(rva.getReviewerId().equals(list.getReviewerId())) {
						 tempReviewer.add(rva);
					 }
				 }
				 commonvo.setReviewerAvailability(tempReviewer);
			 }
			 rsd.add(commonvo);
		 }
		return rsd;
	}

	@Override
	public List<ManuScriptReviewerCommonVO> getAssignedReviewer(Integer manuscriptId, Integer manuscriptVersion,
			Integer journalId) {
		List<ManuScriptReviewerCommonVO> rsd = new ArrayList<>();
		List<ManuScriptReviewer> reviewerData = manuScriptReviewerRepo.getUniqueUnassignedReviewer(manuscriptId, manuscriptVersion, journalId);
		List<ReviewerAvailability> reviewerAvailability = reviewerAvailabilityRepo.getAllReviewerAvailability();
		for (ManuScriptReviewer list : reviewerData) {
			 
			 ManuScriptReviewerCommonVO commonvo = new ManuScriptReviewerCommonVO();
			 commonvo.setManuscriptId(list.getManuscriptId());
			 commonvo.setManuscriptVersion(list.getManuscriptVersion());
			 commonvo.setReviewerId(list.getReviewerId());
			 commonvo.setManuscriptStatus(list.getManuscriptStatus());
			 commonvo.setDecisionLetter(list.getDecisionLetter());
		     commonvo.setCommentsToAuthor(list.getCommentsToAuthor());
		     commonvo.setCommentsToEditor(list.getCommentsToEditor());
		     commonvo.setAssignedDate(list.getAssignedDate());
		     commonvo.setAcceptDate(list.getAcceptDate());
		     commonvo.setRejectDate(list.getRejectDate());
		     commonvo.setIsAssigned(list.getIsAssigned());
		     commonvo.setDueDate(list.getDueDate());
		     commonvo.setJournalId(list.getJournalId());
			 StatusMaster st = statusMasterRepo.getOne(list.getManuscriptStatus());
			 commonvo.setStatusValue(st.getStatusValue());
			  if (list.getReviewerId() != null) {
				 
				  User user = userRepo.getOne(list.getReviewerId());
					if (user != null && user.getFirstName() != null) {
						 commonvo.setName(user.getFirstName()+" "+user.getLastName());
						 commonvo.setEmail(user.getEmail());
					}	
			  }
			 ManuScript ms = manuScriptRepo.getOne(list.getManuscriptId());
			 commonvo.setManuscriptCode(ms.getManuscriptCode());
			 
			 if(reviewerAvailability != null && !reviewerAvailability.isEmpty()) {
				 List<ReviewerAvailability> tempReviewer = new ArrayList<>();
				 for(ReviewerAvailability rva : reviewerAvailability) {
					 if(rva.getReviewerId().equals(list.getReviewerId())) {
						 tempReviewer.add(rva);
					 }
				 }
				 commonvo.setReviewerAvailability(tempReviewer);
			 }
			 rsd.add(commonvo);
		 }
		
		return rsd;
	}

}