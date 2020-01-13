package com.digi.uniprr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.enums.YNStatus;

@Entity
@Table(name = "manuscript_author")

public class ManuscriptAuthor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ma_id")
	private Integer id;

	@Column(name = "manuscript_id")
	private Integer manuscritpId;

	@OneToOne
	@JoinColumn(name="author_id" , referencedColumnName = "author_id" , insertable = false , updatable = false) 
	private Author author;

	@Column(name = "author_id")
	private Integer authorId;

	@Enumerated(EnumType.STRING)
	@Column(name = "primary_author")
	private YNStatus primaryAuthor;

	/*
	 * @Column(name = "created_on")
	 * 
	 * @CreationTimestamp private Date createdOn;
	 * 
	 * @Column(name = "created_by") private Integer createdBy;
	 * 
	 * @Column(name = "updated_on")
	 * 
	 * @UpdateTimestamp private Date updatedOn;
	 * 
	 * @Column(name = "updated_by") private Integer updatedBy;
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getManuscritpId() {
		return manuscritpId;
	}

	public void setManuscritpId(Integer manuscritpId) {
		this.manuscritpId = manuscritpId;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public YNStatus getPrimaryAuthor() {
		return primaryAuthor;
	}

	public void setPrimaryAuthor(YNStatus primaryAuthor) {
		this.primaryAuthor = primaryAuthor;
	}

	
}