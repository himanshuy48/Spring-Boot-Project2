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
@Table(name="journal_tat_configuration")
public class JournalTatConfiguration {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="journal_id")
	private Integer journalId;
	
	@ManyToOne
	@JoinColumn(name="status_id", insertable = false, updatable = false)
	private StatusMaster statusMaster;
	
	@Column(name="status_id")
	private Integer statusId;
	
	@Column(name="turn_around_time")
	private Integer turnAroundTime;
	
	@Column(name="buffered")
	private Integer bufferedTime;
	
	@Column(name="req_alert")
	private Integer requiredAlert;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	
	public StatusMaster getStatusMaster() {
		return statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getTurnAroundTime() {
		return turnAroundTime;
	}

	public void setTurnAroundTime(Integer turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

	public Integer getBufferedTime() {
		return bufferedTime;
	}

	public void setBufferedTime(Integer bufferedTime) {
		this.bufferedTime = bufferedTime;
	}

	public Integer getRequiredAlert() {
		return requiredAlert;
	}

	public void setRequiredAlert(Integer requiredAlert) {
		this.requiredAlert = requiredAlert;
	}
	
	

}
