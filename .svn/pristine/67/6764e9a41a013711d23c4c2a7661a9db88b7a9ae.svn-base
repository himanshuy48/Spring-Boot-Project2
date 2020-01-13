package com.digi.uniprr.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ReviewerSuggestedVO;
import com.digi.uniprr.VO.ReviewerSuggestionVO;
import com.digi.uniprr.enums.Salutation;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ReviewerSuggested;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.ManuScriptReviewerRepo;
import com.digi.uniprr.repository.ReviewerSuggestedRepo;
import com.digi.uniprr.repository.UserLoginRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ReviewerSuggestedService;

@Service
@Transactional
public class ReviewerSuggestedServiceImpl implements ReviewerSuggestedService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserLoginRepo userLoginRepo;

	@Autowired
	ReviewerSuggestedRepo reviewerSuggestedRepo;
	
	@Autowired
	ManuScriptReviewerRepo manuScriptReviewerRepo;

	@Override
	public User getByEmail(String email) {
		return reviewerSuggestedRepo.findByEmail(email);
	}

	@Override
	public String createUser(ReviewerSuggestionVO reviewerSuggestionVO) {

	if(reviewerSuggestionVO.getBoxesofboxes() == "") 
	{
		List<ManuScriptReviewer> data = manuScriptReviewerRepo.getmanuScriptReviewerById(
				reviewerSuggestionVO.getManuscriptId(),reviewerSuggestionVO.getReviewerId(),
				reviewerSuggestionVO.getManuscriptVersion());
		if (data != null && !data.isEmpty()) {
		     ManuScriptReviewer manuScriptReviewerData1 = data.get(0);
		     ManuScriptReviewer manuScriptReviewerData = manuScriptReviewerRepo.getOne(manuScriptReviewerData1.getId());
		
		     if (reviewerSuggestionVO.getManuscriptStatus() != null) {
			    manuScriptReviewerData.setManuscriptStatus(reviewerSuggestionVO.getManuscriptStatus());
		     }
			    manuScriptReviewerData.setRejectDate(new Date());
		     if (reviewerSuggestionVO.getRejectionReason() != null) {
			     manuScriptReviewerData.setRejectionReason(reviewerSuggestionVO.getRejectionReason());
		     }
		     
		    manuScriptReviewerRepo.save(manuScriptReviewerData);
		} else {
			ManuScriptReviewer manuScriptReviewerData = new ManuScriptReviewer();
			manuScriptReviewerData.setManuscriptId(reviewerSuggestionVO.getManuscriptId());
			manuScriptReviewerData.setManuscriptVersion(reviewerSuggestionVO.getManuscriptVersion());
			manuScriptReviewerData.setReviewerId(reviewerSuggestionVO.getReviewerId());
			manuScriptReviewerData.setManuscriptStatus(reviewerSuggestionVO.getManuscriptStatus());
			manuScriptReviewerData.setJournalId(reviewerSuggestionVO.getJournalId());
			manuScriptReviewerData.setEditorId(reviewerSuggestionVO.getEditorId());
			manuScriptReviewerData.setIsAssigned(reviewerSuggestionVO.getIsAssigned());
			manuScriptReviewerData.setPublonCredit(reviewerSuggestionVO.getPublonCredit());
			manuScriptReviewerData.setAssignedDate(reviewerSuggestionVO.getAssignedDate());
			manuScriptReviewerData.setAcceptDate(reviewerSuggestionVO.getAcceptDate());
			manuScriptReviewerData.setRejectDate(new Date());
			manuScriptReviewerData.setRejectionReason(reviewerSuggestionVO.getRejectionReason());
			manuScriptReviewerData.setIsActive(reviewerSuggestionVO.getIsActive());
			manuScriptReviewerRepo.save(manuScriptReviewerData);

		}

	}
	else {
		for (int i = 0; i <= reviewerSuggestionVO.getReviewerSuggested().size() - 1; i++) {

			ReviewerSuggested saved1 = new ReviewerSuggested();
			

			User user1 = new User();
			user1.setUsername(reviewerSuggestionVO.getReviewerSuggested().get(i).getEmail());
			user1.setEmail(reviewerSuggestionVO.getReviewerSuggested().get(i).getEmail());
			if(reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation()!=null && !reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation().isEmpty()) {
				user1.setSalutation(Enum.valueOf(Salutation.class, reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation()));
			}else {
			
			}
			user1.setFirstName(reviewerSuggestionVO.getReviewerSuggested().get(i).getFirstname());
			user1.setLastName(reviewerSuggestionVO.getReviewerSuggested().get(i).getLastname());
			User savedUser = userLoginRepo.save(user1);
			
			saved1.setSuggestedBy(reviewerSuggestionVO.getReviewerSuggested().get(i).getSuggestedBy());
			saved1.setSuggestedReviewerId(savedUser.getId());
			saved1.setApprovedSuggestedId(reviewerSuggestionVO.getReviewerSuggested().get(i).getApprovedSuggestedId());
			saved1.setSuggestedByComments(reviewerSuggestionVO.getReviewerSuggested().get(i).getSuggestedByComments());
			saved1.setApprovedByComments(reviewerSuggestionVO.getReviewerSuggested().get(i).getApprovedByComments());
			saved1.setApproved(reviewerSuggestionVO.getReviewerSuggested().get(i).getApproved());
			reviewerSuggestedRepo.save(saved1);
			
			
		}
		
		List<ManuScriptReviewer> data = manuScriptReviewerRepo.getmanuScriptReviewerById(
				reviewerSuggestionVO.getManuscriptId(),reviewerSuggestionVO.getReviewerId(),
				reviewerSuggestionVO.getManuscriptVersion());
		if (data != null && !data.isEmpty()) {
		     ManuScriptReviewer manuScriptReviewerData1 = data.get(0);
		     ManuScriptReviewer manuScriptReviewerData = manuScriptReviewerRepo.getOne(manuScriptReviewerData1.getId());
		
		     if (reviewerSuggestionVO.getManuscriptStatus() != null) {
			    manuScriptReviewerData.setManuscriptStatus(reviewerSuggestionVO.getManuscriptStatus());
		     }
			    manuScriptReviewerData.setRejectDate(new Date());
		     if (reviewerSuggestionVO.getRejectionReason() != null) {
			     manuScriptReviewerData.setRejectionReason(reviewerSuggestionVO.getRejectionReason());
		     }
		     
		    manuScriptReviewerRepo.save(manuScriptReviewerData);
		} else {
			ManuScriptReviewer manuScriptReviewerData = new ManuScriptReviewer();
			manuScriptReviewerData.setManuscriptId(reviewerSuggestionVO.getManuscriptId());
			manuScriptReviewerData.setManuscriptVersion(reviewerSuggestionVO.getManuscriptVersion());
			manuScriptReviewerData.setReviewerId(reviewerSuggestionVO.getReviewerId());
			manuScriptReviewerData.setManuscriptStatus(reviewerSuggestionVO.getManuscriptStatus());
			manuScriptReviewerData.setJournalId(reviewerSuggestionVO.getJournalId());
			manuScriptReviewerData.setEditorId(reviewerSuggestionVO.getEditorId());
			manuScriptReviewerData.setIsAssigned(reviewerSuggestionVO.getIsAssigned());
			manuScriptReviewerData.setPublonCredit(reviewerSuggestionVO.getPublonCredit());
			manuScriptReviewerData.setAssignedDate(reviewerSuggestionVO.getAssignedDate());
			manuScriptReviewerData.setAcceptDate(reviewerSuggestionVO.getAcceptDate());
			manuScriptReviewerData.setRejectDate(new Date());
			manuScriptReviewerData.setRejectionReason(reviewerSuggestionVO.getRejectionReason());
			manuScriptReviewerData.setIsActive(reviewerSuggestionVO.getIsActive());
			manuScriptReviewerRepo.save(manuScriptReviewerData);

		    }	
	   }
	  return "Save Decline data";
	}

	@Override
	public String createReviewerSuggestedArray(ReviewerSuggestedVO reviewerSuggestedVO) {
		
		if(reviewerSuggestedVO.getBoxesofboxes() == "" ) {
			for (int i = 0; i <= reviewerSuggestedVO.getReviewerSuggested().size() - 1; i++) {
			    ReviewerSuggested saved = new ReviewerSuggested();
				saved.setManuscriptId(reviewerSuggestedVO.getManuscriptId());
				saved.setManuscriptVersion(reviewerSuggestedVO.getManuscriptVersion());
				saved.setReviewerId(reviewerSuggestedVO.getReviewerId());
				saved.setJournalId(reviewerSuggestedVO.getJournalId());
				
			    if(reviewerSuggestedVO.getReviewerSuggested().get(i).getSalutation()!=null && !reviewerSuggestedVO.getReviewerSuggested().get(i).getSalutation().isEmpty()) {
					 saved.setSalutation(Enum.valueOf(Salutation.class, reviewerSuggestedVO.getReviewerSuggested().get(i).getSalutation()));
				}else {
					
				}
				saved.setFirstName(reviewerSuggestedVO.getReviewerSuggested().get(i).getFirstname());
				saved.setLastName(reviewerSuggestedVO.getReviewerSuggested().get(i).getLastname());
				saved.setEmail(reviewerSuggestedVO.getReviewerSuggested().get(i).getEmail());
				saved.setSuggestedBy(reviewerSuggestedVO.getReviewerSuggested().get(i).getSuggestedBy());
				saved.setSuggestedReviewerId(reviewerSuggestedVO.getReviewerSuggested().get(i).getSuggestedReviewerId());
				saved.setApprovedSuggestedId(reviewerSuggestedVO.getReviewerSuggested().get(i).getApprovedSuggestedId());
				saved.setSuggestedByComments(reviewerSuggestedVO.getReviewerSuggested().get(i).getSuggestedByComments());
				saved.setApprovedByComments(reviewerSuggestedVO.getReviewerSuggested().get(i).getApprovedByComments());
				saved.setApproved(reviewerSuggestedVO.getReviewerSuggested().get(i).getApproved());
				saved.setIsSuggested(reviewerSuggestedVO.getReviewerSuggested().get(i).getIsSuggested());
				saved.setIsAssigned(reviewerSuggestedVO.getReviewerSuggested().get(i).getIsAssigned());
				saved.setManuscriptStatus(reviewerSuggestedVO.getReviewerSuggested().get(i).getManuscriptStatus());
				reviewerSuggestedRepo.save(saved);
		     }
		  }else {
			 				   
			  for (int i = 0; i <= reviewerSuggestedVO.getReviewerSuggested().size() - 1; i++) {
				    ReviewerSuggested saved1 = new ReviewerSuggested();
					saved1.setManuscriptId(reviewerSuggestedVO.getManuscriptId());
					saved1.setManuscriptVersion(reviewerSuggestedVO.getManuscriptVersion());
					saved1.setReviewerId(reviewerSuggestedVO.getReviewerId());
					saved1.setJournalId(reviewerSuggestedVO.getJournalId());
					
				    if(reviewerSuggestedVO.getReviewerSuggested().get(i).getSalutation()!=null && !reviewerSuggestedVO.getReviewerSuggested().get(i).getSalutation().isEmpty()) {
						 saved1.setSalutation(Enum.valueOf(Salutation.class, reviewerSuggestedVO.getReviewerSuggested().get(i).getSalutation()));
					}else {
						
					}
					saved1.setFirstName(reviewerSuggestedVO.getReviewerSuggested().get(i).getFirstname());
					saved1.setLastName(reviewerSuggestedVO.getReviewerSuggested().get(i).getLastname());
					saved1.setEmail(reviewerSuggestedVO.getReviewerSuggested().get(i).getEmail());
					saved1.setSuggestedBy(reviewerSuggestedVO.getReviewerSuggested().get(i).getSuggestedBy());
					saved1.setSuggestedReviewerId(reviewerSuggestedVO.getReviewerSuggested().get(i).getSuggestedReviewerId());
					saved1.setApprovedSuggestedId(reviewerSuggestedVO.getReviewerSuggested().get(i).getApprovedSuggestedId());
					saved1.setSuggestedByComments(reviewerSuggestedVO.getReviewerSuggested().get(i).getSuggestedByComments());
					saved1.setApprovedByComments(reviewerSuggestedVO.getReviewerSuggested().get(i).getApprovedByComments());
					saved1.setApproved(reviewerSuggestedVO.getReviewerSuggested().get(i).getApproved());
					saved1.setIsSuggested(reviewerSuggestedVO.getReviewerSuggested().get(i).getIsSuggested());
					saved1.setIsAssigned(reviewerSuggestedVO.getReviewerSuggested().get(i).getIsAssigned());
					saved1.setManuscriptStatus(reviewerSuggestedVO.getReviewerSuggested().get(i).getManuscriptStatus());
					reviewerSuggestedRepo.save(saved1);
			   }
			  for (int j = 0; j <= reviewerSuggestedVO.getReviewerNonSuggested().size() - 1; j++) {
					
				    ReviewerSuggested saved2 = new ReviewerSuggested();
					saved2.setManuscriptId(reviewerSuggestedVO.getManuscriptId());
					saved2.setManuscriptVersion(reviewerSuggestedVO.getManuscriptVersion());
					saved2.setReviewerId(reviewerSuggestedVO.getReviewerId());
					saved2.setJournalId(reviewerSuggestedVO.getJournalId());
				    
				    if(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getSalutation()!=null && !reviewerSuggestedVO.getReviewerNonSuggested().get(j).getSalutation().isEmpty()) {
						 saved2.setSalutation(Enum.valueOf(Salutation.class, reviewerSuggestedVO.getReviewerNonSuggested().get(j).getSalutation()));
					}else {
						
					}
					saved2.setFirstName(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getFirstname());
					saved2.setLastName(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getLastname());
					saved2.setEmail(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getEmail());
					saved2.setSuggestedBy(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getSuggestedBy());
					saved2.setSuggestedReviewerId(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getSuggestedReviewerId());
					saved2.setApprovedSuggestedId(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getApprovedSuggestedId());
					saved2.setSuggestedByComments(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getSuggestedByComments());
					saved2.setApprovedByComments(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getApprovedByComments());
					saved2.setApproved(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getApproved());
					saved2.setIsSuggested(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getIsSuggested());
					saved2.setIsAssigned(reviewerSuggestedVO.getReviewerSuggested().get(j).getIsAssigned());
					saved2.setManuscriptStatus(reviewerSuggestedVO.getReviewerNonSuggested().get(j).getManuscriptStatus());
					reviewerSuggestedRepo.save(saved2);
			   }	
		    }
			return "Save ReviewerSuggested data";
	}

	@Override
	public ReviewerSuggested getByEmailId(String email) {
		return reviewerSuggestedRepo.findByEmailId(email);
	}

