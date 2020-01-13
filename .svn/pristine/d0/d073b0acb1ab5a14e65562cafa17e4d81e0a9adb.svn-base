package com.digi.uniprr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.JournalMailTemplates;
import com.digi.uniprr.model.TaskEmailMap;
import com.digi.uniprr.service.JournalMailTemplatesService;
import com.digi.uniprr.service.TaskEmailMapService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController       
@RequestMapping("/journalMailTemplate")
public class JournalMailTemplatesRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JournalMailTemplatesService journalMailTemplatesService;

	@Autowired
	TaskEmailMapService taskEmailMapService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createJournalTemplates(@RequestBody JournalMailTemplates journalMailTemplates) {
		log.info("Inside in journalMailTemplate createJournalTemplates");
		journalMailTemplatesService.createJournalTemplates(journalMailTemplates);
		return new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public List<JournalMailTemplates> getJournalMailTemplatesDetails() {
		log.info("Inside in journalMailTemplate getJournalMailTemplatesDetails");
		List<JournalMailTemplates> journalMailList = journalMailTemplatesService.getJournalMailTemplatesDetails();
		return journalMailList;
	}

	@RequestMapping(value = "/getListById", method = RequestMethod.POST)
	public List<JournalMailTemplates> getJournalMailTemplatesDetailsById(@RequestParam Integer id) {
		log.info("Inside in journalMailTemplate getJournalMailTemplatesDetailsById");
		List<JournalMailTemplates> journalMailListById = journalMailTemplatesService
				.getJournalMailTemplatesDetailsById(id);
		return journalMailListById;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateJournalMailTemplates(@RequestBody JournalMailTemplates journalMailTemplates) {
		log.info("Inside in journalMailTemplate updateJournalMailTemplates");
		journalMailTemplatesService.updateJournalMailTemplates(journalMailTemplates);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deleteJournalMailTemplatesById(@RequestParam Integer id) {
		log.info("Inside in journalMailTemplate deleteJournalMailTemplatesById");
		journalMailTemplatesService.deleteJournalMailTemplatesById(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/customise", method = RequestMethod.POST)
	public List<TaskEmailMap> customiseMailTemplate(@RequestBody TaskEmailMap taskEmailMap) {
		log.info("Inside in journalMailTemplate customiseMailTemplate");
		List<TaskEmailMap> journalMailTemplatesList = taskEmailMapService.customiseMailTemplate(taskEmailMap.getTaskId());
		return journalMailTemplatesList;
	}
}
