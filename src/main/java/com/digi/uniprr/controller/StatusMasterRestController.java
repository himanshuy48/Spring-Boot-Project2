package com.digi.uniprr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.StatusMaster;
import com.digi.uniprr.service.StatusMasterService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/statusMaster")
public class StatusMasterRestController {
	@Autowired
	StatusMasterService statusMasterService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<StatusMaster> getStatusMasterDetails() {
		List<StatusMaster> statusList = statusMasterService.getStatusMasterDetails();
		return statusList;
	}
}