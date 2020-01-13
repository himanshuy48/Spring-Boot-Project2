package com.digi.uniprr.VO;

import java.util.Date;
import java.util.List;

public class CheckListMasterVO {
	
	private Integer journalId;
	private String chkCategory;
	private List<CheckListVO> checkList;
	private String chkRule;
	private Integer createdBy;
	private Date createdOn;
	private Integer updatedBy;
	private Date updatedOn;
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
	public List<CheckListVO> getCheckList() {
		return checkList;
	}
	public void setCheckList(List<CheckListVO> checkList) {
		this.checkList = checkList;
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

}
