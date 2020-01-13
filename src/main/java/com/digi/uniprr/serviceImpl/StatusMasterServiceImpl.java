package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.StatusMaster;
import com.digi.uniprr.repository.StatusMasterRepo;
import com.digi.uniprr.service.StatusMasterService;

@Service
@Transactional
public class StatusMasterServiceImpl implements StatusMasterService {

	@Autowired
	StatusMasterRepo statusMasterRepo;
	
	@Override
	public List<StatusMaster> getStatusMasterDetails(){
		return statusMasterRepo.findAll();
	}

	@Override
	public List<StatusMaster> getListByStatusValue(String statusValue) {
		return statusMasterRepo.getListByStatusValue(statusValue);
	}

	@Override
	public List<StatusMaster> getStatusMasterDetailsById(Integer manuscriptStatus) {
		// TODO Auto-generated method stub
		return statusMasterRepo.getStatusMasterDetailsById(manuscriptStatus);
	}

}
