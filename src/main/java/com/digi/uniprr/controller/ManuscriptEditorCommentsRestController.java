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

import com.digi.uniprr.VO.ManuscriptEditorVO;
import com.digi.uniprr.model.ManuscriptEditorComments;
import com.digi.uniprr.service.ManuscriptEditorCommentsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuscriptEditorComments")
public class ManuscriptEditorCommentsRestController {

	@Autowired
	ManuscriptEditorCommentsService manuscriptEditorCommentsService;
	
	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createManuscriptEditorComments(@RequestBody ManuscriptEditorComments ManuscriptEditorComments) {
		try {
			manuscriptEditorCommentsService.createManuscriptEditorComments(ManuscriptEditorComments);
			obj.put("data", "data inserted...");
		}catch(Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong...");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("updateManuScriptEditor")
	public ResponseEntity<?> updateManuScriptEditor(@RequestBody ManuscriptEditorVO manuscriptEditorVO){
		return manuscriptEditorCommentsService.updateManuScriptEditor(manuscriptEditorVO);
	}
	
}
