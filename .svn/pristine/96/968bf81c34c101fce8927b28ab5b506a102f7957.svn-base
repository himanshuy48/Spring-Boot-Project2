package com.digi.uniprr.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.model.EditorAvailability;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.service.EditorService;

@RestController
public class EditorRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	JSONObject obj = new JSONObject();
	
	@Autowired
	EditorService editorService;
	
	@PostMapping("getManuScriptDataByStatus")
	public ResponseEntity<?> getManuScriptDataByStatus(@RequestBody ManuscriptListVO  manuscriptListVO){
		log.info("Inside EditorRestController getManuScriptDataByStatus");
		return new ResponseEntity<>(editorService.getManuScriptDataByStatus(manuscriptListVO), HttpStatus.OK);
	}
	
	@PostMapping("updateManuScriptByAuthor")
	public ResponseEntity<?> updateManuScriptByAuthor(@RequestBody ManuscriptListVO  manuscriptListVO){
		log.info("Inside EditorRestController updateManuScriptByAuthor");
		try {
			editorService.updateManuScriptByAuthor(manuscriptListVO);
			obj.put("message", "updated ManuScript Status");
		}catch(Exception e) {
			obj.put("message", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	
	//Editor Availability
	
	@PostMapping("saveEditorAvailability")
	public ResponseEntity<?> saveEditorAvailability(@RequestBody EditorAvailability editorAvailability) {
		log.info("Inside EditorRestController saveEditorAvailability");
		JSONObject obj = new JSONObject();
		try {
			editorService.saveEditorAvailability(editorAvailability);
			obj.put("data", "Created successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/getEditorWithAvailability", method = RequestMethod.GET)
	public List<ReviewerVO> getEditorWithAvailability() {
		log.info("Inside EditorRestController getEditorWithAvailability");
		List<ReviewerVO> editorList = editorService.getEditorWithAvailability();
		return editorList;
	}
	
	@PostMapping("getEditorAvailability")
	public ResponseEntity<?> getEditorAvailability(@RequestBody IDVO id) {
		log.info("Inside EditorRestController getEditorAvailability");
		JSONObject obj = new JSONObject();
		List<EditorAvailability> editorAvailabilityList = new ArrayList<>();
		try {
			editorAvailabilityList = editorService.getEditorAvailabilityById(id.getId());
			obj.put("data", editorAvailabilityList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("deleteEditorAvailability")
	public ResponseEntity<?> deleteEditorAvailability(@RequestBody IDVO id) {
		log.info("Inside EditorRestController deleteEditorAvailability");
		JSONObject obj = new JSONObject();
		try {
			editorService.deleteEditorAvailabilityById(id.getId());
			obj.put("data", "Data deleted successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
}
