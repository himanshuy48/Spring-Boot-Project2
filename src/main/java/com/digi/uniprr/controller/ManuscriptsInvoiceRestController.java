package com.digi.uniprr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.ManuscriptsInvoice;
import com.digi.uniprr.service.ManuscriptsInvoiceService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/manusciptsInvoice")
public class ManuscriptsInvoiceRestController {

	@Autowired
	ManuscriptsInvoiceService manuscriptsInvoiceService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ManuscriptsInvoice manuscriptsInvoice) {
		manuscriptsInvoiceService.createInvoice(manuscriptsInvoice);

		return new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
	}

}
