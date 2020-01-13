package com.digi.uniprr.VO;

import java.util.Date;

import com.digi.uniprr.model.Journal;

public class ReportVO {
	
	private Integer journalId;

	private String journalTitle;

	private String journalCode;

	private String journalShortTitle;

	private Integer publisherId;

	private String manuscriptCode;

	private String manuscriptTitle;

	private Integer authorId;

	private Integer manuscriptStatusId;
	
	private String manuscriptStatusCode;

	private Integer manuscriptVersion;

	private Date submissionDate;
	
	private String authorName;
	

	public String getManuscriptStatusCode() {
		return manuscriptStatusCode;
	}

	public void setManuscriptStatusCode(String manuscriptStatusCode) {
		this.manuscriptStatusCode = manuscriptStatusCode;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
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

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getManuscriptStatusId() {
		return manuscriptStatusId;
	}

	public void setManuscriptStatusId(Integer manuscriptStatusId) {
		this.manuscriptStatusId = manuscriptStatusId;
	}

	public Integer getManuscriptVersion() {
		return manuscriptVersion;
	}

	public void setManuscriptVersion(Integer manuscriptVersion) {
		this.manuscriptVersion = manuscriptVersion;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

}
