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

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.SubjectVO;
import com.digi.uniprr.model.Subject;
import com.digi.uniprr.service.SubjectService;

@RestController
@RequestMapping("subject")
public class SubjectRestController {

	@Autowired
	SubjectService subjectService;
	
	JSONObject obj = new JSONObject();
	
	@PostMapping("createSubject")
	public ResponseEntity<?> createSubject(@RequestBody SubjectVO SubjectVO){
		try {
			subjectService.createSubject(SubjectVO);
			obj.put("data", "Created...");
		}catch(Exception e) {
			System.out.println(e);
			obj.put("data", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@GetMapping("getSubjectList")
	public ResponseEntity<?> getSubjectList() {

		List<Subject> subject = subjectService.getSubjectList();
		if(subject!=null && !subject.isEmpty()) {
			obj.put("data", subject);
		}else {
			obj.put("data", "Data Not Found");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("deleteSubject")
	public ResponseEntity<?> deleteSubject(@RequestBody IDVO id){
		try {
			subjectService.deleteSubject(id);
			obj.put("data", "Deleted...");
		}catch(Exception e) {
			System.out.println(e);
			obj.put("data", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("updateSubject")
	public ResponseEntity<?> updateSubject(@RequestBody Subject Subject){
		try {
			subjectService.updateSubject(Subject);
			obj.put("data", "Upadted...");
		}catch(Exception e) {
			System.out.println(e);
			obj.put("data", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
}
