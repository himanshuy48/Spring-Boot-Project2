package com.digi.uniprr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.CheckListMasterVO;
import com.digi.uniprr.service.CheckListMasterService;

@RestController
public class CheckListMasterRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CheckListMasterService checkListMasterService;
	
	@PostMapping("addCheckListMaster")
	 public ResponseEntity<?> addCheckListMaster(@RequestBody CheckListMasterVO checkListMasterVO){
		log.info("Inside addCheckListMaster");
		return new ResponseEntity<>(checkListMasterService.saveCheckListMaster(checkListMasterVO), HttpStatus.OK);
	}
	
	
	
	
	
}
