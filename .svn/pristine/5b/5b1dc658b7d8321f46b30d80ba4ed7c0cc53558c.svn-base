package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="editor_availability")
public class EditorAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "editor_id")
	private Integer editorId;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEditorId() {
		return editorId;
	}

	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}

	public Date getUnavilableFrom() {
		return unavilableFrom;
	}

	public void setUnavilableFrom(Date unavilableFrom) {
		this.unavilableFrom = unavilableFrom;
	}

	public Date getUnavailableTo() {
		return unavailableTo;
	}

	public void setUnavailableTo(Date unavailableTo) {
		this.unavailableTo = unavailableTo;
	}

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
	
}
