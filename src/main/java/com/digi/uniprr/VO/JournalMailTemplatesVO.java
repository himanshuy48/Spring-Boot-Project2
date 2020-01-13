package com.digi.uniprr.VO;

import java.sql.Date;

public class JournalMailTemplatesVO {

	private Integer journalEmailTemplateId;
	private String emailTemplateName;
	private Integer journalId;
	private Integer templatePlaceholderId;
	private String emailTemplateForm;
	private String isActive;
	private String mailBcc;
	private String mailBody;
	private String mailcc;
	private String mailSubject;
	private String mailTo;
	private String mailFrom;
	private String userGroup;
	private Date createdOn;
	private Date updatedOn;
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getJournalEmailTemplateId() {
		return journalEmailTemplateId;
	}

	public void setJournalEmailTemplateId(Integer journalEmailTemplateId) {
		this.journalEmailTemplateId = journalEmailTemplateId;
	}

	public String getEmailTemplateName() {
		return emailTemplateName;
	}

	public void setEmailTemplateName(String emailTemplateName) {
		this.emailTemplateName = emailTemplateName;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getEmailTemplateForm() {
		return emailTemplateForm;
	}

	public void setEmailTemplateForm(String emailTemplateForm) {
		this.emailTemplateForm = emailTemplateForm;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getMailBcc() {
		return mailBcc;
	}

	public void setMailBcc(String mailBcc) {
		this.mailBcc = mailBcc;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getMailcc() {
		return mailcc;
	}

	public void setMailcc(String mailcc) {
		this.mailcc = mailcc;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public Integer getTemplatePlaceholderId() {
		return templatePlaceholderId;
	}

	public void setTemplatePlaceholderId(Integer templatePlaceholderId) {
		this.templatePlaceholderId = templatePlaceholderId;
	}

	
}
