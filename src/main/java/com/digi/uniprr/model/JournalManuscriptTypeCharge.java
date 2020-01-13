package com.digi.uniprr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "journal_manuscript_type_charge")
public class JournalManuscriptTypeCharge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "journal_id")
	private Integer journalId;

	@Column(name = "manuscript_type_id")
	private Integer manuscriptTypeId;

	@Column(name = "fixed_charges")
	private String fixedCharges;

	@Column(name = "fixed_charge_amount")
	private Float fixedChargeAmount;

	@Column(name = "tables_charges")
	private Float tablesCharges;

	@Column(name = "figure_charges")
	private Float figureCharges;

	@Column(name = "color_figure_charges")
	private Float colorFigureCharges;

	@Column(name = "type_setting_charges")
	private Float typeSettingCharges;

	@Column(name = "additional_charges")
	private Float additionalCharges;

	/*
	 * @Column(name = "production_charges") private Float productionCharges;
	 */

	@Column(name = "currency")
	private String currency;

	@Column(name = "charge_amt")
	private Float chargeAmount;

	@Column(name = "is_active")
	private Integer isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Integer getManuscriptTypeId() {
		return manuscriptTypeId;
	}

	public void setManuscriptTypeId(Integer manuscriptTypeId) {
		this.manuscriptTypeId = manuscriptTypeId;
	}

	public String getFixedCharges() {
		return fixedCharges;
	}

	public void setFixedCharges(String fixedCharges) {
		this.fixedCharges = fixedCharges;
	}

	public Float getFixedChargeAmount() {
		return fixedChargeAmount;
	}

	public void setFixedChargeAmount(Float fixedChargeAmount) {
		this.fixedChargeAmount = fixedChargeAmount;
	}

	public Float getTablesCharges() {
		return tablesCharges;
	}

	public void setTablesCharges(Float tablesCharges) {
		this.tablesCharges = tablesCharges;
	}

	public Float getFigureCharges() {
		return figureCharges;
	}

	public void setFigureCharges(Float figureCharges) {
		this.figureCharges = figureCharges;
	}

	public Float getColorFigureCharges() {
		return colorFigureCharges;
	}

	public void setColorFigureCharges(Float colorFigureCharges) {
		this.colorFigureCharges = colorFigureCharges;
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

	/*
	 * public Float getProductionCharges() { return productionCharges; }
	 * 
	 * public void setProductionCharges(Float productionCharges) {
	 * this.productionCharges = productionCharges; }
	 */

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(Float chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
}
