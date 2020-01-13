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
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.UserJournalVO;
import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.service.UserJournalService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/userJournal")
public class UserJournalRestController {

	@Autowired
	UserJournalService userJournalService;
	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/roleJournalById", method = RequestMethod.POST)
	public ResponseEntity<?> roleJournalById(@RequestBody UserJournalVO userJournalVO) {
		List<UserVO> list=userJournalService.getListById(userJournalVO);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}


}
