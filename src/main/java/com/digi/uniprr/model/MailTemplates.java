package com.digi.uniprr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mail_templates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MailTemplates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_template_id")
	private Integer emailTemplateId;

	@Column(name = "email_template_name")
	private String emailTemplateName;

	@Column(name = "template_placeholder")
	private String templatePlaceholder;

	@Column(name = "email_template_form")
	private String emailTemplateForm;

	@Column(name = "mail_from")
	private String from;

	@Column(name = "mail_to")
	private String to;

	@Column(name = "cc")
	private String cc;

	@Column(name = "bcc")
	private String bcc;

	@Column(name = "subject")
	private String subject;

	@Column(name = "body")
	private String body;

	@Column(name = "user_group")
	private String userGroup;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "created_on", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "updated_on")
	@UpdateTimestamp
	private Date updatedOn;

	@Column(name = "updated_by")
	private Integer updatedBy;

	public Integer getEmailTemplateId() {
		return emailTemplateId;
	}

	public void setEmailTemplateId(Integer emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

	public String getEmailTemplateName() {
		return emailTemplateName;
	}

	public void setEmailTemplateName(String emailTemplateName) {
		this.emailTemplateName = emailTemplateName;
	}

	public String getTemplatePlaceholder() {
		return templatePlaceholder;
	}

	public void setTemplatePlaceholder(String templatePlaceholder) {
		this.templatePlaceholder = templatePlaceholder;
	}

	public String getEmailTemplateForm() {
		return emailTemplateForm;
	}

	public void setEmailTemplateForm(String emailTemplateForm) {
		this.emailTemplateForm = emailTemplateForm;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
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

	
}
