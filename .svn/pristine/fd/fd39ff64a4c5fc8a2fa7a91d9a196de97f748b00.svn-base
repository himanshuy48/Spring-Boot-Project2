package com.digi.uniprr.VO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.digi.uniprr.model.Journal;
import com.digi.uniprr.model.StatusMaster;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ManuScriptTrackCodeVO {

	private Integer manuScriptId;
	private Journal journalId;
	private Integer manuscriptAuthorId;
	private String manuscriptCode;
	StatusMaster statusMaster;
	private Integer manuscriptVersion;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private Date submissionDate;
	private Integer submittedBy;
	private Integer createdBy;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private Date createdOn;
	private Integer updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private Date updatedOn;
	
	public Integer getManuScriptId() {
		return manuScriptId;
	}
	public void setManuScriptId(Integer manuScriptId) {
		this.manuScriptId = manuScriptId;
	}
	public Journal getJournalId() {
		return journalId;
	}
	public void setJournalId(Journal journalId) {
		this.journalId = journalId;
	}
	public Integer getManuscriptAuthorId() {
		return manuscriptAuthorId;
	}
	public void setManuscriptAuthorId(Integer manuscriptAuthorId) {
		this.manuscriptAuthorId = manuscriptAuthorId;
	}
	public String getManuscriptCode() {
		return manuscriptCode;
	}
	public void setManuscriptCode(String manuscriptCode) {
		this.manuscriptCode = manuscriptCode;
	}
	public StatusMaster getStatusMaster() {
		return statusMaster;
	}
	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}
	
	public Integer getManuscriptVersion() {
		return manuscriptVersion;
	}
	public void setManuscriptVersion(Integer manuscriptVersion) {
		this.manuscriptVersion = manuscriptVersion;
	}
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public Integer getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(Integer submittedBy) {
		this.submittedBy = submittedBy;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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
	
}