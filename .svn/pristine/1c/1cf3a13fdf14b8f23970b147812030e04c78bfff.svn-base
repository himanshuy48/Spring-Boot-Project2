package com.digi.uniprr.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.digi.uniprr.model.Groups;
import com.digi.uniprr.model.Role;

@Entity
@Table(name="group_role")
public class GroupRoleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="group_id")
	private Integer groupId;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "group_id", insertable = false, updatable = false)
	private Groups group;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}
	
}
