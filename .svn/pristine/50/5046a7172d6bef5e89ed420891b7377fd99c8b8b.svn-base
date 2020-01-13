package com.digi.uniprr.model;

import java.util.Date;

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
@Table(name="journal_plagirism")
public class JournalPlagirism {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "journal_id",updatable = false,insertable = false)
	private Journal journal;
	
	@Column(name="journal_id")
	private Integer journalId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "pla_mid",updatable = false,insertable = false)
	private JournalPlagiarismMaster journalPlagiarismMaster;
	
	@Column(name="pla_mid")
	private Integer plaId;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="orginal_submission")
	private Integer orginalSubmission;
	
	@Column(name="revised_submission")
	private Integer revisedSubmission;
	
	@Column(name="resubmission_submission")
	private Integer resubmissionSubmission;
	
	@Column(name="accepted_submission")
	private Integer acceptedSubmission;

	@Column(name = "created_by")
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name = "created_on")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name="updated_on")
	@UpdateTimestamp
	private Date updatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public JournalPlagiarismMaster getJournalPlagiarismMaster() {
		return journalPlagiarismMaster;
	}

	public void setJournalPlagiarismMaster(JournalPlagiarismMaster journalPlagiarismMaster) {
		this.journalPlagiarismMaster = journalPlagiarismMaster;
	}

	public Integer getPlaId() {
		return plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
