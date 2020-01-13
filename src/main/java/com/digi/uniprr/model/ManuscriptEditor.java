package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "manuscript_editor")
public class ManuscriptEditor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;

	@Column(name = "manuscript_id")
	private Integer manuscriptId;

	@Column(name = "manuscript_version")
	private Integer manuscriptVersion;

	@Column(name = "editor_id")
	private Integer editorId;

	@Column(name = "managing_editor_id")
	private Integer managingEditorId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "journal_id")
	private Integer journalId;

	@Column(name = "manuscript_status")
	private Integer manuscriptStatus;

	@Column(name = "comments_for_editor")
	private String commentsForEditor;
	
	@Column(name = "comments_for_author")
	private String commentsForAuthor;
	
	@Column(name = "comments_for_reviewer")
	private String commentsForReviewer;
	
	@Column(name = "comments_for_managing_editor")
	private String commentsForManagingEditor;
	
	@Column(name = "decision_Letters")
	private String decisionLetter;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name = "created_on")
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name = "updated_on")
	@UpdateTimestamp
	private Date updatedOn;

	@Column(name = "is_active")
	private Integer isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getEditorId() {
		return editorId;
	}

	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}

	public Integer getManagingEditorId() {
		return managingEditorId;
	}

	public void setManagingEditorId(Integer managingEditorId) {
		this.managingEditorId = managingEditorId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public String getCommentsForEditor() {
		return commentsForEditor;
	}

	public void setCommentsForEditor(String commentsForEditor) {
		this.commentsForEditor = commentsForEditor;
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

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getCommentsForAuthor() {
		return commentsForAuthor;
	}

	public void setCommentsForAuthor(String commentsForAuthor) {
		this.commentsForAuthor = commentsForAuthor;
	}

	public String getCommentsForReviewer() {
		return commentsForReviewer;
	}

	public void setCommentsForReviewer(String commentsForReviewer) {
		this.commentsForReviewer = commentsForReviewer;
	}

	public String getCommentsForManagingEditor() {
		return commentsForManagingEditor;
	}

	public void setCommentsForManagingEditor(String commentsForManagingEditor) {
		this.commentsForManagingEditor = commentsForManagingEditor;
	}

	public String getDecisionLetter() {
		return decisionLetter;
	}

	public void setDecisionLetter(String decisionLetter) {
		this.decisionLetter = decisionLetter;
	}

}