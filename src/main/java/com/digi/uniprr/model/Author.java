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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.enums.AuthorRole;
import com.digi.uniprr.enums.Salutation;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "author_id")
	private Integer authorId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="salutation")
	private Salutation salutation;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")	
	private String lastName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="add1")
	private String addressOne;
	
	@Column (name="add2")
	private String addressTwo;
	
	@ManyToOne
	@JoinColumn(name="country_id", insertable = false, updatable = false)
	private Countries country;
	
	@Column(name="country_id")
	private Integer countryId;
	
	@ManyToOne
	@JoinColumn(name="state_id", insertable = false, updatable = false)
	private States state;
	
	@Column(name="state_id")
	private Integer stateId;
	
	@ManyToOne
	@JoinColumn(name="city_id", insertable = false, updatable = false)
	private Cities city;
	
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="author_email")
	private String authorEmail;
	
	@Column(name="orcid_passwd")
	private String orcidPassword;
	
	@Enumerated(EnumType.STRING)
	@Column(name="author_role")
	private AuthorRole authorRole;
	
	@ManyToOne
	@JoinColumn(name="institute_id", insertable = false, updatable = false)
	private Institution institution;
	
	@Column(name="institute_id")
	private Integer institutionId;
	
	@Column(name="phone_nbr")
	private Long phoneNumber;
	
	@Column(name="orcidid")
	private String orcidid;
	
	@Column(name="speciality")
	private String speciality;
	
	@OneToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private User user;
	
	@Column(name="user_id")
	private Integer userId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")	
	@Column(name="created_on")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	@Column(name="updated_on")
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name="updated_by")
	private Integer updatedBy;
	
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Cities getCity() {
		return city;
	}

	public void setCity(Cities city) {
		this.city = city;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getOrcidPassword() {
		return orcidPassword;
	}

	public void setOrcidPassword(String orcidPassword) {
		this.orcidPassword = orcidPassword;
	}

	public AuthorRole getAuthorRole() {
		return authorRole;
	}

	public void setAuthorRole(AuthorRole authorRole) {
		this.authorRole = authorRole;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Integer getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrcidid() {
		return orcidid;
	}

	public void setOrcidid(String orcidid) {
		this.orcidid = orcidid;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
