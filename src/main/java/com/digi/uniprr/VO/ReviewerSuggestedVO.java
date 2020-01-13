package com.digi.uniprr.VO;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.enums.Salutation;

public class ReviewerSuggestedVO {
	private Integer manuscriptId;
	private Integer manuscriptVersion;
	private Integer reviewerId;
	private Integer journalId;
	private Integer manuscriptStatus;
	private Integer suggestedBy;
	private Integer suggestedReviewerId;
	private Integer approvedSuggestedId;
	private String suggestedByComments;
	private String approvedByComments;
	private String approved;
	private String isSuggested;
	private String email;
	private String firstname;
	private String lastname;
	private String salutation;
	private String username;
	private Date suggestedOn;
	private Date decisionOn;
	private List<ReviewerSuggestedVO> reviewerSuggested;
	private List<ReviewerSuggestedVO> reviewerNonSuggested;
	private String boxesofboxes;
	@Column(name = "is_assigned")
	private Integer isAssigned;

	public Integer getManuscriptId() {
		return manuscriptId;
	}

	public void setManuscriptId(Integer manuscriptId) {
		this.manuscriptId = manuscriptId;
	}

	public Integer getManuscriptVersion() {
		return manuscriptVersion;
	}

	public void setManuscriptVersion(Integer manuscriptVersion) {
		this.manuscriptVersion = manuscriptVersion;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Integer getManuscriptStatus() {
		return manuscriptStatus;
	}

	public void setManuscriptStatus(Integer manuscriptStatus) {
		this.manuscriptStatus = manuscriptStatus;
	}

	public Integer getSuggestedBy() {
		return suggestedBy;
	}

	public void setSuggestedBy(Integer suggestedBy) {
		this.suggestedBy = suggestedBy;
	}

	public Integer getSuggestedReviewerId() {
		return suggestedReviewerId;
	}

	public void setSuggestedReviewerId(Integer suggestedReviewerId) {
		this.suggestedReviewerId = suggestedReviewerId;
	}

	public Integer getApprovedSuggestedId() {
		return approvedSuggestedId;
	}

	public void setApprovedSuggestedId(Integer approvedSuggestedId) {
		this.approvedSuggestedId = approvedSuggestedId;
	}

	public String getSuggestedByComments() {
		return suggestedByComments;
	}

	public void setSuggestedByComments(String suggestedByComments) {
		this.suggestedByComments = suggestedByComments;
	}

	public String getApprovedByComments() {
		return approvedByComments;
	}

	public void setApprovedByComments(String approvedByComments) {
		this.approvedByComments = approvedByComments;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getIsSuggested() {
		return isSuggested;
	}

	public void setIsSuggested(String isSuggested) {
		this.isSuggested = isSuggested;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getSuggestedOn() {
		return suggestedOn;
	}

	public void setSuggestedOn(Date suggestedOn) {
		this.suggestedOn = suggestedOn;
	}

	public Date getDecisionOn() {
		return decisionOn;
	}

	public void setDecisionOn(Date decisionOn) {
		this.decisionOn = decisionOn;
	}

	public List<ReviewerSuggestedVO> getReviewerSuggested() {
		return reviewerSuggested;
	}

	public void setReviewerSuggested(List<ReviewerSuggestedVO> reviewerSuggested) {
		this.reviewerSuggested = reviewerSuggested;
	}

	public List<ReviewerSuggestedVO> getReviewerNonSuggested() {
		return reviewerNonSuggested;
	}

	public void setReviewerNonSuggested(List<ReviewerSuggestedVO> reviewerNonSuggested) {
		this.reviewerNonSuggested = reviewerNonSuggested;
	}

	public String getBoxesofboxes() {
		return boxesofboxes;
	}

	public void setBoxesofboxes(String boxesofboxes) {
		this.boxesofboxes = boxesofboxes;
	}

	public Integer getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(Integer isAssigned) {
		this.isAssigned = isAssigned;
	}
	
}
