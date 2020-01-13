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

import com.digi.uniprr.VO.ManuScriptReviewerVO;
import com.digi.uniprr.VO.ManuscriptReviewerCommentsVO;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptReviewerComments;
import com.digi.uniprr.service.ManuscriptReviewerCommentsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuScriptReviewerComments")
public class ManuscriptReviewerCommentsController {
	
	 @Autowired
	 private ManuscriptReviewerCommentsService manuscriptReviewerCommentsService;
	
	 
	 
	 @RequestMapping(value = "/addManuScriptReviewerComments", method = RequestMethod.POST)
	  public ResponseEntity<?> addManuScriptReviewerComments(@RequestBody ManuscriptReviewerComments manuScriptReviewerComments) {
		 manuscriptReviewerCommentsService.addReviewerCommentsDeatils(manuScriptReviewerComments);
	     return new ResponseEntity<>("Added Data Sucessfully", HttpStatus.OK); 
     }
	 
	 @RequestMapping(value = "/updateManuScriptReviewerComments", method = RequestMethod.POST)
	  public ResponseEntity<?> updateManuScriptReviewerComments(@RequestBody ManuscriptReviewerCommentsVO manuscriptReviewerCommentsVO) {
		 JSONObject obj = new JSONObject(); 
		 try {
		  if(manuscriptReviewerCommentsService.isExist(manuscriptReviewerCommentsVO.getManuscriptId(), manuscriptReviewerCommentsVO.getReviewerId(),manuscriptReviewerCommentsVO.getManuscriptVersion()))
			  manuscriptReviewerCommentsService.updateReviewerDeatils(manuscriptReviewerCommentsVO);
			  obj.put("updated", "Updated Data Sucessfully.");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);  
          }
        catch(Exception e) {
        	obj.put("updated", "Does not exist Table.");
        	return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
        }
		
     }

}
