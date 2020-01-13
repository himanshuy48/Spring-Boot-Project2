package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.ManuscriptManagingEditorComments;
import com.digi.uniprr.service.ManuscriptManagingEditorCommentsService;

@RestController
@RequestMapping("/manuscriptManagingEditorComments")
public class ManuscriptManagingEditorCommentsRestController {
	
	@Autowired
	ManuscriptManagingEditorCommentsService manuscriptManagingEditorCommentsService;
	
	JSONObject obj = new JSONObject();
	
	@PostMapping("create")
	public ResponseEntity<?> createManuscriptManagingEditorComments(@RequestBody ManuscriptManagingEditorComments manuscriptManagingEditorComments){
		manuscriptManagingEditorCommentsService.createManuscriptManagingEditorComments(manuscriptManagingEditorComments);
	    obj.put("data", "Created Successfully");
	    return new ResponseEntity<>(obj , HttpStatus.OK);
	}

	@GetMapping("list")
	public ResponseEntity<?> listManuscriptManagingEditorComments(){
		List<ManuscriptManagingEditorComments> list = manuscriptManagingEditorCommentsService.getManuscriptManagingEditorComments();
		obj.put("data", list);
		return new ResponseEntity<>(obj , HttpStatus.OK);
	} 
	
	@PostMapping("listById")
	public ResponseEntity<?> listManuscriptManagingEditorCommentsById(@RequestBody ManuscriptManagingEditorComments manuscriptManagingEditorComments){
		List<ManuscriptManagingEditorComments> listById = manuscriptManagingEditorCommentsService.getManuscriptManagingEditorCommentsById(manuscriptManagingEditorComments.getId());
		obj.put("data", listById);
		return new ResponseEntity<>(obj , HttpStatus.OK);
	}
	
	@PostMapping("update")
	public ResponseEntity<?> updateManuscriptManagingEditorComments(@RequestBody ManuscriptManagingEditorComments manuscriptManagingEditorComments){
		if(manuscriptManagingEditorCommentsService.isExistById(manuscriptManagingEditorComments.getId())) {
		manuscriptManagingEditorCommentsService.updateManuscriptManagingEditorComments(manuscriptManagingEditorComments);
		obj.put("data", "Updated Successfully");
		return new ResponseEntity<>(obj , HttpStatus.OK);
		}
		
		obj.put("data", "Does not Exist");
		return new ResponseEntity<>(obj , HttpStatus.CONFLICT);
		
	}
}
