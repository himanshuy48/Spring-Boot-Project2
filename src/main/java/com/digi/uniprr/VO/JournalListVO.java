package com.digi.uniprr.VO;

public class JournalListVO {
	
	private Integer journalId;
	
	private String journalTitle;
	
	private String journalCode;
	
	private String journalShortTitle;
	
	private Integer publisherId;
	
	private String journalBlindType;
	
	private String isChargingReq;
	
	public String getIsChargingReq() {
		return isChargingReq;
	}

	public void setIsChargingReq(String isChargingReq) {
		this.isChargingReq = isChargingReq;
	}

	public String getJournalBlindType() {
		return journalBlindType;
	}

	public void setJournalBlindType(String journalBlindType) {
		this.journalBlindType = journalBlindType;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getJournalTitle() {
		return journalTitle;
	}

	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	public String getJournalCode() {
		return journalCode;
	}

	public void setJournalCode(String journalCode) {
		this.journalCode = journalCode;
	}

	public String getJournalShortTitle() {
		return journalShortTitle;
	}

	public void setJournalShortTitle(String journalShortTitle) {
		this.journalShortTitle = journalShortTitle;
	}
}
