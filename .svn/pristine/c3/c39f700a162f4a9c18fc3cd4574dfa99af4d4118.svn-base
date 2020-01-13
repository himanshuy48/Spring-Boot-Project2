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

import com.digi.uniprr.model.FeedbackQuestionMaster;
import com.digi.uniprr.service.FeedbackQuestionMasterService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/feedbackQuestionMaster")
public class FeedbackQuestionMasterRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedbackQuestionMasterService feedbackQuestionMasterService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getFeedbackList() {
		log.info("Inside FeedbackQuestionMasterRestController getFeedbackList");
		List<FeedbackQuestionMaster> feedbackList = feedbackQuestionMasterService.getFeedbackList();
		if (feedbackList != null && !feedbackList.isEmpty()) {
			obj.put("data", feedbackList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Data Not found");
		return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/listById", method = RequestMethod.POST)
	public ResponseEntity<?> getFeedbackListById(@RequestParam Integer id) {
		log.info("Inside FeedbackQuestionMasterRestController getFeedbackListById");
		List<FeedbackQuestionMaster> feedbackList = feedbackQuestionMasterService.getFeedbackListById(id);
		if (feedbackList != null && !feedbackList.isEmpty()) {
			obj.put("data", feedbackList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "No Data found regarding this id: " + id);
		return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
	}
}
