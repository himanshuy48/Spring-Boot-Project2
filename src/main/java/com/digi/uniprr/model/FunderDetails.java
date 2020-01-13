package com.digi.uniprr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funder_details")
public class FunderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name="funder_id")
	private String funderId;
	
	@Column(name = "funder_name")
	private String funderName;

	@Column(name = "grant_award_number")
	private String grantAwardNumber;

	@Column(name = "fund_email")
	private String fundEmail;

	@Column(name = "fund_information")
	private String fundInformation;

	@Column(name="funder_uri")
	private String funderUri;
	
	@Column(name="funder_location")
	private String funderLocation;
	
	@Column(name = "is_active")
	private Integer isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFunderId() {
		return funderId;
	}

	public void setFunderId(String funderId) {
		this.funderId = funderId;
	}

	public String getFunderName() {
		return funderName;
	}

	public void setFunderName(String funderName) {
		this.funderName = funderName;
	}

	public String getGrantAwardNumber() {
		return grantAwardNumber;
	}

	public void setGrantAwardNumber(String grantAwardNumber) {
		this.grantAwardNumber = grantAwardNumber;
	}

	public String getFundEmail() {
		return fundEmail;
	}

	public void setFundEmail(String fundEmail) {
		this.fundEmail = fundEmail;
	}

	public String getFundInformation() {
		return fundInformation;
	}

	public void setFundInformation(String fundInformation) {
		this.fundInformation = fundInformation;
	}

	public String getFunderUri() {
		return funderUri;
	}

	public void setFunderUri(String funderUri) {
		this.funderUri = funderUri;
	}

	public String getFunderLocation() {
		return funderLocation;
	}

	public void setFunderLocation(String funderLocation) {
		this.funderLocation = funderLocation;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
