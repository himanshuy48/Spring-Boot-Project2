package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.enums.Salutation;

@Entity
@Table(name = "reviewer_suggested")
public class ReviewerSuggested {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "manuscript_id")
	private Integer manuscriptId;
	
	@Column(name = "manuscript_version")
	private Integer manuscriptVersion;
	
	@Column(name = "reviewer_id")
	private Integer reviewerId;
	
	@Column(name = "journal_id")
	private Integer journalId;
	
	@Column(name = "manuscript_status")
	private Integer manuscriptStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "salutation")
	private Salutation salutation;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "suggested_by")
	private Integer suggestedBy;
	
	@Column(name = "suggested_reviewer_id")
	private Integer suggestedReviewerId;
	
	@Column(name = "approved_suggested_id")
	private Integer approvedSuggestedId;
	
	@Column(name = "suggested_by_comments")
	private String suggestedByComments;
	
	@Column(name = "approved_by_comments")
	private String approvedByComments;
	
	@Column(name = "approved")
	private String approved;

	@Column(name = "is_suggested")
	private String isSuggested;
	
	@Column(name = "is_assigned")
	private Integer isAssigned;
	
	@CreationTimestamp
	@Column(name = "suggested_on")
	private Date suggestedOn;
	
	@UpdateTimestamp
	@Column(name = "decision_on")
	private Date decisionOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Integer getManuscriptStatus() {
		return manuscriptStatus;
	}

	public void setManuscriptStatus(Integer manuscriptStatus) {
		this.manuscriptStatus = manuscriptStatus;
	}

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSuggestedBy() {
		return suggestedBy;
	}

	public void setSuggestedBy(Integer suggestedBy) {
		this.suggestedBy = suggestedBy;
	}

	public Integer getSuggestedReviewerId() {
		return suggestedReviewerId;
	}

	public void setSuggestedReviewerId(Integer suggestedReviewerId) {
		this.suggestedReviewerId = suggestedReviewerId;
	}

	public Integer getApprovedSuggestedId() {
		return approvedSuggestedId;
	}

	public void setApprovedSuggestedId(Integer approvedSuggestedId) {
		this.approvedSuggestedId = approvedSuggestedId;
	}

	public String getSuggestedByComments() {
		return suggestedByComments;
	}

	public void setSuggestedByComments(String suggestedByComments) {
		this.suggestedByComments = suggestedByComments;
	}

	public String getApprovedByComments() {
		return approvedByComments;
	}

	public void setApprovedByComments(String approvedByComments) {
		this.approvedByComments = approvedByComments;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getIsSuggested() {
		return isSuggested;
	}

	public void setIsSuggested(String isSuggested) {
		this.isSuggested = isSuggested;
	}

	public Integer getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(Integer isAssigned) {
		this.isAssigned = isAssigned;
	}

	public Date getSuggestedOn() {
		return suggestedOn;
	}

	public void setSuggestedOn(Date suggestedOn) {
		this.suggestedOn = suggestedOn;
	}

	public Date getDecisionOn() {
		return decisionOn;
	}

	public void setDecisionOn(Date decisionOn) {
		this.decisionOn = decisionOn;
	}
	
}
