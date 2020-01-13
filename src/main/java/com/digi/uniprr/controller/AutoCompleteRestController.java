package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.JournalListVO;
import com.digi.uniprr.VO.ManuScriptByJournalVo;
import com.digi.uniprr.service.AutoCompleteService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/autoComplete")
public class AutoCompleteRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AutoCompleteService autoCompleteService;

	JSONObject obj = new JSONObject();

	@PostMapping("getJournalList")
	private ResponseEntity<?> getJournalList(@RequestBody IDVO name) {
		log.info("Inside In autoComplete getJournalList");
		List<JournalListVO> data = autoCompleteService.getJournalList(name);
		if (data != null && !data.isEmpty()) {
			obj.put("data", data);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "data not found");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("getExpertise")
	private ResponseEntity<?> getExpertise(@RequestBody IDVO name) {
		log.info("Inside In autoComplete getExpertise");
		List<IDVO> data = autoCompleteService.getExpertiseList(name);
		if (data != null && !data.isEmpty()) {
			obj.put("data", data);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "data not found");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("getSpecialization")
	private ResponseEntity<?> getSpecialization(@RequestBody IDVO name) {
		log.info("Inside In autoComplete getSpecialization");
		List<IDVO> data = autoCompleteService.getSpecialization(name);

		if (data != null && !data.isEmpty()) {
			obj.put("data", data);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "data not found");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@GetMapping("getInstitution")
	private ResponseEntity<?> getInstitution() {
		log.info("Inside In autoComplete getInstitution");
		try {
			List<IDVO> list = autoCompleteService.getInstitution();
			if (list != null && !list.isEmpty()) {
				obj.put("data", list);
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			obj.put("message", "Data Not Found");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("message", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
	}

}
