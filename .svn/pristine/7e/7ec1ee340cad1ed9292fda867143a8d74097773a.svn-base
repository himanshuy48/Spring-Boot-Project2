package com.digi.uniprr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="master_attributes")
public class MasterAttributes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Integer Id;
	
	@Column(name="category")
	private String category;
	
	@Column(name = "chk_key")
	private String chkKey;
	
	@Column(name="chk_desc")
	private String chkDesc;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getChkKey() {
		return chkKey;
	}

	public void setChkKey(String chkKey) {
		this.chkKey = chkKey;
	}

	public String getChkDesc() {
		return chkDesc;
	}

	public void setChkDesc(String chkDesc) {
		this.chkDesc = chkDesc;
	}

}
