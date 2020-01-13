package com.digi.uniprr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="task_email_map")
public class TaskEmailMap 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tem_id")
    private Integer temId;
    
    @ManyToOne
	@JoinColumn(name = "journal_email_template_id", insertable = false, updatable = false)
    private JournalMailTemplates journalMailTemplates;
    
    @Column(name="journal_email_template_id")
    private Integer journalEmailTemplateId;
    
    @ManyToOne
    @JoinColumn(name="task_id", insertable = false, updatable = false)
    private TaskMaster taskMaster;
    
    @Column(name="task_id")
    private Integer taskId;
    
    @Column(name="journal_id")
    private Integer journalId;

    @Column(name="created_on")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="updated_on")
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name="updated_by")
	private Integer updatedBy;

	public Integer getTemId() {
		return temId;
	}

	public void setTemId(Integer temId) {
		this.temId = temId;
	}

	public JournalMailTemplates getJournalMailTemplates() {
		return journalMailTemplates;
	}

	public void setJournalMailTemplates(JournalMailTemplates journalMailTemplates) {
		this.journalMailTemplates = journalMailTemplates;
	}

	public Integer getJournalEmailTemplateId() {
		return journalEmailTemplateId;
	}

	public void setJournalEmailTemplateId(Integer journalEmailTemplateId) {
		this.journalEmailTemplateId = journalEmailTemplateId;
	}

	public TaskMaster getTaskMaster() {
		return taskMaster;
	}

	public void setTaskMaster(TaskMaster taskMaster) {
		this.taskMaster = taskMaster;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
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
