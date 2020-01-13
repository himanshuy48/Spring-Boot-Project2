package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="institution")
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inst_id")
	private Integer id;
	
	@Column(name = "inst_name")
	private String instName;

	@Column(name="inst_short_name")
	private String instShortName;
	
	@ManyToOne
	@JoinColumn(name="country_id", insertable = false, updatable = false)
	private Countries country;
	
	@Column(name="country_id")
	private Integer countryId;
	
	@ManyToOne
	@JoinColumn(name="state_id", insertable = false, updatable = false)
	private States state;
	
	@Column(name="state_id")
	private Integer stateId;
	
	@ManyToOne
	@JoinColumn(name="city_id", insertable = false, updatable = false)
	private Cities city;
	
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="phone_no")
	private Long phoneNumber;
	
	@Column(name="url")
	private String url;
	
	@Column(name="email")
	private String email;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getInstShortName() {
		return instShortName;
	}

	public void setInstShortName(String instShortName) {
		this.instShortName = instShortName;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Cities getCity() {
		return city;
	}

	public void setCity(Cities city) {
		this.city = city;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
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