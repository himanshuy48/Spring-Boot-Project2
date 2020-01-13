package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.JournalChargeDetails;
import com.digi.uniprr.service.JournalChargeDetailsService;

@RestController
@RequestMapping("/journalChargeDetails")
public class JournalChargeDetailsRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JournalChargeDetailsService journalChargeDetailsService;

	JSONObject obj = new JSONObject();

	@PostMapping("create")
	public ResponseEntity<?> createJournalChargeDetails(@RequestBody JournalChargeDetails journalChargeDetails) {
		log.info("Inside JournalChargeDetailsRestController createJournalChargeDetails");
		if(journalChargeDetailsService.isExist(journalChargeDetails.getJournalChargeId())) {
			obj.put("data", "Already Exist");
			return new ResponseEntity<>(obj , HttpStatus.CONFLICT);
		}
		journalChargeDetailsService.createJournalChargeDetails(journalChargeDetails);
		obj.put("data", "Created Successfully");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@GetMapping("list")
	public ResponseEntity<?> listJournalChargeDetails() {
		log.info("Inside JournalChargeDetailsRestController listJournalChargeDetails");
		List<JournalChargeDetails> journalChargeDetailsList = journalChargeDetailsService.getJournalChargeDetailsList();
		obj.put("data", journalChargeDetailsList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("listById")
	public ResponseEntity<?> listJournalChargeDetailsById(@RequestBody JournalChargeDetails journalChargeDetails) {
		log.info("Inside JournalChargeDetailsRestController listJournalChargeDetailsById");
		try {
			JournalChargeDetails chargeDetails = journalChargeDetailsService
					.getJournalChargeDetailsById(journalChargeDetails);
			obj.put("data", chargeDetails);
		}catch(Exception e) {
			System.out.println(e);
			obj.put("data", "something went wrong");
		}
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("update")
	public ResponseEntity<?> updateJournalChargeDetails(@RequestBody JournalChargeDetails journalChargeDetails) {
		log.info("Inside JournalChargeDetailsRestController updateJournalChargeDetails");
		if(journalChargeDetailsService.isExist(journalChargeDetails.getJournalChargeId())) {
		journalChargeDetailsService.updateJournalChargeDetails(journalChargeDetails);
		obj.put("data", "Updated successfully");
		return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Does not exist");
		return new ResponseEntity<>(obj , HttpStatus.CONFLICT);
	}

}
