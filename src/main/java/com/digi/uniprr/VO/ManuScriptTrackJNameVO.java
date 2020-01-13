package com.digi.uniprr.VO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ManuScriptTrackJNameVO {
	private Integer manuScriptId;
	private String journalTitle;
	private String authorName;
	private String manuScriptTitle;
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private Date SubmissionDate;
	
	public Integer getManuScriptId() {
		return manuScriptId;
	}
	public void setManuScriptId(Integer manuScriptId) {
		this.manuScriptId = manuScriptId;
	}
	public String getJournalTitle() {
		return journalTitle;
	}
	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getManuScriptTitle() {
		return manuScriptTitle;
	}
	public void setManuScriptTitle(String manuScriptTitle) {
		this.manuScriptTitle = manuScriptTitle;
	}
	public Date getSubmissionDate() {
		return SubmissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		SubmissionDate = submissionDate;
	}
	
     
}
