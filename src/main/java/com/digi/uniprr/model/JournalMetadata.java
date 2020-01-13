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
@Table(name="journal_metadata")
public class JournalMetadata {
	
	@Id
	@Column(name = "metadata_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer metadataId;

	@OneToOne
	@JoinColumn(name = "journal_id", insertable = false, updatable = false)
	private Journal journal;

	@Column(name = "journal_id")
	private Integer journalId;

	@Column(name = "affiliated_to")
	private String affilitaedTo;

	@Column(name = "bibliography")
	private String bibliography;

	@Column(name = "code")
	private String code;
	
	@Column(name="publication_type")
	private String publicationType;

	@Column(name = "colour_figures")
	private Double colourFigures;

	@Column(name = "cite_score")
	private Float citeScore;
	
	@Column(name = "impact_factor")
	private Float impactFactor;
	
	@Column(name = "acceptance_rate")
	private Double acceptanceRate;
	
	@Column(name = "journal_doi")
	private String journalDOI;

	@Column(name = "journal_eissn")
	private String journalEissn;

	@Column(name = "journal_issn")
	private String journalIssn;

	@Column(name = "journal_frequency")
	private String journalFrequency;

	@Column(name = "journal_index_copernicus")
	private String journalIndexCopernicus;

	@Column(name = "open_access")
	private String openAccess;

	@Column(name = "is_chargingreq")
	private String isChargingRequired;
	
	@Column(name = "charge_on")
	private String chargeOn;

	@Column(name = "journal_readership")
	private String journalReadership;

	@Column(name = "journal_blind_type")
	private String journalBlindType;

	@Column(name = "journal_speciality")
	private String journalSpeciality;

	@Column(name = "journal_sub_category")
	private String journalSubCategory;

	@Column(name = "journal_subject")
	private String journalSubject;

	@Column(name = "tblcost")
	private Double tblcost;

	@Column(name = "extend_due_date")
	private Integer extendDueDate;

	@Column(name = "typesetting")
	private Double typseStting;

	@Column(name = "suggest_reviewer")
	private String suggestReviewer;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_on")
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Column(name = "updated_on")
	@UpdateTimestamp
	private Date updatedOn;

	public Integer getMetadataId() {
		return metadataId;
	}

	public void setMetadataId(Integer metadataId) {
		this.metadataId = metadataId;
	}

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getAffilitaedTo() {
		return affilitaedTo;
	}

	public void setAffilitaedTo(String affilitaedTo) {
		this.affilitaedTo = affilitaedTo;
	}

	public String getBibliography() {
		return bibliography;
	}

	public void setBibliography(String bibliography) {
		this.bibliography = bibliography;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getColourFigures() {
		return colourFigures;
	}

	public void setColourFigures(Double colourFigures) {
		this.colourFigures = colourFigures;
	}

	public Float getCiteScore() {
		return citeScore;
	}

	public void setCiteScore(Float citeScore) {
		this.citeScore = citeScore;
	}

	public Float getImpactFactor() {
		return impactFactor;
	}

	public void setImpactFactor(Float impactFactor) {
		this.impactFactor = impactFactor;
	}

	public Double getAcceptanceRate() {
		return acceptanceRate;
	}

	public void setAcceptanceRate(Double acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}

	public String getJournalDOI() {
		return journalDOI;
	}

	public void setJournalDOI(String journalDOI) {
		this.journalDOI = journalDOI;
	}

	public String getJournalEissn() {
		return journalEissn;
	}

	public void setJournalEissn(String journalEissn) {
		this.journalEissn = journalEissn;
	}

	public String getJournalIssn() {
		return journalIssn;
	}

	public void setJournalIssn(String journalIssn) {
		this.journalIssn = journalIssn;
	}

	public String getJournalFrequency() {
		return journalFrequency;
	}

	public void setJournalFrequency(String journalFrequency) {
		this.journalFrequency = journalFrequency;
	}

	public String getJournalIndexCopernicus() {
		return journalIndexCopernicus;
	}

	public void setJournalIndexCopernicus(String journalIndexCopernicus) {
		this.journalIndexCopernicus = journalIndexCopernicus;
	}

	public String getOpenAccess() {
		return openAccess;
	}

	public void setOpenAccess(String openAccess) {
		this.openAccess = openAccess;
	}

	public String getIsChargingRequired() {
		return isChargingRequired;
	}

	public void setIsChargingRequired(String isChargingRequired) {
		this.isChargingRequired = isChargingRequired;
	}

	public String getChargeOn() {
		return chargeOn;
	}

	public void setChargeOn(String chargeOn) {
		this.chargeOn = chargeOn;
	}

	public String getJournalReadership() {
		return journalReadership;
	}

	public void setJournalReadership(String journalReadership) {
		this.journalReadership = journalReadership;
	}

	public String getJournalBlindType() {
		return journalBlindType;
	}

	public void setJournalBlindType(String journalBlindType) {
		this.journalBlindType = journalBlindType;
	}

	public String getJournalSpeciality() {
		return journalSpeciality;
	}

	public void setJournalSpeciality(String journalSpeciality) {
		this.journalSpeciality = journalSpeciality;
	}

	public String getJournalSubCategory() {
		return journalSubCategory;
	}

	public void setJournalSubCategory(String journalSubCategory) {
		this.journalSubCategory = journalSubCategory;
	}

	public String getJournalSubject() {
		return journalSubject;
	}

	public void setJournalSubject(String journalSubject) {
		this.journalSubject = journalSubject;
	}

	public Double getTblcost() {
		return tblcost;
	}

	public void setTblcost(Double tblcost) {
		this.tblcost = tblcost;
	}

	public Integer getExtendDueDate() {
		return extendDueDate;
	}

	public void setExtendDueDate(Integer extendDueDate) {
		this.extendDueDate = extendDueDate;
	}

	public Double getTypseStting() {
		return typseStting;
	}

	public void setTypseStting(Double typseStting) {
		this.typseStting = typseStting;
	}

	public String getSuggestReviewer() {
		return suggestReviewer;
	}

	public void setSuggestReviewer(String suggestReviewer) {
		this.suggestReviewer = suggestReviewer;
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

	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}

	@Override
	public String toString() {
		return "JournalMetadata [metadataId=" + metadataId + ", journal=" + journal + ", journalId=" + journalId
				+ ", affilitaedTo=" + affilitaedTo + ", bibliography=" + bibliography + ", code=" + code
				+ ", publicationType=" + publicationType + ", colourFigures=" + colourFigures + ", citeScore="
				+ citeScore + ", impactFactor=" + impactFactor + ", acceptanceRate=" + acceptanceRate + ", journalDOI="
				+ journalDOI + ", journalEissn=" + journalEissn + ", journalIssn=" + journalIssn + ", journalFrequency="
				+ journalFrequency + ", journalIndexCopernicus=" + journalIndexCopernicus + ", openAccess=" + openAccess
				+ ", isChargingRequired=" + isChargingRequired + ", chargeOn=" + chargeOn + ", journalReadership="
				+ journalReadership + ", journalBlindType=" + journalBlindType + ", journalSpeciality="
				+ journalSpeciality + ", journalSubCategory=" + journalSubCategory + ", journalSubject="
				+ journalSubject + ", tblcost=" + tblcost + ", extendDueDate=" + extendDueDate + ", typseStting="
				+ typseStting + ", suggestReviewer=" + suggestReviewer + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
}