/*	@Override
	public String createReviewerSuggestedArray(ReviewerSuggestionVO reviewerSuggestionVO) {
		
		if(reviewerSuggestionVO.getBoxesofboxes() == "") {
		    ManuScriptReviewer manuScriptReviewerData = new ManuScriptReviewer();
			manuScriptReviewerData.setManuscriptId(reviewerSuggestionVO.getManuscriptId());
			manuScriptReviewerData.setManuscriptVersion(reviewerSuggestionVO.getManuscriptVersion());
			manuScriptReviewerData.setReviewerId(reviewerSuggestionVO.getReviewerId());
			manuScriptReviewerData.setJournalId(reviewerSuggestionVO.getJournalId());
			manuScriptReviewerRepo.save(manuScriptReviewerData);
			
		   for (int i = 0; i <= reviewerSuggestionVO.getReviewerSuggested().size() - 1; i++) {

			ReviewerSuggested saved1 = new ReviewerSuggested();
			

			User user1 = new User();
			user1.setUsername(reviewerSuggestionVO.getReviewerSuggested().get(i).getEmail());
			user1.setEmail(reviewerSuggestionVO.getReviewerSuggested().get(i).getEmail());
			if(reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation()!=null && !reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation().isEmpty()) {
				user1.setSalutation(Enum.valueOf(Salutation.class, reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation()));
			}else {
			
			}
			user1.setFirstName(reviewerSuggestionVO.getReviewerSuggested().get(i).getFirstname());
			user1.setLastName(reviewerSuggestionVO.getReviewerSuggested().get(i).getLastname());
			User savedUser = userLoginRepo.save(user1);
			
			saved1.setSuggestedBy(reviewerSuggestionVO.getReviewerSuggested().get(i).getSuggestedBy());
			saved1.setSuggestedReviewerId(savedUser.getId());
			saved1.setApprovedSuggestedId(reviewerSuggestionVO.getReviewerSuggested().get(i).getApprovedSuggestedId());
			saved1.setSuggestedByComments(reviewerSuggestionVO.getReviewerSuggested().get(i).getSuggestedByComments());
			saved1.setApprovedByComments(reviewerSuggestionVO.getReviewerSuggested().get(i).getApprovedByComments());
			saved1.setApproved(reviewerSuggestionVO.getReviewerSuggested().get(i).getApproved());
			saved1.setIsSuggested(reviewerSuggestionVO.getReviewerSuggested().get(i).getIsSuggested());
			reviewerSuggestedRepo.save(saved1);
			
			ManuScriptReviewer manuScriptReviewerData1 = new ManuScriptReviewer();
			manuScriptReviewerData.setManuscriptStatus(reviewerSuggestionVO.getReviewerSuggested().get(i).getManuscriptStatus());
			manuScriptReviewerRepo.save(manuScriptReviewerData1);
			
		  }
	    }
	   else {
		     ManuScriptReviewer manuScriptReviewerData = new ManuScriptReviewer();
			manuScriptReviewerData.setManuscriptId(reviewerSuggestionVO.getManuscriptId());
			manuScriptReviewerData.setManuscriptVersion(reviewerSuggestionVO.getManuscriptVersion());
			manuScriptReviewerData.setReviewerId(reviewerSuggestionVO.getReviewerId());
			manuScriptReviewerData.setJournalId(reviewerSuggestionVO.getJournalId());
			manuScriptReviewerRepo.save(manuScriptReviewerData);
			   
		       for (int i = 0; i <= reviewerSuggestionVO.getReviewerSuggested().size() - 1; i++) {

				ReviewerSuggested saved1 = new ReviewerSuggested();

				User user1 = new User();
				user1.setUsername(reviewerSuggestionVO.getReviewerSuggested().get(i).getEmail());
				user1.setEmail(reviewerSuggestionVO.getReviewerSuggested().get(i).getEmail());
				if(reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation()==null) {
				}else {
					
				user1.setSalutation(Enum.valueOf(Salutation.class, reviewerSuggestionVO.getReviewerSuggested().get(i).getSalutation()));
				}
				user1.setFirstName(reviewerSuggestionVO.getReviewerSuggested().get(i).getFirstname());
				user1.setLastName(reviewerSuggestionVO.getReviewerSuggested().get(i).getLastname());
				User savedUser = userLoginRepo.save(user1);
				
				saved1.setSuggestedBy(reviewerSuggestionVO.getReviewerSuggested().get(i).getSuggestedBy());
				saved1.setSuggestedReviewerId(savedUser.getId());
				saved1.setApprovedSuggestedId(reviewerSuggestionVO.getReviewerSuggested().get(i).getApprovedSuggestedId());
				saved1.setSuggestedByComments(reviewerSuggestionVO.getReviewerSuggested().get(i).getSuggestedByComments());
				saved1.setApprovedByComments(reviewerSuggestionVO.getReviewerSuggested().get(i).getApprovedByComments());
				saved1.setApproved(reviewerSuggestionVO.getReviewerSuggested().get(i).getApproved());
				saved1.setIsSuggested(reviewerSuggestionVO.getReviewerSuggested().get(i).getIsSuggested());
				reviewerSuggestedRepo.save(saved1);
				
				ManuScriptReviewer manuScriptReviewerData1 = new ManuScriptReviewer();
				manuScriptReviewerData.setManuscriptStatus(reviewerSuggestionVO.getReviewerSuggested().get(i).getManuscriptStatus());
				manuScriptReviewerRepo.save(manuScriptReviewerData1);
				
				
			 }
			  
		      for (int j = 0; j <= reviewerSuggestionVO.getReviewerNonSuggested().size() - 1; j++) {

			   ReviewerSuggested saved1 = new ReviewerSuggested();

			   User user1 = new User();
			   user1.setUsername(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getEmail());
			   user1.setEmail(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getEmail());
			   if(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getSalutation()!=null && !reviewerSuggestionVO.getReviewerNonSuggested().get(j).getSalutation().isEmpty()) {
				user1.setSalutation(Enum.valueOf(Salutation.class, reviewerSuggestionVO.getReviewerNonSuggested().get(j).getSalutation()));
			   }else {
			
			   }
			   user1.setFirstName(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getFirstname());
			   user1.setLastName(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getLastname());
			   User savedUser = userLoginRepo.save(user1);
			
			   saved1.setSuggestedBy(reviewerSuggestionVO.getReviewerSuggested().get(j).getSuggestedBy());
			   saved1.setSuggestedReviewerId(savedUser.getId());
			   saved1.setApprovedSuggestedId(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getApprovedSuggestedId());
			   saved1.setSuggestedByComments(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getSuggestedByComments());
			   saved1.setApprovedByComments(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getApprovedByComments());
			   saved1.setApproved(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getApproved());
			   saved1.setIsSuggested(reviewerSuggestionVO.getReviewerNonSuggested().get(j).getIsSuggested());
			   reviewerSuggestedRepo.save(saved1);
			
			   ManuScriptReviewer manuScriptReviewerData1 = new ManuScriptReviewer();
			   manuScriptReviewerData.setManuscriptStatus(reviewerSuggestionVO.getReviewerSuggested().get(j).getManuscriptStatus());
			   manuScriptReviewerRepo.save(manuScriptReviewerData1);

			}
	    }
		return "Save ReviewerSuggested data";
	}*/

}
