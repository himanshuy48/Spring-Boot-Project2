package com.digi.uniprr.VO;

import java.util.List;

import com.digi.uniprr.enums.Salutation;
import com.digi.uniprr.model.Groups;

public class UserVO 
{
	private Integer id;

	private String orcidId;
	
	private String username;
	
	private String password;
	
	private String token;
	
	private String email;
	
	private String emailCC;
	
	private String secondaryEmail;
	
	private String secondaryEmailCC;
	
	private Salutation salutation;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String userType;
	
	private String institute;
	
	private String state;
	
	private String address;
	
	private String addressTwo;
	
	private String addressThree;
	
	private String department;
	
	private String phoneNumber;
	
	private String mobileNumber;
	
	private String faxNumber;
	
	private Integer isActive;
	
	private Integer countryId;
	
	private String city;
	
	private String postalCode;
	
	private String areaOfInterest;
	
	private Integer notificationFlag;
	
	private String publicationName;
	
	private String accountExpired;
	
	private String accountLocked;
	
	private String designation;
	
	private String specialization;
	
	private String experience;
	
	private String expertise;
	
	private Integer emailNotification;
	
	private String smsNotification;
	
	private List<ExpertiseVO> expertiseData;
	
	private List<RoleVO> role;
	
	private List<GroupVO> group;
	
	private List<Integer> roleId;
	
	private List<Integer> groupId;
	
	private List<JournalListVO> journalVO;
	
	private List<Integer> journalId;
	
	public List<ExpertiseVO> getExpertiseData() {
		return expertiseData;
	}

	public void setExpertiseData(List<ExpertiseVO> expertiseData) {
		this.expertiseData = expertiseData;
	}

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

	public List<RoleVO> getRole() {
		return role;
	}

	public void setRole(List<RoleVO> role) {
		this.role = role;
	}

	public List<GroupVO> getGroup() {
		return group;
	}

	public void setGroup(List<GroupVO> group) {
		this.group = group;
	}

	public List<Integer> getRoleId() {
		return roleId;
	}

	public void setRoleId(List<Integer> roleId) {
		this.roleId = roleId;
	}

	public List<Integer> getGroupId() {
		return groupId;
	}

	public void setGroupId(List<Integer> groupId) {
		this.groupId = groupId;
	}

	public List<JournalListVO> getJournalVO() {
		return journalVO;
	}

	public void setJournalVO(List<JournalListVO> journalVO) {
		this.journalVO = journalVO;
	}

	public List<Integer> getJournalId() {
		return journalId;
	}

	public void setJournalId(List<Integer> journalId) {
		this.journalId = journalId;
	}

}
