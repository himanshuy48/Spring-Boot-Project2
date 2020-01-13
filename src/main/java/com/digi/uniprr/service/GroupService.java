package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.bean.GroupRoleBean;
import com.digi.uniprr.model.Groups;

public interface GroupService 
{

	public String createGroup(Groups group);

	public List<Groups> getGroupDetail();

	public boolean isGroupExist(Groups group);

	public Groups getGroupName(String group);

	public void saveGroup(Groups group);
	
	public String deleteMappedGroupById(GroupRoleBean groupRoleBean);
	
	public String deleteGroupById(Integer id);
	
	public String updateGroup(Groups group);
	
	public Groups getById(Integer id);
	
	public boolean getGroupsById(Integer id);

	public List<Groups> getgroupsById(Integer id);
	
	public Groups getByRoleIdForGroup(Integer id);

	public List<Groups> getGroupDetailsByRoleId(Integer roleid);

	public boolean isExist(Integer id);

	public List<Groups> getJournalDetailsById(Integer id);
}