package com.digi.uniprr.VO;

import java.util.List;

import com.digi.uniprr.enums.Salutation;

public class UserJournalVO {
	
	private Integer roleId;
	
	private Integer journalId;
	
	private String username;
	
	private Integer userId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Salutation salutation;
	
	private List<Integer> journalID;
	
	private List<Integer>  roleID;
	

	public List<Integer> getJournalID() {
		return journalID;
	}

	public void setJournalID(List<Integer> journalID) {
		this.journalID = journalID;
	}

	public List<Integer> getRoleID() {
		return roleID;
	}

	public void setRoleID(List<Integer> roleID) {
		this.roleID = roleID;
	}


	
	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserJournalVO [roleId=" + roleId + ", journalId=" + journalId + ", username=" + username + ", userId="
				+ userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", salutation=" + salutation + ", journalID=" + journalID + ", roleID=" + roleID + "]";
	}

	


}
