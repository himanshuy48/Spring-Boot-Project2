package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.digi.uniprr.model.User;
import com.digi.uniprr.model.UserRole;
import com.digi.uniprr.service.UserRoleService;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Override
	public void create(UserRole userRole) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getlistById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
