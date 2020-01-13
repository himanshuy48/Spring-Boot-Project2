package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.Role;

public interface RoleService 
{
    public String CreateRoleDetails(Role role);
    
    public List<Role> getRoleDetails();
    
    public String updateRoleDetails(Role role);
    
    public boolean isRoleExist(Integer id);

	public List<Role> getRoleById(Role role);
}
