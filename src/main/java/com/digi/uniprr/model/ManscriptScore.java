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

@Entity
@Table(name="manscript_score")
public class ManscriptScore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name="manu_script_id")
	private Integer manuScriptId;
	
	@Column(name="manuscript_version")
	private Integer manuscriptVersion;
	
	@Column(name="avg_syllables_count")
	private Double avgSyllablesCount;
	
	@Column(name="avg_word_length")
	private Double avgWordLength;
	
	@Column(name="difficult_words_ratio")
	private Double difficultWordsRatio;
	
	@Column(name="flesch_kincaid_grade")
	private Double fleschKincaidGrade;
	
	@Column(name="flesch_reading_ease")
	private Double fleschReadingEase;
	
	@Column(name="gunning_fog_index")
	private Double gunningFogIndex;
	
	@Column(name="pos_ratio")
	private Double posRatio;
	
	@Column(name="sentence_length")
	private Double sentenceLength;
	
	@Column(name="sentence_no")
	private Double sentenceNo;
	
	@Column(name="type_to_token_ratio")
	private Double typeToTokenRatio;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_on", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getManuScriptId() {
		return manuScriptId;
	}

	public void setManuScriptId(Integer manuScriptId) {
		this.manuScriptId = manuScriptId;
	}

	public Integer getManuscriptVersion() {
		return manuscriptVersion;
	}

	public void setManuscriptVersion(Integer manuscriptVersion) {
		this.manuscriptVersion = manuscriptVersion;
	}

	public Double getAvgSyllablesCount() {
		return avgSyllablesCount;
	}

	public void setAvgSyllablesCount(Double avgSyllablesCount) {
		this.avgSyllablesCount = avgSyllablesCount;
	}

	public Double getAvgWordLength() {
		return avgWordLength;
	}

	public void setAvgWordLength(Double avgWordLength) {
		this.avgWordLength = avgWordLength;
	}

	public Double getDifficultWordsRatio() {
		return difficultWordsRatio;
	}

	public void setDifficultWordsRatio(Double difficultWordsRatio) {
		this.difficultWordsRatio = difficultWordsRatio;
	}

	public Double getFleschKincaidGrade() {
		return fleschKincaidGrade;
	}

	public void setFleschKincaidGrade(Double fleschKincaidGrade) {
		this.fleschKincaidGrade = fleschKincaidGrade;
	}

	public Double getFleschReadingEase() {
		return fleschReadingEase;
	}

	public void setFleschReadingEase(Double fleschReadingEase) {
		this.fleschReadingEase = fleschReadingEase;
	}

	public Double getGunningFogIndex() {
		return gunningFogIndex;
	}

	public void setGunningFogIndex(Double gunningFogIndex) {
		this.gunningFogIndex = gunningFogIndex;
	}

	public Double getPosRatio() {
		return posRatio;
	}

	public void setPosRatio(Double posRatio) {
		this.posRatio = posRatio;
	}

	public Double getSentenceLength() {
		return sentenceLength;
	}

	public void setSentenceLength(Double sentenceLength) {
		this.sentenceLength = sentenceLength;
	}

	public Double getSentenceNo() {
		return sentenceNo;
	}

	public void setSentenceNo(Double sentenceNo) {
		this.sentenceNo = sentenceNo;
	}

	public Double getTypeToTokenRatio() {
		return typeToTokenRatio;
	}

	public void setTypeToTokenRatio(Double typeToTokenRatio) {
		this.typeToTokenRatio = typeToTokenRatio;
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

}
