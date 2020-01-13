package com.digi.uniprr.VO;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReviewerStatusData {

	private String name;
	private Integer reviewerId;
	private Integer statusId;
	private String statusCode;
	private String email;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private List<Date> unavailableFrom;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private List<Date> unavailableTo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getReviewerId() {
		return reviewerId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}
	public List<Date> getUnavailableFrom() {
		return unavailableFrom;
	}
	public void setUnavailableFrom(List<Date> unavailableFrom) {
		this.unavailableFrom = unavailableFrom;
	}
	public List<Date> getUnavailableTo() {
		return unavailableTo;
	}
	public void setUnavailableTo(List<Date> unavailableTo) {
		this.unavailableTo = unavailableTo;
	}
	
}
