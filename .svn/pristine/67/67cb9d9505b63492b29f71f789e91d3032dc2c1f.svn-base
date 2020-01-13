package com.digi.uniprr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="feedback_question_master")
public class FeedbackQuestionMaster 
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="rm_id")
    private Integer rmId;
    
    @ManyToOne
    @JoinColumn(name="role_id", insertable = false, updatable = false)
    private Role role;
    
    @Column(name="role_id")
    private Integer roleId;
    
    @Column(name="category")
    private String category;
    
    @Column(name="key")
    private String key;
    
    @Column(name="value")
    private String value;
    
    @Column(name="key_detail_json")
    private String keyDetailJson;
    
    @Column(name="created_by")
    private Integer createdBy;
    
    @Column(name="created_on")
    private Date createdOn;
    
    @Column(name="updated_by")
    private Integer updatedBy;
    
    @Column(name="updated_on")
    private Date updatedOn;

	public Integer getRmId() {
		return rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKeyDetailJson() {
		return keyDetailJson;
	}

	public void setKeyDetailJson(String keyDetailJson) {
		this.keyDetailJson = keyDetailJson;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
