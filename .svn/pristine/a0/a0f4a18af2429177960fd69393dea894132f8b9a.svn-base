package com.digi.uniprr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "journal_mail_templates")
public class JournalMailTemplates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "journal_email_template_id")
	private Integer journalEmailTemplateId;

	@Column(name = "email_template_name")
	private String emailTemplateName;

	@ManyToOne
	@JoinColumn(name = "journal_id", insertable = false, updatable = false)
	private Journal journal;

	@Column(name = "journal_id")
	private Integer journalId;
	
	@Column(name="template_placeholder")
	private Integer templatePlaceholderId;
	
	@Column(name="email_template_form")
	private String emailTemplateForm;

	@Column(name = "mail_bcc")
	private String mailBcc;

	@Column(name = "mail_body")
	private String mailBody;

	@Column(name = "mail_cc")
	private String mailcc;

	@Column(name = "mail_subject")
	private String mailSubject;

	@Column(name = "mail_to")
	private String mailTo;

	@Column(name = "mail_from")
	private String mailFrom;

	@Column(name = "user_group")
	private String userGroup;

	@Column(name = "is_active")
	private String isActive;

	@Column(name = "created_on")
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "updated_on")
	@UpdateTimestamp
	private Date updatedOn;

	@Column(name = "updated_by")
	private Integer updatedBy;

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

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getTemplatePlaceholderId() {
		return templatePlaceholderId;
	}

	public void setTemplatePlaceholderId(Integer templatePlaceholderId) {
		this.templatePlaceholderId = templatePlaceholderId;
	}

	@Override
	public String toString() {
		return "JournalMailTemplates [journalEmailTemplateId=" + journalEmailTemplateId + ", emailTemplateName="
				+ emailTemplateName + ", journal=" + journal + ", journalId=" + journalId + ", templatePlaceholderId="
				+ templatePlaceholderId + ", emailTemplateForm=" + emailTemplateForm + ", mailBcc=" + mailBcc
				+ ", mailBody=" + mailBody + ", mailcc=" + mailcc + ", mailSubject=" + mailSubject + ", mailTo="
				+ mailTo + ", mailFrom=" + mailFrom + ", userGroup=" + userGroup + ", isActive=" + isActive
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy="
				+ updatedBy + "]";
	}
 
}
