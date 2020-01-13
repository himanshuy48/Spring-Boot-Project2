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

import com.digi.uniprr.VO.ManuscriptReviewerChecklistVO;
import com.digi.uniprr.model.ManuScriptReviewerChecklist;
import com.digi.uniprr.service.ManuscriptReviewerChecklistService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuScriptReviewerChecklist")
public class ManuscriptReviewerChecklistController {

	@Autowired
	private ManuscriptReviewerChecklistService manuscriptReviewerChecklistService;
	
	 @RequestMapping(value = "/addManuScriptReviewerChecklist", method = RequestMethod.POST)
	  public ResponseEntity<?> addManuScriptReviewerChecklist(@RequestBody ManuScriptReviewerChecklist manuScriptReviewerChecklist) {
		 manuscriptReviewerChecklistService.addReviewerChecklistDeatils(manuScriptReviewerChecklist);
	     return new ResponseEntity<>("Added Data Sucessfully", HttpStatus.OK); 
     }
	 
	 @RequestMapping(value = "/updateManuScriptReviewerChecklist", method = RequestMethod.POST)
	  public ResponseEntity<?> updateManuScriptReviewerChecklist(@RequestBody ManuscriptReviewerChecklistVO manuscriptReviewerChecklistVO) {
		 JSONObject obj = new JSONObject(); 
		 try {
		  if(manuscriptReviewerChecklistService.isExist(manuscriptReviewerChecklistVO.getManuscriptId(),manuscriptReviewerChecklistVO.getReviewerId()))
			  manuscriptReviewerChecklistService.updateReviewerChecklistDeatils(manuscriptReviewerChecklistVO);
			  obj.put("updated", "Updated Data Sucessfully.");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);  
         }
         catch(Exception e) {
       	    obj.put("updated", "Does not exist Table.");
         	return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
         }
		
      }
}
