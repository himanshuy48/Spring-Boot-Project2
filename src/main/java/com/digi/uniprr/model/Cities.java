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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cities")
public class Cities 
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @Column(name="name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name="state_id", insertable = false, updatable = false)
    private States state;
    
    @Column(name="state_id")
    private Integer stateId;
    
    @ManyToOne
    @JoinColumn(name="country_id", insertable = false, updatable = false)
    private Countries country;
    
    @Column(name="country_id")
    private Integer countryId;
    
    @Column(name="flag")
    private Integer flag;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
    @Column(name="created_at")
    private Date createdAt;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
    @Column(name="updated_on")
    private Date updatedOn;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
    
}
