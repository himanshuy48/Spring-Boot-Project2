package com.digi.uniprr.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.ManuScriptReviewerCommonVO;
import com.digi.uniprr.VO.ManuscriptManagingEditorChecklistVO;
import com.digi.uniprr.model.ManuscriptManagingEditorChecklist;
import com.digi.uniprr.service.ManuscriptManagingEditorChecklistService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuScriptManagingEditorChecklist")
public class ManuscriptManagingEditorChecklistContoller {

	@Autowired
	private ManuscriptManagingEditorChecklistService manuscriptManagingEditorChecklistService;
	
	JSONObject obj = new JSONObject();
	
	@RequestMapping(value = "/addManuScriptManagingEditorChecklist", method = RequestMethod.POST)
	  public ResponseEntity<?> addManuScriptManagingEditorChecklist(@RequestBody ManuscriptManagingEditorChecklist manuscriptManagingEditorChecklist ) {
		manuscriptManagingEditorChecklistService.addManagingEditorChecklistDeatils(manuscriptManagingEditorChecklist);
	     return new ResponseEntity<>("Added Data Sucessfully", HttpStatus.OK); 
    }
	 
	@RequestMapping(value = "/updateManuScriptManagingEditorChecklist", method = RequestMethod.POST)
	  public ResponseEntity<?> updateManuScriptManagingEditorChecklist(@RequestBody ManuscriptManagingEditorChecklistVO manuscriptManagingEditorChecklistVO) {
	  try {
		  if(manuscriptManagingEditorChecklistService.isExist(manuscriptManagingEditorChecklistVO.getManuscriptId(),manuscriptManagingEditorChecklistVO.getManagingeditorId(),manuscriptManagingEditorChecklistVO.getManuscriptVersion()))
			  manuscriptManagingEditorChecklistService.updateManagingEditorChecklistDeatils(manuscriptManagingEditorChecklistVO);
			  obj.put("updated", "Updated Data Sucessfully.");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);  
       }
       catch(Exception e) {
   	     obj.put("updated", "Does not exist Table.");
   	    return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
       }
    }
	
	@PostMapping("addMultipleArrayRecord")
	public ResponseEntity<?> addMultipleArrayRecord(@RequestBody ManuscriptManagingEditorChecklistVO manuscriptManagingEditorChecklistVO) {
		try {
			manuscriptManagingEditorChecklistService.addAllDetailsMultipleTable(manuscriptManagingEditorChecklistVO);
			obj.put("data", "Data inserted...");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

	}
	 
}
