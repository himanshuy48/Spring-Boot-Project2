package com.digi.uniprr.VO;

import java.util.List;

public class ManuScriptByJournalVo {

	private Integer userId;
	private List<Integer> statusId;
	private String journalTitle;
	private Integer journalId;
	private String journalCode;
	private Integer count;
	private Integer new_Submitted_Manuscript;
	private Integer manuscript_in_Review;
	private Integer re_submitted_Manuscript;
	private Integer manuscript_Sent_for_Revision;
	private Integer decision_on_Manuscript;
	private Integer total_Manuscript;
	
	public String getJournalTitle() {
		return journalTitle;
	}
	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}
	public Integer getJournalId() {
		return journalId;
	}
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	public String getJournalCode() {
		return journalCode;
	}
	public void setJournalCode(String journalCode) {
		this.journalCode = journalCode;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Integer> getStatusId() {
		return statusId;
	}
	public void setStatusId(List<Integer> statusId) {
		this.statusId = statusId;
	}
	public Integer getNew_Submitted_Manuscript() {
		return new_Submitted_Manuscript;
	}
	public void setNew_Submitted_Manuscript(Integer new_Submitted_Manuscript) {
		this.new_Submitted_Manuscript = new_Submitted_Manuscript;
	}
	public Integer getManuscript_in_Review() {
		return manuscript_in_Review;
	}
	public void setManuscript_in_Review(Integer manuscript_in_Review) {
		this.manuscript_in_Review = manuscript_in_Review;
	}
	public Integer getRe_submitted_Manuscript() {
		return re_submitted_Manuscript;
	}
	public void setRe_submitted_Manuscript(Integer re_submitted_Manuscript) {
		this.re_submitted_Manuscript = re_submitted_Manuscript;
	}
	public Integer getManuscript_Sent_for_Revision() {
		return manuscript_Sent_for_Revision;
	}
	public void setManuscript_Sent_for_Revision(Integer manuscript_Sent_for_Revision) {
		this.manuscript_Sent_for_Revision = manuscript_Sent_for_Revision;
	}
	public Integer getDecision_on_Manuscript() {
		return decision_on_Manuscript;
	}
	public void setDecision_on_Manuscript(Integer decision_on_Manuscript) {
		this.decision_on_Manuscript = decision_on_Manuscript;
	}
	public Integer getTotal_Manuscript() {
		return total_Manuscript;
	}
	public void setTotal_Manuscript(Integer total_Manuscript) {
		this.total_Manuscript = total_Manuscript;
	}
	
}
