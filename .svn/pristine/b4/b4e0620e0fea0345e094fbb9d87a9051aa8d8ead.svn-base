package com.digi.uniprr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.bean.GroupRoleBean;
import com.digi.uniprr.repository.GroupRoleRepo;
import com.digi.uniprr.service.GroupRoleService;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {

	@Autowired 
	GroupRoleRepo groupRoleRepo;
	
	@Override
	public List<GroupRoleBean> getGroupByRoleId(Integer roleId) {
		return groupRoleRepo.getGroupByRoleId(roleId);
	}

	@Override
	public Integer getRoleIdByGroupId(Integer groupId) {
		return groupRoleRepo.getRoleIdByGroupId(groupId);
	}

}
