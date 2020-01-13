package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.TaskMaster;
import com.digi.uniprr.repository.TaskMasterRepo;
import com.digi.uniprr.service.TaskMasterService;


@Service
@Transactional
public class TaskMasterServiceImpl implements TaskMasterService { 

	@Autowired
	private TaskMasterRepo taskMasterRepo;
	
	@Override
	public List<TaskMaster> getDetails() {
		return taskMasterRepo.findAll();
	}
    
}
