package com.digi.uniprr.VO;

import com.digi.uniprr.enums.Salutation;

public class ManuscriptCoAuthorVO {
	
	private Integer id;
	
	private Integer coAuthorId;
	
	private Salutation salutation;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
	private String address;
	
	private String addressTwo;
	
	private String addressThree;
	
	private String institution;
	
	private String type;
	
	private Integer order;
	
	private Integer manuscriptId;
	
	private Integer correspondingAuthor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCoAuthorId() {
		return coAuthorId;
	}

	public void setCoAuthorId(Integer coAuthorId) {
		this.coAuthorId = coAuthorId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getManuscriptId() {
		return manuscriptId;
	}

	public void setManuscriptId(Integer manuscriptId) {
		this.manuscriptId = manuscriptId;
	}

	public Integer getCorrespondingAuthor() {
		return correspondingAuthor;
	}

	public void setCorrespondingAuthor(Integer correspondingAuthor) {
		this.correspondingAuthor = correspondingAuthor;
	}
}
