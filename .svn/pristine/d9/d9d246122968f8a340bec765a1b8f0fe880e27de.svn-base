package com.digi.uniprr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.Institution;
import com.digi.uniprr.service.InstitutionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/institution")
public class InstitutionRestController 
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    InstitutionService institutionService;
    
	@RequestMapping(value="/getInstitutionDetails" , method=RequestMethod.GET)
	public List<Institution> getInstitutionList()
	{
		log.info("Inside InstitutionRestController getInstitutionList");
		List<Institution> institutionList = institutionService.getInstitutionList();
		return institutionList;
	}
	
}
