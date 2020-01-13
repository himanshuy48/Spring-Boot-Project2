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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "manuscript_reviewer_comments")
public class ManuscriptReviewerComments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ms_rev_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="manuscript_id", insertable = false, updatable = false)
    private ManuScript manuscript;
	 
	@Column(name="manuscript_id")
	private Integer manuscriptId;
	
	@Column(name="manuscript_version")
	private Integer manuscriptVersion;

	@Column(name="reviewer_id")
	private Integer reviewerId;
	
	@Column(name="decision_letter")
	private String decisionLetter;
	
	@Column(name="comments_to_editor")
	private String commentsToEditor;
	
	@Column(name="comments_to_author")
	private String commentsToAuthor;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")	
	@Column(name="created_on")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
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

	public ManuScript getManuscript() {
		return manuscript;
	}

	public void setManuscript(ManuScript manuscript) {
		this.manuscript = manuscript;
	}

	public Integer getManuscriptId() {
		return manuscriptId;
	}

	public void setManuscriptId(Integer manuscriptId) {
		this.manuscriptId = manuscriptId;
	}

	public Integer getManuscriptVersion() {
		return manuscriptVersion;
	}

	public void setManuscriptVersion(Integer manuscriptVersion) {
		this.manuscriptVersion = manuscriptVersion;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getDecisionLetter() {
		return decisionLetter;
	}

	public void setDecisionLetter(String decisionLetter) {
		this.decisionLetter = decisionLetter;
	}

	public String getCommentsToEditor() {
		return commentsToEditor;
	}

	public void setCommentsToEditor(String commentsToEditor) {
		this.commentsToEditor = commentsToEditor;
	}

	public String getCommentsToAuthor() {
		return commentsToAuthor;
	}

	public void setCommentsToAuthor(String commentsToAuthor) {
		this.commentsToAuthor = commentsToAuthor;
	}

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
		return "ManuscriptReviewerComments [id=" + id + ", manuscript=" + manuscript + ", manuscriptId=" + manuscriptId
				+ ", manuscriptVersion=" + manuscriptVersion + ", reviewerId=" + reviewerId + ", decisionLetter="
				+ decisionLetter + ", commentsToEditor=" + commentsToEditor + ", commentsToAuthor=" + commentsToAuthor
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy="
				+ updatedBy + "]";
	}
	
	

}
