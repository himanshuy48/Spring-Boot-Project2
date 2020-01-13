package com.digi.uniprr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.ContributorRoles;
import com.digi.uniprr.service.ContributorRolesService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/contributorRole")
public class ContributorRolesRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ContributorRolesService contributorRolesService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> listContributorRole() {
		log.info("Inside contributorRole listContributorRole");
		List<ContributorRoles> list = contributorRolesService.getAllContributorRoles();
		return new ResponseEntity<> (list, HttpStatus.OK);
	}

}
