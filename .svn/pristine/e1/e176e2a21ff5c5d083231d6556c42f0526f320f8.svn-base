package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.Role;
import com.digi.uniprr.repository.RoleRepo;
import com.digi.uniprr.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService 
{

	@Autowired
	RoleRepo roleRepo;

	@Override
	public List<Role> getRoleDetails() 
	{
		
		return roleRepo.findAll();
	}

	@Override
	public String CreateRoleDetails(Role role) 
	{
		roleRepo.save(role);
		return "Role created";
	}

	@Override
	public String updateRoleDetails(Role role) 
	{
		roleRepo.save(role);
		return "Updated Successfully";
	}

	@Override
	public boolean isRoleExist(Integer id) 
	{
		return roleRepo.existsById(id);
	}

	@Override
	public List<Role> getRoleById(Role role) 
	{
		return roleRepo.getRoleById(role.getRoleId());
	}

}
