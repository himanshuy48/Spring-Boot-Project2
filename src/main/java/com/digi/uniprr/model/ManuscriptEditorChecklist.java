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
@Table(name = "manuscript_editor_checklist")
public class ManuscriptEditorChecklist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="manuscript_id", insertable = false, updatable = false)
    private ManuScript manuscript;
	 
	@Column(name="manuscript_id")
	private Integer manuscriptId;
	
	@Column(name="manuscript_version")
	private Integer manuscriptVersion;

	@Column(name="chk_id")
	private Integer chkId;
	
	@Column(name="chk_type")
	private Integer chkType;
	
	@Column(name="editor_id")
	private Integer editorId;
	
	@Column(name="chck_comments")
	private String chckComments;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")	
	@Column(name="created_on")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="updated_by")
	private Integer updatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name="updated_on")
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name="is_active")
	private Integer isActive; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getEditorId() {
		return editorId;
	}

	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}

	public String getChckComments() {
		return chckComments;
	}

	public void setChckComments(String chckComments) {
		this.chckComments = chckComments;
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
