package com.digi.uniprr.VO;

public class ManageJournalVO {
	
	private String journalConfiguration;
	
	private String journalName;
	
	private String journalTitle;
	
	private Boolean isCopyConfiguration;
	
	private Integer existingJournalId;

	public String getJournalConfiguration() {
		return journalConfiguration;
	}

	public void setJournalConfiguration(String journalConfiguration) {
		this.journalConfiguration = journalConfiguration;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getJournalTitle() {
		return journalTitle;
	}

	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	public Boolean getIsCopyConfiguration() {
		return isCopyConfiguration;
	}

	public void setIsCopyConfiguration(Boolean isCopyConfiguration) {
		this.isCopyConfiguration = isCopyConfiguration;
	}

	public Integer getExistingJournalId() {
		return existingJournalId;
	}

	public void setExistingJournalId(Integer existingJournalId) {
		this.existingJournalId = existingJournalId;
	}
	

}
