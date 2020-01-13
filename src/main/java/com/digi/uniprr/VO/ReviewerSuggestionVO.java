package com.digi.uniprr.VO;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.enums.Salutation;

public class ReviewerSuggestionVO {

	private Integer manuscriptId;
	private Integer manuscriptVersion;
	private Integer reviewerId;
	private Integer manuscriptStatus;
	private Integer editorId;
	private String publonCredit;
	private Date assignedDate;
	private Integer journalId;
	private Date acceptDate;
    private Integer isAssigned;
    private Integer isActive;
	private String username;
	private String email;
	private Salutation salutation;
	private String lastName;
	private String firstName;	
	private Date rejectDate;
	private String rejectionReason;
	private List<ReviewerSuggestedVO> reviewerSuggested;
	private List<ReviewerSuggestedVO> reviewerNonSuggested;
	private String boxesofboxes;
	

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


	public Integer getManuscriptStatus() {
		return manuscriptStatus;
	}

	public void setManuscriptStatus(Integer manuscriptStatus) {
		this.manuscriptStatus = manuscriptStatus;
	}

	
	public Integer getEditorId() {
		return editorId;
	}

	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}

	public String getPublonCredit() {
		return publonCredit;
	}

	public void setPublonCredit(String publonCredit) {
		this.publonCredit = publonCredit;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Integer getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(Integer isAssigned) {
		this.isAssigned = isAssigned;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
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

}
