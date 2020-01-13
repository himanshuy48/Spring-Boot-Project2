package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.RuleMaster;
import com.digi.uniprr.repository.RuleMasterRepo;
import com.digi.uniprr.service.RuleMasterService;

@Service
@Transactional
public class RuleMasterServiceImpl implements RuleMasterService {

	@Autowired
	RuleMasterRepo ruleMasterRepo;
	
	@Override
	public List<RuleMaster> getRuleMasterDetails() {
		return ruleMasterRepo.findAll();		
	}

}
