package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.model.ManuscriptType;
import com.digi.uniprr.service.ManuscriptTypeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuscriptType")
public class ManuscriptTypeRestController {

	@Autowired
	ManuscriptTypeService manuscriptTypeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> listManuscriptType() {
		List<ManuscriptType> list = manuscriptTypeService.getManuscriptTypeList();
		return new ResponseEntity<> (list, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createManuscriptType(@RequestBody ManuscriptType manuscriptType) {
		JSONObject obj = new JSONObject();
		try {
			manuscriptTypeService.saveManuscriptType(manuscriptType);
			obj.put("message", "Data Created Successfully");
		}
		catch (Exception e) {
			obj.put("message", "Some Error Occured");
		}
		
		return new ResponseEntity<> (obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateManuscriptType(@RequestBody ManuscriptType manuscriptType) {
		JSONObject obj = new JSONObject();
		try {
			manuscriptTypeService.saveManuscriptType(manuscriptType);
			obj.put("message", "Data Created Successfully");
		}
		catch (Exception e) {
			obj.put("message", "Some Error Occured");
		}
		
		return new ResponseEntity<> (obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deleteManuscriptType(@RequestBody IDVO vo) {
		JSONObject obj = new JSONObject();
		try {
			manuscriptTypeService.deleteManuscriptType(vo.getId());
			obj.put("message", "Data Created Successfully");
		}
		catch (Exception e) {
			obj.put("message", "Some Error Occured");
		}
		
		return new ResponseEntity<> (obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<?> getManuscriptTypeDetails(@RequestBody IDVO vo) {
		ManuscriptType type = manuscriptTypeService.getManuscriptTypeById(vo.getId());
		return new ResponseEntity<> (type, HttpStatus.OK);
	}

}
