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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.model.MailTemplates;
import com.digi.uniprr.service.MailTemplatesService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/mailTemplates")
public class MailTemplatesRestController {
	
	@Autowired
	MailTemplatesService mailTemplateService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createMailTemplate(@RequestBody MailTemplates template) {
		JSONObject obj = new JSONObject();
		try {
			mailTemplateService.saveMailTemplate(template);
			obj.put("message", "Data Saved Successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
			obj.put("message", "Some Error Occurred");
		}
		
		return new ResponseEntity<> (obj, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<MailTemplates> getMailTemplates() {
		List<MailTemplates> mailTemplatesList = mailTemplateService.getMailTemplates();
		return mailTemplatesList;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<?> getMailTemplatesById(@RequestBody IDVO vo) {
		MailTemplates templates = mailTemplateService.getMailTemplatesById(vo.getId());
		return new ResponseEntity<> (templates, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deleteMailTemplate(@RequestBody IDVO vo) {
		JSONObject obj = new JSONObject();
		try {
			mailTemplateService.deleteMailTemplate(vo.getId());
			obj.put("message", "Data Successfully Deleted");
		}
		catch (Exception e) {
			e.printStackTrace();
			obj.put("message", "Some Error Occurred");
		}
		
		return new ResponseEntity<> (obj, HttpStatus.OK);
	}
}
