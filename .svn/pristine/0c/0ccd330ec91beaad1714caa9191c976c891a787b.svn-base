package com.digi.uniprr.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.model.MeAvailability;
import com.digi.uniprr.service.ManagingEditorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/managingEditor")
public class ManagingEditorRestController {
	
	@Autowired
	ManagingEditorService managingEditorService;

	@PostMapping("saveManagingEditorAvailability")
	public ResponseEntity<?> saveEditorAvailability(@RequestBody MeAvailability meAvailability) {
		JSONObject obj = new JSONObject();
		try {
			managingEditorService.saveManagingEditorAvailability(meAvailability);
			obj.put("data", "Created successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/getManagingEditorWithAvailability", method = RequestMethod.GET)
	public List<ReviewerVO> getEditorWithAvailability() {
		List<ReviewerVO> managingEditorList = managingEditorService.getManagingEditorWithAvailability();
		return managingEditorList;
	}
	
	@PostMapping("getManagingEditorAvailability")
	public ResponseEntity<?> getEditorAvailability(@RequestBody IDVO id) {
		JSONObject obj = new JSONObject();
		List<MeAvailability> managingEditorAvailabilityList = new ArrayList<>();
		try {
			managingEditorAvailabilityList = managingEditorService.getManagingEditorAvailabilityById(id.getId());
			obj.put("data", managingEditorAvailabilityList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("deleteManagingEditorAvailability")
	public ResponseEntity<?> deleteEditorAvailability(@RequestBody IDVO id) {
		JSONObject obj = new JSONObject();
		try {
			managingEditorService.deleteManagingEditorAvailabilityById(id.getId());
			obj.put("data", "Data deleted successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
}
