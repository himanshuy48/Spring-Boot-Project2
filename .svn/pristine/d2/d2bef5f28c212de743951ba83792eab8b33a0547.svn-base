package com.digi.uniprr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.TaskMaster;
import com.digi.uniprr.service.TaskMasterService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping(value="/taskMaster")
public class TaskMasterRestController 
{
	@Autowired
	TaskMasterService taskMasterService;
	
    @RequestMapping(value="/list" , method=RequestMethod.GET)
    public List<TaskMaster> getTaskMasterDetails()
    {
    	List<TaskMaster> masterList = taskMasterService.getDetails();
    	return masterList;
    }
}
