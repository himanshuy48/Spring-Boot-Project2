package com.digi.uniprr.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.digi.uniprr.model.FunderDetails;
import com.digi.uniprr.model.ManuScript;

@Entity
@Table(name = "manuscript_funder")
public class ManuscriptFunder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "manuscript_id", updatable = false, insertable = false)
	private ManuScript manuscript;

	@Column(name = "manuscript_id")
	private Integer manuscriptId;

	@OneToOne
	@JoinColumn(name = "id", updatable = false, insertable = false)
	private FunderDetails funderDetails;

	@Column(name = "funder_id")
	private Integer funderId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ManuScript getManuscript() {
		return manuscript;
	}

	public void setManuscript(ManuScript manuscript) {
		this.manuscript = manuscript;
	}

	public Integer getManuscriptId() {
		return manuscriptId;
	}

	public void setManuscriptId(Integer manuscriptId) {
		this.manuscriptId = manuscriptId;
	}

	public FunderDetails getFunderDetails() {
		return funderDetails;
	}

	public void setFunderDetails(FunderDetails funderDetails) {
		this.funderDetails = funderDetails;
	}

	public Integer getFunderId() {
		return funderId;
	}

	public void setFunderId(Integer funderId) {
		this.funderId = funderId;
	}

	@Override
	public String toString() {
		return "ManuscriptFunder [id=" + id + ", manuscript=" + manuscript + ", manuscriptId=" + manuscriptId
				+ ", funderDetails=" + funderDetails + ", funderId=" + funderId + "]";
	}
}
