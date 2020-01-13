package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "manuscript_reviewer")
public class ManuScriptReviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;

	@ManyToOne
	@JoinColumn(name = "manuscript_id", insertable = false, updatable = false)
	private ManuScript manuscript;
	
	@Column(name = "manuscript_id")
	private Integer manuscriptId;

	@Column(name = "manuscript_version")
	private Integer manuscriptVersion;

	@Column(name = "reviewer_id")
	private Integer reviewerId;

	@Column(name = "editor_id")
	private Integer editorId;

	@Column(name = "manuscript_status")
	private Integer manuscriptStatus;

	@Column(name = "publon_credit")
	private String publonCredit;

	@Column(name = "journal_id")
	private Integer journalId;

	@Column(name = "assigned_date")
	@CreationTimestamp
	private Date assignedDate;

	@Column(name = "unassigned_date")
	private Date unassignedDate;

	@Column(name = "start_date")
	@CreationTimestamp
	private Date startDate;

	@Column(name = "complete_date")
	private Date completeDate;

	@Column(name = "reject_date")
	private Date rejectDate;

	@Column(name = "accept_date")
	private Date acceptDate;

	@Column(name = "is_assigned")
	private Integer isAssigned;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "rejection_reason")
	private String rejectionReason;

	@Column(name = "comments_for_reviewer")
	private String commentsForReviewer;
	
	
	@Column(name = "comments_to_author")
	private String commentsToAuthor;
	
	@Column(name = "comments_to_editor")
	private String commentsToEditor;
	
	@Column(name = "decision_letter")
	private String decisionLetter;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")	
	@Column(name="created_on")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name="updated_on")
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name="updated_by")
	private Integer updatedBy;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public ManuScript getManuscript() {
		return manuscript;
	}

	public void setManuscript(ManuScript manuscript) {
		this.manuscript = manuscript;
	}

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

	public String getPublonCredit() {
		return publonCredit;
	}

	public void setPublonCredit(String publonCredit) {
		this.publonCredit = publonCredit;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getUnassignedDate() {
		return unassignedDate;
	}

	public void setUnassignedDate(Date unassignedDate) {
		this.unassignedDate = unassignedDate;
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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

	@Override
	public String toString() {
		return "ManuScriptReviewer [Id=" + Id + ", manuscript=" + manuscript + ", manuscriptId=" + manuscriptId
				+ ", manuscriptVersion=" + manuscriptVersion + ", reviewerId=" + reviewerId + ", editorId=" + editorId
				+ ", manuscriptStatus=" + manuscriptStatus + ", publonCredit=" + publonCredit + ", journalId="
				+ journalId + ", assignedDate=" + assignedDate + ", unassignedDate=" + unassignedDate + ", startDate="
				+ startDate + ", completeDate=" + completeDate + ", rejectDate=" + rejectDate + ", acceptDate="
				+ acceptDate + ", isAssigned=" + isAssigned + ", isActive=" + isActive + ", dueDate=" + dueDate
				+ ", rejectionReason=" + rejectionReason + ", commentsForReviewer=" + commentsForReviewer
				+ ", commentsToAuthor=" + commentsToAuthor + ", commentsToEditor=" + commentsToEditor
				+ ", decisionLetter=" + decisionLetter + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + "]";
	}

}
