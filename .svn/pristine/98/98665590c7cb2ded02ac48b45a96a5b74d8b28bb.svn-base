package com.digi.uniprr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import com.digi.uniprr.enums.Salutation;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "orcid_id")
	private String orcidId;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_email_cc")
	private String emailCC;
	
	@Column(name = "user_sec_email")
	private String secondaryEmail;
	
	@Column(name = "user_sec_email_cc")
	private String secondaryEmailCC;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "salutation")
	private Salutation salutation;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "institute")
	private String institute;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "address2")
	private String addressTwo;
	
	@Column(name = "address3")
	private String addressThree;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "phone_no")
	private String phoneNumber;
	
	@Column(name = "mobile_no")
	private String mobileNumber;
	
	@Column(name = "fax_no")
	private String faxNumber;
	
	@Column(name = "is_active")
	private Integer isActive;
	
	@Column(name = "country_id")
	private Integer countryId;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "area_interest")
	private String areaOfInterest;
	
	@Column(name = "notification_flag")
	private Integer notificationFlag;
	
	@Column(name = "publication_name")
	private String publicationName;
	
	@Column(name = "account_expired")
	private String accountExpired;
	
	@Column(name = "account_locked")
	private String accountLocked;
	
	@Column(name = "desgination")
	private String designation;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "expertise")
	private String expertise;
	
	@Column(name = "email_notification")
	private Integer emailNotification;
	
	@Column(name = "sms_notification")
	private String smsNotification;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdDate;
	
	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Column(name = "updated_date")
	@UpdateTimestamp
	private Date updatedDate;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_group", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "group_id", referencedColumnName = "id") }) 
	@JsonIgnore
	private List<Groups> group;
	
	@OneToMany
	@JoinTable(name = "users_journals", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "journal_id", referencedColumnName = "journal_id") }) 
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<Journal> journal;
	
	@OneToMany
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "usr_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") }) 
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List <Role> role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrcidId() {
		return orcidId;
	}

	public void setOrcidId(String orcidId) {
		this.orcidId = orcidId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailCC() {
		return emailCC;
	}

	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getSecondaryEmailCC() {
		return secondaryEmailCC;
	}

	public void setSecondaryEmailCC(String secondaryEmailCC) {
		this.secondaryEmailCC = secondaryEmailCC;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getAddressThree() {
		return addressThree;
	}

	public void setAddressThree(String addressThree) {
		this.addressThree = addressThree;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public Integer getNotificationFlag() {
		return notificationFlag;
	}

	public void setNotificationFlag(Integer notificationFlag) {
		this.notificationFlag = notificationFlag;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public String getAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(String accountExpired) {
		this.accountExpired = accountExpired;
	}

	public String getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(String accountLocked) {
		this.accountLocked = accountLocked;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Integer getEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(Integer emailNotification) {
		this.emailNotification = emailNotification;
	}

	public String getSmsNotification() {
		return smsNotification;
	}

	public void setSmsNotification(String smsNotification) {
		this.smsNotification = smsNotification;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Groups> getGroup() {
		return group;
	}

	public void setGroup(List<Groups> group) {
		this.group = group;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public List<Journal> getJournal() {
		return journal;
	}

	public void setJournal(List<Journal> journal) {
		this.journal = journal;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", orcidId=" + orcidId + ", username=" + username + ", password=" + password
				+ ", token=" + token + ", email=" + email + ", emailCC=" + emailCC + ", secondaryEmail="
				+ secondaryEmail + ", secondaryEmailCC=" + secondaryEmailCC + ", salutation=" + salutation
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", userType="
				+ userType + ", institute=" + institute + ", state=" + state + ", address=" + address + ", addressTwo="
				+ addressTwo + ", addressThree=" + addressThree + ", department=" + department + ", phoneNumber="
				+ phoneNumber + ", mobileNumber=" + mobileNumber + ", faxNumber=" + faxNumber + ", isActive=" + isActive
				+ ", countryId=" + countryId + ", city=" + city + ", postalCode=" + postalCode + ", areaOfInterest="
				+ areaOfInterest + ", notificationFlag=" + notificationFlag + ", publicationName=" + publicationName
				+ ", accountExpired=" + accountExpired + ", accountLocked=" + accountLocked + ", designation="
				+ designation + ", specialization=" + specialization + ", experience=" + experience + ", expertise="
				+ expertise + ", emailNotification=" + emailNotification + ", smsNotification=" + smsNotification
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", group=" + group + ", journal=" + journal + ", role=" + role + "]";
	}
	
	

}
