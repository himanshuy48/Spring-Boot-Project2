package com.digi.uniprr.VO;

import java.util.Date;
import java.util.List;

import com.digi.uniprr.model.Specialization;

public class SubjectVO {

	private Integer subjId;
	
	private String subjectName;
	
	private String subjType;
	
	private Integer subjIdParent;
	
	private Integer createdBy;
	
	private Date createdOn;
	
	private Integer updatedBy;
	
	private Date updatedOn;
	
	private Integer isActive;
	
	List<Specialization> specialization;

	public Integer getSubjId() {
		return subjId;
	}

	public void setSubjId(Integer subjId) {
		this.subjId = subjId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjType() {
		return subjType;
	}

	public void setSubjType(String subjType) {
		this.subjType = subjType;
	}

	public Integer getSubjIdParent() {
		return subjIdParent;
	}

	public void setSubjIdParent(Integer subjIdParent) {
		this.subjIdParent = subjIdParent;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

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

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public List<Specialization> getSpecialization() {
		return specialization;
	}

	public void setSpecialization(List<Specialization> specialization) {
		this.specialization = specialization;
	}
}
