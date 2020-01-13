package com.digi.uniprr.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.CheckListMasterSimpleVO;
import com.digi.uniprr.VO.CheckListMasterVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.model.CheckListMaster;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.service.CheckListMasterService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/checkListMaster")
public class CheckListMasterController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CheckListMasterService checkListMasterService;
	
	@RequestMapping(value = "/addSimpleCheckListMaster", method = RequestMethod.POST)
	  public ResponseEntity<?> addSimpleCheckListMaster(@RequestBody CheckListMaster checkListMaster) {
		log.info("Inside In checkListMaster addSimpleCheckListMaster");
		JSONObject obj = new JSONObject();
		try{
		   checkListMasterService.addChecklistDeatils(checkListMaster);
		   obj.put("Added", "Added Data Sucessfully.");
		   return new ResponseEntity<Object>(obj, HttpStatus.OK); 
		}
		catch(Exception e)
		{
			System.out.println(e);
			obj.put("Addeded", "Does not exist table");
        	return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
		}
   }
	
	@PostMapping("addCheckListMaster")
	 public ResponseEntity<?> addCheckListMaster(@RequestBody CheckListMasterVO checkListMasterVO){
		log.info("Inside In checkListMaster addCheckListMaster");
		return new ResponseEntity<>(checkListMasterService.saveCheckListMaster(checkListMasterVO), HttpStatus.OK);
	}

 
	@RequestMapping(value = "/listdetails", method = RequestMethod.GET)
	public ResponseEntity<?> checkMasterList() {
		log.info("Inside In checkListMaster checkMasterList");
		JSONObject obj = new JSONObject();
		List<CheckListMasterSimpleVO> checkvoList = checkListMasterService.getCheckListByRole();
		obj.put("data", checkvoList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("listCheckByRole")
	public ResponseEntity<?> getCheckByRole(@RequestParam Integer journalId, @RequestParam String chkCategory) {
		log.info("Inside In checkListMaster getCheckByRole");
		JSONObject obj = new JSONObject();
		List<CheckListMaster> checkList  = new ArrayList<>();
		try {
			if(checkListMasterService.isExist(journalId, chkCategory)) 
			  checkList = checkListMasterService.getCheckList(journalId, chkCategory);
			  obj.put("data", checkList);
			  return new ResponseEntity<>(obj, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("listCheckByRoleAll")
	public ResponseEntity<?> getCheckByRoleAll(@RequestParam Integer journalId, @RequestParam String chkCategory) {
		log.info("Inside In checkListMaster getCheckByRoleAll");
		JSONObject obj = new JSONObject();
		List<CheckListMaster> checkList  = new ArrayList<>();
		try {
			if(checkListMasterService.isExist(journalId, chkCategory)) 
			  checkList = checkListMasterService.getCheckListAll(journalId, chkCategory);
			  obj.put("data", checkList);
			  return new ResponseEntity<>(obj, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/deletechecklist", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteManuScript(@RequestBody CheckListMaster checkListMaster) {
		log.info("Inside In checkListMaster deleteManuScript");
		if (checkListMasterService.isExist(checkListMaster.getChkid())) {
			checkListMasterService.deletechecklistById(checkListMaster.getChkid());
			return new ResponseEntity<Object>("Checklist Item deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Id does not exist", HttpStatus.FORBIDDEN);
	}

}
