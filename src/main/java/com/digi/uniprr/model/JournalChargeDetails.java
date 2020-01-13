package com.digi.uniprr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "journal_charge_details")
public class JournalChargeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jc_id")
	private Integer journalChargeId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "journal_id", insertable = false, updatable = false)
	private Journal journal;

	@Column(name = "journal_id")
	private Integer journalId;

	@Column(name = "component")
	private String component;

	@Column(name = "charge_amt")
	private Float chargeAmount;

	@Column(name = "fixed_charges")
	private String fixedCharges;

	@Column(name = "color_charges")
	private Float colorCharges;

	@Column(name = "black_white_charges")
	private Float blackWhiteCharges;

	@Column(name = "tables_charges")
	private Float tableCharges;
	
	@Column(name="type_setting_charges")
	private Float typeSettingCharges;

	@Column(name = "additional_charges")
	private Float additionalCharges;

	@Column(name = "production_charges")
	private Float productionCharges;

	@Column(name = "currency")
	private String currency;
	
	@Column(name="fixed_charge_amount")
	private Float fixedChargeAmount;

	public Integer getJournalChargeId() {
		return journalChargeId;
	}

	public void setJournalChargeId(Integer journalChargeId) {
		this.journalChargeId = journalChargeId;
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

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Float getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(Float chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public String getFixedCharges() {
		return fixedCharges;
	}

	public void setFixedCharges(String fixedCharges) {
		this.fixedCharges = fixedCharges;
	}

	public Float getColorCharges() {
		return colorCharges;
	}

	public void setColorCharges(Float colorCharges) {
		this.colorCharges = colorCharges;
	}

	public Float getBlackWhiteCharges() {
		return blackWhiteCharges;
	}

	public void setBlackWhiteCharges(Float blackWhiteCharges) {
		this.blackWhiteCharges = blackWhiteCharges;
	}

	public Float getTableCharges() {
		return tableCharges;
	}

	public void setTableCharges(Float tableCharges) {
		this.tableCharges = tableCharges;
	}
	
	public Float getTypeSettingCharges() {
		return typeSettingCharges;
	}

	public void setTypeSettingCharges(Float typeSettingCharges) {
		this.typeSettingCharges = typeSettingCharges;
	}

	public Float getAdditionalCharges() {
		return additionalCharges;
	}

	public void setAdditionalCharges(Float additionalCharges) {
		this.additionalCharges = additionalCharges;
	}

	public Float getProductionCharges() {
		return productionCharges;
	}

	public void setProductionCharges(Float productionCharges) {
		this.productionCharges = productionCharges;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getFixedChargeAmount() {
		return fixedChargeAmount;
	}

	public void setFixedChargeAmount(Float fixedChargeAmount) {
		this.fixedChargeAmount = fixedChargeAmount;
	}
	
}
