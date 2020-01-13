package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="reviewer_availability")
public class ReviewerAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ra_id")
	private Integer ra_id;
	
	@Column(name = "reviewer_id")
	private Integer reviewerId;
	
	@Column(name = "unavailable_from")
	private Date unavilableFrom;
	
	@Column(name = "unavailable_to")
	private Date unavailableTo;
	
	@Column(name = "apply_date")
	private Date applyDate;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "is_active")
	private Integer isActive;
	
	public Integer getRa_id() {
		return ra_id;
	}

	public void setRa_id(Integer ra_id) {
		this.ra_id = ra_id;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	public Date getUnavilableFrom() {
		return unavilableFrom;
	}

	public void setUnavilableFrom(Date unavilableFrom) {
		this.unavilableFrom = unavilableFrom;
	}

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	public Date getUnavailableTo() {
		return unavailableTo;
	}

	public void setUnavailableTo(Date unavailableTo) {
		this.unavailableTo = unavailableTo;
	}

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ReviewerAvailability [ra_id=" + ra_id + ", reviewerId=" + reviewerId + ", unavilableFrom="
				+ unavilableFrom + ", unavailableTo=" + unavailableTo + ", applyDate=" + applyDate + ", reason="
				+ reason + "]";
	}

	
	
	
}
