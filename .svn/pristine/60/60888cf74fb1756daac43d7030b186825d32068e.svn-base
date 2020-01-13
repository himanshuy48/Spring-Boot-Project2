  package com.digi.uniprr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.enums.YNStatus;
import com.digi.uniprr.model.ManuscriptAuthor;
import com.digi.uniprr.service.ManuscriptAuthorService;

@RestController
@RequestMapping("/manuscriptAuthor")
public class ManuscriptAuthorRestController {
	@Autowired
	ManuscriptAuthorService manuscriptAuthorService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createManuscriptAuthor(@RequestBody ManuscriptAuthor manuscriptAuthor) {
		if (manuscriptAuthor.getPrimaryAuthor() != YNStatus.No) {
			manuscriptAuthorService.createManuscriptCoAuthor(manuscriptAuthor);
			return new ResponseEntity<>("Co-Author Created successfully", HttpStatus.CREATED);
		}

		else {
			manuscriptAuthorService.createManuscriptAuthor(manuscriptAuthor);
			return new ResponseEntity<>("Author Created successfully", HttpStatus.OK);
		}
	}

}
