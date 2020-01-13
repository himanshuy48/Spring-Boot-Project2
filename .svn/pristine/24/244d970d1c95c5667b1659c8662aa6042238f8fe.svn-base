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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "manuscript_typedetails")
public class ManuscriptTypeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "manuscript_id", insertable = false, updatable = false)
	private ManuScript manuscript;

	@Column(name = "manuscript_id")
	private Integer manuscriptId;
	
	@Column(name="manuscript_version")
    private Integer manuscriptVersion;
	
	@Column(name = "manuscript_type")
	private String manuscriptType;

	@Column(name = "manuscript_title")
	private String manuscriptTitle;

	@Column(name = "manuscript_running_head")
	private String manuscriptRunningHead;

	@Column(name = "manuscript_abstract")
	private String manuscriptAbstract;

	@Column(name = "manuscript_submission_type")
	private String manuscriptSubmissionType;

	@Column(name = "manuscript_cover_letter")
	private String manuscriptCoverLetter;

	@Column(name = "manuscript_cover_letter_filepath")
	private String manuscriptCoverLetterFilepath;

	@Column(name = "manuscript_figures")
	private String manuscriptFigures;
	
	@Column(name="manuscript_black_white_figures")
	private String manuscriptBlackWhiteFigures;

	@Column(name = "manuscript_color_figures")
	private String manuscriptColorFigures;

	@Column(name = "manuscript_tables")
	private String manuscriptTables;

	@Column(name = "manuscript_words")
	private String manuscriptWords;

	@Column(name = "manuscript_pages")
	private String manuscriptPages;

	@Column(name = "manuscript_paragraph")
	private String manuscriptParagraph;
	
	@Column(name = "manuscript_introduction")
	private String manuscriptIntroduction;
	
	@Column(name = "manuscript_acknowledgment")
	private String manuscriptAcknowledgment;
	
	@Column(name = "manuscript_references")
	private String manuscriptReferences;
	
	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_on", nullable = false, updatable = false )
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_on")
	@UpdateTimestamp
	private Date updatedOn;

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
	
	public ManuScript getManuscript() {
		return manuscript;
	}

	public Integer getManuscriptVersion() {
		return manuscriptVersion;
	}

	public void setManuscriptVersion(Integer manuscriptVersion) {
		this.manuscriptVersion = manuscriptVersion;
	}

	public void setManuscript(ManuScript manuscript) {
		this.manuscript = manuscript;
	}

	public String getManuscriptType() {
		return manuscriptType;
	}

	public void setManuscriptType(String manuscriptType) {
		this.manuscriptType = manuscriptType;
	}

	public String getManuscriptTitle() {
		return manuscriptTitle;
	}

	public void setManuscriptTitle(String manuscriptTitle) {
		this.manuscriptTitle = manuscriptTitle;
	}

	public String getManuscriptRunningHead() {
		return manuscriptRunningHead;
	}

	public void setManuscriptRunningHead(String manuscriptRunningHead) {
		this.manuscriptRunningHead = manuscriptRunningHead;
	}

	public String getManuscriptAbstract() {
		return manuscriptAbstract;
	}

	public void setManuscriptAbstract(String manuscriptAbstract) {
		this.manuscriptAbstract = manuscriptAbstract;
	}

	public String getManuscriptSubmissionType() {
		return manuscriptSubmissionType;
	}

	public void setManuscriptSubmissionType(String manuscriptSubmissionType) {
		this.manuscriptSubmissionType = manuscriptSubmissionType;
	}

	public String getManuscriptCoverLetter() {
		return manuscriptCoverLetter;
	}

	public void setManuscriptCoverLetter(String manuscriptCoverLetter) {
		this.manuscriptCoverLetter = manuscriptCoverLetter;
	}

	public String getManuscriptCoverLetterFilepath() {
		return manuscriptCoverLetterFilepath;
	}

	public void setManuscriptCoverLetterFilepath(String manuscriptCoverLetterFilepath) {
		this.manuscriptCoverLetterFilepath = manuscriptCoverLetterFilepath;
	}

	public String getManuscriptFigures() {
		return manuscriptFigures;
	}

	public void setManuscriptFigures(String manuscriptFigures) {
		this.manuscriptFigures = manuscriptFigures;
	}

	public String getManuscriptBlackWhiteFigures() {
		return manuscriptBlackWhiteFigures;
	}

	public void setManuscriptBlackWhiteFigures(String manuscriptBlackWhiteFigures) {
		this.manuscriptBlackWhiteFigures = manuscriptBlackWhiteFigures;
	}

	public String getManuscriptColorFigures() {
		return manuscriptColorFigures;
	}

	public void setManuscriptColorFigures(String manuscriptColorFigures) {
		this.manuscriptColorFigures = manuscriptColorFigures;
	}

	public String getManuscriptTables() {
		return manuscriptTables;
	}

	public void setManuscriptTables(String manuscriptTables) {
		this.manuscriptTables = manuscriptTables;
	}

	public String getManuscriptWords() {
		return manuscriptWords;
	}

	public void setManuscriptWords(String manuscriptWords) {
		this.manuscriptWords = manuscriptWords;
	}

	public String getManuscriptPages() {
		return manuscriptPages;
	}

	public void setManuscriptPages(String manuscriptPages) {
		this.manuscriptPages = manuscriptPages;
	}

	public String getManuscriptParagraph() {
		return manuscriptParagraph;
	}

	public void setManuscriptParagraph(String manuscriptParagraph) {
		this.manuscriptParagraph = manuscriptParagraph;
	}

	public String getManuscriptIntroduction() {
		return manuscriptIntroduction;
	}

	public void setManuscriptIntroduction(String manuscriptIntroduction) {
		this.manuscriptIntroduction = manuscriptIntroduction;
	}

	public String getManuscriptAcknowledgment() {
		return manuscriptAcknowledgment;
	}

	public void setManuscriptAcknowledgment(String manuscriptAcknowledgment) {
		this.manuscriptAcknowledgment = manuscriptAcknowledgment;
	}

	public String getManuscriptReferences() {
		return manuscriptReferences;
	}

	public void setManuscriptReferences(String manuscriptReferences) {
		this.manuscriptReferences = manuscriptReferences;
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

}