package com.digi.uniprr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="journal_plagiarism_master")
public class JournalPlagiarismMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pla_mid")
	private Integer id;
	
	@Column(name="process_name")
	private String processName;
	
	@Column(name="process_description")
	private String processDescription;
	
	@Column(name="journal_id")
	private Integer journalId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "publisher_id",updatable = false,insertable = false)
	private Publishers publisher;
	
	@Column(name="publisher_id")
	private Integer publisherId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Publishers getPublisher() {
		return publisher;
	}

	public void setPublisher(Publishers publisher) {
		this.publisher = publisher;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	@Override
	public String toString() {
		return "JournalPlagiarismMaster [id=" + id + ", processName=" + processName + ", processDescription="
				+ processDescription + ", journalId=" + journalId + ", publisher=" + publisher + ", publisherId="
				+ publisherId + "]";
	}
	
	
}
