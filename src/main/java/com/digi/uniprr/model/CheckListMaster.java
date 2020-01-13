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
@Table(name = "checklist_master")
public class CheckListMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "chk_id")
	private Integer chkid;
	 
	@Column(name="journal_id")
	private Integer journalId;
	
	@Column(name="chk_category")
	private String chkCategory;
	
	@Column(name="chk_key")
	private String chkKey;
	
	@Column(name="chk_rule")
	private String chkRule;
	
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

	public Integer getChkid() {
		return chkid;
	}

	public void setChkid(Integer chkid) {
		this.chkid = chkid;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getChkCategory() {
		return chkCategory;
	}

	public void setChkCategory(String chkCategory) {
		this.chkCategory = chkCategory;
	}

	public String getChkKey() {
		return chkKey;
	}

	public void setChkKey(String chkKey) {
		this.chkKey = chkKey;
	}

	public String getChkRule() {
		return chkRule;
	}

	public void setChkRule(String chkRule) {
		this.chkRule = chkRule;
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
