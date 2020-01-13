package com.digi.uniprr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digi.uniprr.model.ContributorRoles;
import com.digi.uniprr.repository.ContributorRolesRepo;
import com.digi.uniprr.service.ContributorRolesService;

@Service
@Transactional
public class ContributorRolesServiceImpl implements ContributorRolesService {

	@Autowired
	ContributorRolesRepo contributorRolesRepo;
	
	@Override
	public List<ContributorRoles> getAllContributorRoles() {
		return contributorRolesRepo.findAll();
	}

}
