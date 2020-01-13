package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.RoleVO;
import com.digi.uniprr.model.Role;

public class RoleTransformationalUtils {

	public static Role mapVOToModel(RoleVO roleVO) {
		Role role = new Role();
		role.setRoleName(roleVO.getRoleName());
		return role;
	}
	
	public static RoleVO mapModelToVO(Role role) {
		RoleVO vo = new RoleVO();
		vo.setRoleId(role.getRoleId());
		vo.setRoleName(role.getRoleName());
		return vo;
	}
	
	public static List<Role> mapVOListTORoleList(List<RoleVO> voList) {
		List<Role> roleList = new ArrayList<Role>();
		for (RoleVO roleVO : voList) 
			roleList.add(mapVOToModel(roleVO));
		
		return roleList;
	}
	
	public static List<RoleVO> mapRoleListToVOList(List<Role> roleList) {
		List<RoleVO> voList = new ArrayList<RoleVO>();
		for (Role role : roleList) 
			voList.add(mapModelToVO(role));
		return voList;
	}
}
