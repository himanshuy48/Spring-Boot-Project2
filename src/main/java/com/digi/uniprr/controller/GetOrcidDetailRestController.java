package com.digi.uniprr.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.service.OrcidService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/orcid")
public class GetOrcidDetailRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrcidService orcidService;
	
	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/orcidDetail", method = RequestMethod.POST)
	public ResponseEntity<?> getOrcidDetail(@RequestParam String id) {
		log.info("Inside GetOrcidDetailRestController getOrcidDetail");
		String data = orcidService.getOrcidDetail(id);
		System.out.println(data);
		if(!data.equalsIgnoreCase("Something went wrong") ) {
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
		obj.put("data", "Something went wrong");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
		
		
}
