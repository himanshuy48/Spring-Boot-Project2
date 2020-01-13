package com.digi.uniprr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digi.uniprr.bean.GroupRoleBean;
import com.digi.uniprr.model.Groups;
import com.digi.uniprr.repository.GroupRepo;
import com.digi.uniprr.repository.GroupRoleRepo;
import com.digi.uniprr.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepo groupRepo;
	
	@Autowired
	private GroupRoleRepo groupRoleRepo;

	@Override
	public String createGroup(Groups group) {
		groupRepo.save(group);
		return "Group Created Successfully. ";
	}

	@Override
	public List<Groups> getGroupDetail() {
		return groupRepo.findAll();
	}

	@Override
	public boolean isGroupExist(Groups group) {
		return getGroupName(group.getGroupName()) != null;
	}

	@Override
	public Groups getGroupName(String group) {
		return groupRepo.findByGroupName(group);
	}

	@Override
	public void saveGroup(Groups group) {
		groupRepo.save(group);
	}

	@Override
	public String updateGroup(Groups group) {
		groupRepo.save(group);
		return "Group Update  Successfully. ";
	}

	@Override
	public String deleteGroupById(Integer id) {

		groupRepo.deleteGroupRoleById(id);

		return "Group deleted Successfully. ";
	}

	@Override
	public boolean getGroupsById(Integer id) {
		boolean a = groupRepo.existsById(id);

		return a;
	}

	@Override
	public List<Groups> getgroupsById(Integer id) {
		return groupRepo.getgroupsById(id);

	}

	/*
	 * @Override public Groups getByRoleIdForGroup(Integer id) { return
	 * groupRepo.getByRoleIdForGroup(id);
	 * 
	 * }
	 * 
	 * @Override public List<Groups> getGroupDetailsByRoleId(Integer roleid) {
	 * return groupRepo.getGroupDetailsByRoleId(roleid); }
	 */
	@Override
	public boolean isExist(Integer id) {
		
		return groupRepo.existsById(id);
	}

	@Override
	public List<Groups> getJournalDetailsById(Integer id) {
		
		return groupRepo.getGroupById(id);
	}

	@Override
	public String deleteMappedGroupById(GroupRoleBean groupRoleBean) {
		 groupRoleRepo.delete(groupRoleBean);
		 
		 return "Record deleted";
	}

	@Override
	public Groups getById(Integer id) {
		return groupRepo.getOne(id);
	}

	@Override
	public Groups getByRoleIdForGroup(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> getGroupDetailsByRoleId(Integer roleid) {
		// TODO Auto-generated method stub
		return null;
	}

}
