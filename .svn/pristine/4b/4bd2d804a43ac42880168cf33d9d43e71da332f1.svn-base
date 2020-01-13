package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.bean.GroupRoleBean;

public interface GroupRoleRepo extends JpaRepository<GroupRoleBean, Integer> 
{
	@Query("select r from GroupRoleBean r where r.roleId=:roleId")
	public List<GroupRoleBean> getGroupByRoleId(Integer roleId);

	@Query(value= "select role_id from group_role g where g.group_id=:groupId", nativeQuery=true)
	public Integer getRoleIdByGroupId(Integer groupId);
}
