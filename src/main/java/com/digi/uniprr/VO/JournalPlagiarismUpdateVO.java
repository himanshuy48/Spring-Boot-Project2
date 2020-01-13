package com.digi.uniprr.VO;

public class JournalPlagiarismUpdateVO {
	private Integer journalId;
	private Integer plaId;
	private Integer orginalSubmission;
	private Integer revisedSubmission;
	private Integer resubmissionSubmission;
	private Integer acceptedSubmission;
	private String processName;
	private String processDescription;
	
	public Integer getJournalId() {
		return journalId;
	}
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	public Integer getPlaId() {
		return plaId;
	}
	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}
	public Integer getOrginalSubmission() {
		return orginalSubmission;
	}
	public void setOrginalSubmission(Integer orginalSubmission) {
		this.orginalSubmission = orginalSubmission;
	}
	public Integer getRevisedSubmission() {
		return revisedSubmission;
	}
	public void setRevisedSubmission(Integer revisedSubmission) {
		this.revisedSubmission = revisedSubmission;
	}
	public Integer getResubmissionSubmission() {
		return resubmissionSubmission;
	}
	public void setResubmissionSubmission(Integer resubmissionSubmission) {
		this.resubmissionSubmission = resubmissionSubmission;
	}
	public Integer getAcceptedSubmission() {
		return acceptedSubmission;
	}
	public void setAcceptedSubmission(Integer acceptedSubmission) {
		this.acceptedSubmission = acceptedSubmission;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcessDescription() {
		return processDescription;
	}
	public void setProcessDescription(String processDescription) {
		this.processDescription = processDescription;
	}
	
}
