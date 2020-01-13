package com.digi.uniprr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.JournalFileType;
import com.digi.uniprr.serviceImpl.JournalFileTypeServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/journalFileType")
public class JournalFileTypeController {
	
	@Autowired
	JournalFileTypeServiceImpl journalFileTypeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<JournalFileType> getList() {
		List<JournalFileType> list = journalFileTypeService.getDetails();
		return list;
	}
}
