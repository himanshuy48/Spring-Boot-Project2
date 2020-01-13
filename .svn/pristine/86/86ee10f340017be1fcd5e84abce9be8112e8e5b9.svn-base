package com.digi.uniprr.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.ManuscriptEditorChecklistVO;
import com.digi.uniprr.model.ManuscriptEditorChecklist;
import com.digi.uniprr.service.ManuscriptEditorChecklistService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuScriptEditorChecklist")
public class ManuscriptEditorChecklistController {

	@Autowired
	private ManuscriptEditorChecklistService manuscriptEditorChecklistService;
	
	@RequestMapping(value = "/addManuScriptEditorChecklist", method = RequestMethod.POST)
	  public ResponseEntity<?> addManuScriptEditorChecklist(@RequestBody ManuscriptEditorChecklist  manuscriptEditorChecklist ) {
		manuscriptEditorChecklistService.addEditorChecklistDeatils(manuscriptEditorChecklist);
	     return new ResponseEntity<>("Added Data Sucessfully", HttpStatus.OK); 
    }
	 
	 @RequestMapping(value = "/updateManuScriptEditorChecklist", method = RequestMethod.POST)
	  public ResponseEntity<?> updateManuScriptEditorChecklist(@RequestBody ManuscriptEditorChecklistVO manuscriptEditorChecklistVO) {
	  JSONObject obj = new JSONObject(); 
	  try {
		  if(manuscriptEditorChecklistService.isExist(manuscriptEditorChecklistVO.getManuscriptId(),manuscriptEditorChecklistVO.getEditorId()))
			  manuscriptEditorChecklistService.updateEditorChecklistDeatils(manuscriptEditorChecklistVO);
			  obj.put("updated", "Updated Data Sucessfully.");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);  
      }
      catch(Exception e) {
     	obj.put("updated", "Does not exist Table.");
     	return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
      }
  }
}
