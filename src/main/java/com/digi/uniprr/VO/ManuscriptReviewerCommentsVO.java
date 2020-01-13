package com.digi.uniprr.VO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.model.ManuScript;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ManuscriptReviewerCommentsVO {
	private Integer manuscriptId;
	private Integer manuscriptVersion;
	private Integer reviewerId;
	private String decisionLetter;
	private String commentsToEditor;
	private String commentsToAuthor;
	private Date createdOn;
	private Integer createdBy;
	private Date updatedOn;
	private Integer updatedBy;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getDecisionLetter() {
		return decisionLetter;
	}
	public void setDecisionLetter(String decisionLetter) {
		this.decisionLetter = decisionLetter;
	}
	public String getCommentsToEditor() {
		return commentsToEditor;
	}
	public void setCommentsToEditor(String commentsToEditor) {
		this.commentsToEditor = commentsToEditor;
	}
	public String getCommentsToAuthor() {
		return commentsToAuthor;
	}
	public void setCommentsToAuthor(String commentsToAuthor) {
		this.commentsToAuthor = commentsToAuthor;
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
