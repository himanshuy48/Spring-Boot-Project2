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

import com.digi.uniprr.model.ManuscriptTypeDetails;
import com.digi.uniprr.service.ManuscriptTypeDetailsService;

@RestController
@RequestMapping("/manuscriptTypeDetails")
public class ManuscriptTypeDetailsRestController {

	@Autowired
	ManuscriptTypeDetailsService manuscriptTypeDetailsService;

	JSONObject obj = new JSONObject();

	@PostMapping("create")
	public ResponseEntity<?> createManuscriptTypeDetails(@RequestBody ManuscriptTypeDetails manuscriptTypeDetails) {
		manuscriptTypeDetailsService.createManuscriptTypeDetails(manuscriptTypeDetails);
		obj.put("data", "Created Successfully");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@GetMapping("list")
	public ResponseEntity<?> getManuscriptTypeDetails() {
		List<ManuscriptTypeDetails> manuList = manuscriptTypeDetailsService.getManuscriptTypeDetails();
		obj.put("data", manuList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("listById")
	public ResponseEntity<?> getManuscriptTypeDetailsById(@RequestBody ManuscriptTypeDetails manuscriptTypeDetails) {
		List<ManuscriptTypeDetails> listById = manuscriptTypeDetailsService
				.getManuscriptTypeDetailsById(manuscriptTypeDetails);
		obj.put("data", listById);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

}
