package com.digi.uniprr.VO;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StatusMasterVO {

	private String JournalCode;

	private Integer ManuscriptId;

	private String ManuscriptTitle;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private String Submittedon;
	
	private String ManuScriptCode;
	
	private String statusDesc;

	public String getJournalCode() {
		return JournalCode;
	}

	public void setJournalCode(String journalCode) {
		JournalCode = journalCode;
	}

	public Integer getManuscriptId() {
		return ManuscriptId;
	}

	public void setManuscriptId(Integer manuscriptId) {
		ManuscriptId = manuscriptId;
	}

	public String getManuscriptTitle() {
		return ManuscriptTitle;
	}

	public void setManuscriptTitle(String manuscriptTitle) {
		ManuscriptTitle = manuscriptTitle;
	}

	public String getSubmittedon() {
		return Submittedon;
	}

	public void setSubmittedon(String submittedon) {
		Submittedon = submittedon;
	}

	public String getManuScriptCode() {
		return ManuScriptCode;
	}

	public void setManuScriptCode(String manuScriptCode) {
		ManuScriptCode = manuScriptCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	
	
}