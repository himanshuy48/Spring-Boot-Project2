package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voucher_master")
public class VoucherMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "voucher_code")
	private Integer voucherCode;

	@Column(name = "voucher_descrip")
	private String voucherDescription;

	@Column(name = "voucher_start_date")
	private Date voucherStartDate;

	@Column(name = "voucher_end_date")
	private Date voucherEndDate;

	@Column(name = "is_active")
	private Integer isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(Integer voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getVoucherDescription() {
		return voucherDescription;
	}

	public void setVoucherDescription(String voucherDescription) {
		this.voucherDescription = voucherDescription;
	}

	public Date getVoucherStartDate() {
		return voucherStartDate;
	}

	public void setVoucherStartDate(Date voucherStartDate) {
		this.voucherStartDate = voucherStartDate;
	}

	public Date getVoucherEndDate() {
		return voucherEndDate;
	}

	public void setVoucherEndDate(Date voucherEndDate) {
		this.voucherEndDate = voucherEndDate;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
