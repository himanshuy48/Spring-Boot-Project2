package com.digi.uniprr.controller;

import java.util.List;

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

import com.digi.uniprr.VO.ExpertiseVO;
import com.digi.uniprr.model.Expertise;
import com.digi.uniprr.service.ExpertiseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/expertise")
public class ExpertiseController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ExpertiseService expertiseService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> expertiseList() {
		log.info("Inside ExpertiseController expertiseList");
		JSONObject obj = new JSONObject();
		List<ExpertiseVO> expertiseList = expertiseService.getList();
		obj.put("data", expertiseList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

}
