package com.digi.uniprr.VO;

import java.util.List;

public class ManuscriptTypeTitleAbstractVO {
	
	private Integer manuscriptId;
	
	private Integer manuscriptVersion ;
	
	private String manuscriptCode;
	
	private String manuscriptTypeJournal;
	
	private String title;
	
	private String shortTitle;
	
	private String manuscriptAbstract;
	
	private String runningHead;
	
	private String manuscriptFigures;

	private String manuscriptColorFigures;

	private String blackAndWhiteFigures;

	private String manuscriptTables;

	private String manuscriptWords;

	private String manuscriptPages;
	
	private String manuscriptRegionOfOrigin;
	
	private List<KeywordsVO> journalKeywords;
	
	private List<ManuscriptKeywordsVO> manuscriptKeywords;

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

	public String getManuscriptCode() {
		return manuscriptCode;
	}

	public void setManuscriptCode(String manuscriptCode) {
		this.manuscriptCode = manuscriptCode;
	}

	public String getManuscriptTypeJournal() {
		return manuscriptTypeJournal;
	}

	public void setManuscriptTypeJournal(String manuscriptTypeJournal) {
		this.manuscriptTypeJournal = manuscriptTypeJournal;
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

	public String getManuscriptAbstract() {
		return manuscriptAbstract;
	}

	public void setManuscriptAbstract(String manuscriptAbstract) {
		this.manuscriptAbstract = manuscriptAbstract;
	}

	public String getRunningHead() {
		return runningHead;
	}

	public void setRunningHead(String runningHead) {
		this.runningHead = runningHead;
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
	
	public String getManuscriptRegionOfOrigin() {
		return manuscriptRegionOfOrigin;
	}

	public void setManuscriptRegionOfOrigin(String manuscriptRegionOfOrigin) {
		this.manuscriptRegionOfOrigin = manuscriptRegionOfOrigin;
	}

	public List<KeywordsVO> getJournalKeywords() {
		return journalKeywords;
	}

	public void setJournalKeywords(List<KeywordsVO> journalKeywords) {
		this.journalKeywords = journalKeywords;
	}

	public List<ManuscriptKeywordsVO> getManuscriptKeywords() {
		return manuscriptKeywords;
	}

	public void setManuscriptKeywords(List<ManuscriptKeywordsVO> manuscriptKeywords) {
		this.manuscriptKeywords = manuscriptKeywords;
	}

	
	
}
