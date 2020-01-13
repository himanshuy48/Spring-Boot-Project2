package com.digi.uniprr.VO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthorDashboardVO {
	
	private Integer manuscriptId;
	
	private String journalCode;
	
	private String manuscriptCode;
	
	private String manuscriptTitle;
	
	private String manuscriptStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private Date createdOn;

	public Integer getManuscriptId() {
		return manuscriptId;
	}

	public void setManuscriptId(Integer manuscriptId) {
		this.manuscriptId = manuscriptId;
	}

	public String getJournalCode() {
		return journalCode;
	}

	public void setJournalCode(String journalCode) {
		this.journalCode = journalCode;
	}

	public String getManuscriptCode() {
		return manuscriptCode;
	}

	public void setManuscriptCode(String manuscriptCode) {
		this.manuscriptCode = manuscriptCode;
	}

	public String getManuscriptTitle() {
		return manuscriptTitle;
	}

	public void setManuscriptTitle(String manuscriptTitle) {
		this.manuscriptTitle = manuscriptTitle;
	}

	public String getManuscriptStatus() {
		return manuscriptStatus;
	}

	public void setManuscriptStatus(String manuscriptStatus) {
		this.manuscriptStatus = manuscriptStatus;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	

}
