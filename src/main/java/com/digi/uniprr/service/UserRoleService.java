package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.User;
import com.digi.uniprr.model.UserRole;

public interface UserRoleService {

	public void create(UserRole userRole);

	public List<User> getlistById(Integer id);
}
