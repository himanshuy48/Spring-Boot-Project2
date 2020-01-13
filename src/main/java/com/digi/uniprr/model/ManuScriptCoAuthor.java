package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "manuscript_coauthordetails")

public class ManuScriptCoAuthor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="coauth_id", insertable = false, updatable = false)
	private User user;
	
	@Column(name = "coauth_id")
	private Integer coAuthorId;
	
	@Column(name = "coauth_mansucripts_id")
	private Integer coAuthorManuscriptId;
	
	@Column(name = "coauth_status")
	private Integer coAuthorStatus;
	
	@Column(name = "author_order")
	private Integer authorOrder;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name =  "corresponding_author")
	private Integer correspondingAuthor;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name ="created_on")
	private Date createdOn;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name ="updated_on")
	private Date updatedOn;
	
	@Column(name= "co_author")
	private String coAuthor;
	
	@Column(name= "co_author_type")
	private Integer coAuthorType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCoAuthorId() {
		return coAuthorId;
	}

	public void setCoAuthorId(Integer coAuthorId) {
		this.coAuthorId = coAuthorId;
	}

	public Integer getCoAuthorManuscriptId() {
		return coAuthorManuscriptId;
	}

	public void setCoAuthorManuscriptId(Integer coAuthorManuscriptId) {
		this.coAuthorManuscriptId = coAuthorManuscriptId;
	}

	public Integer getCoAuthorStatus() {
		return coAuthorStatus;
	}

	public void setCoAuthorStatus(Integer coAuthorStatus) {
		this.coAuthorStatus = coAuthorStatus;
	}

	public Integer getAuthorOrder() {
		return authorOrder;
	}

	public void setAuthorOrder(Integer authorOrder) {
		this.authorOrder = authorOrder;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getCorrespondingAuthor() {
		return correspondingAuthor;
	}

	public void setCorrespondingAuthor(Integer correspondingAuthor) {
		this.correspondingAuthor = correspondingAuthor;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCoAuthor() {
		return coAuthor;
	}

	public void setCoAuthor(String coAuthor) {
		this.coAuthor = coAuthor;
	}

	public Integer getCoAuthorType() {
		return coAuthorType;
	}

	public void setCoAuthorType(Integer coAuthorType) {
		this.coAuthorType = coAuthorType;
	}
	
}