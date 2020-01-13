package com.digi.uniprr.VO;

import java.util.Date;
import java.util.List;

public class ManuScriptReviewerVO {

	private Integer manuscriptId;
	private Integer manuscriptVersion;
	private Integer editorId;
	private Integer manuscriptStatus;
	private Integer reviewerId;
	private String publonCredit;
	private Date assignedDate;
	private Integer journalId;
	private Date unassignedDate;
	private List<RIDVO> reviewer;
	private Date startDate;
	private Date completeDate;
	private Date rejectDate;
	private Date acceptDate;
	private Integer isAssigned;
	private Date dueDate;
	private String rejectionReason;
	private String commentsForReviewer;
	private String commentsToAuthor;
	private String commentsToEditor;
	private String decisionLetter;
	private Date createdOn;
	private Integer createdBy;
	private Date updatedOn;
	private Integer updatedBy;

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

	public Integer getEditorId() {
		return editorId;
	}

	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}

	public Integer getManuscriptStatus() {
		return manuscriptStatus;
	}

	public void setManuscriptStatus(Integer manuscriptStatus) {
		this.manuscriptStatus = manuscriptStatus;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
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

	public Date getUnassignedDate() {
		return unassignedDate;
	}

	public void setUnassignedDate(Date unassignedDate) {
		this.unassignedDate = unassignedDate;
	}

	public List<RIDVO> getReviewer() {
		return reviewer;
	}

	public void setReviewer(List<RIDVO> reviewer) {
		this.reviewer = reviewer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public Date getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public String getCommentsForReviewer() {
		return commentsForReviewer;
	}

	public void setCommentsForReviewer(String commentsForReviewer) {
		this.commentsForReviewer = commentsForReviewer;
	}

	public String getCommentsToAuthor() {
		return commentsToAuthor;
	}

	public void setCommentsToAuthor(String commentsToAuthor) {
		this.commentsToAuthor = commentsToAuthor;
	}

	public String getCommentsToEditor() {
		return commentsToEditor;
	}

	public void setCommentsToEditor(String commentsToEditor) {
		this.commentsToEditor = commentsToEditor;
	}

	public String getDecisionLetter() {
		return decisionLetter;
	}

	public void setDecisionLetter(String decisionLetter) {
		this.decisionLetter = decisionLetter;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

}
