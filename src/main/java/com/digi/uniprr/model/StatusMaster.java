package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "status_master")

public class StatusMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id")
	private Integer id;
	
	@Column(name="status_desc")
	private String statusDesc;

	@Column(name="role")
	private String role;
	
	@Column(name="status_value")
	private String statusValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status_type")
	private StatusType statusType;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="required_for_tat")
	private String requiredForTat;

	@Column(name="created_on")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="updated_on")
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name="updated_by")
	private Integer updatedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getRequiredForTat() {
		return requiredForTat;
	}

	public void setRequiredForTat(String requiredForTat) {
		this.requiredForTat = requiredForTat;
	}

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

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "StatusMaster [id=" + id + ", statusDesc=" + statusDesc + ", role=" + role + ", statusValue="
				+ statusValue + ", statusType=" + statusType + ", createdBy=" + createdBy + ", requiredForTat="
				+ requiredForTat + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy
				+ "]";
	}
}