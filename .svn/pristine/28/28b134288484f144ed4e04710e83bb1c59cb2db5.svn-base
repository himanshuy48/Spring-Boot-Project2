package com.digi.uniprr.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="journal_keyword")
public class JournalKeywordBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jk_id")
	private Integer id;
	
	@Column(name="journal_id")
	private Integer journalId;
	
	@Column(name="keyword_id")
	private Integer keywordId;

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

	public Integer getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Integer keywordId) {
		this.keywordId = keywordId;
	}
	
	
}
