package com.digi.uniprr.VO;

import java.util.Date;

public class ManuscriptEditorChecklistVO {
	
	private Integer manuscriptId;
	private Integer manuscriptVersion;
	private Integer editorId;
	private Integer chkId;
	private Integer chkType;
	private String chckComments;
	private Date createdOn;
	private Integer createdBy;
	private Date updatedOn;
	private Integer updatedBy;
	private Integer isActive;
	
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
	public Integer getChkId() {
		return chkId;
	}
	public void setChkId(Integer chkId) {
		this.chkId = chkId;
	}
	public Integer getChkType() {
		return chkType;
	}
	public void setChkType(Integer chkType) {
		this.chkType = chkType;
	}
	public String getChckComments() {
		return chckComments;
	}
	public void setChckComments(String chckComments) {
		this.chckComments = chckComments;
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
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
