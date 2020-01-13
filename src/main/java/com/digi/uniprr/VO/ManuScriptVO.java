package com.digi.uniprr.VO;

public class ManuScriptVO {

	private Integer manuscriptId;

	private Integer manuscriptVersion;

	private Integer id;
	
	private Integer version;

	private Integer journalId;

	private String journalName;

	private String title;

	private String shortTitle;

	private Integer authorId;

	private Integer manuscriptTypeDetailsId;

	private String manuscriptFigures;

	private String manuscriptColorFigures;

	private String blackAndWhiteFigures;

	private String manuscriptTables;

	private String manuscriptWords;

	private String manuscriptPages;
	
	private String declarationOfInterest;
	
	private String copyrightAgreement;

	private String CreatedOn;

	private String validate;

	private String assignTo;

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
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getDeclarationOfInterest() {
		return declarationOfInterest;
	}

	public void setDeclarationOfInterest(String declarationOfInterest) {
		this.declarationOfInterest = declarationOfInterest;
	}

	public String getCopyrightAgreement() {
		return copyrightAgreement;
	}

	public void setCopyrightAgreement(String copyrightAgreement) {
		this.copyrightAgreement = copyrightAgreement;
	}

	public String getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getManuscriptTypeDetailsId() {
		return manuscriptTypeDetailsId;
	}

	public void setManuscriptTypeDetailsId(Integer manuscriptTypeDetailsId) {
		this.manuscriptTypeDetailsId = manuscriptTypeDetailsId;
	}

	public String getManuscriptFigures() {
		return manuscriptFigures;
	}

	public void setManuscriptFigures(String manuscriptFigures) {
		this.manuscriptFigures = manuscriptFigures;
	}

	public String getManuscriptColorFigures() {
		return manuscriptColorFigures;
	}

	public void setManuscriptColorFigures(String manuscriptColorFigures) {
		this.manuscriptColorFigures = manuscriptColorFigures;
	}

	public String getBlackAndWhiteFigures() {
		return blackAndWhiteFigures;
	}

	public void setBlackAndWhiteFigures(String blackAndWhiteFigures) {
		this.blackAndWhiteFigures = blackAndWhiteFigures;
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

}
