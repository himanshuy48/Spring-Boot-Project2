package com.digi.uniprr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.User;
import com.digi.uniprr.service.UserRoleService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/userRole")

public class UserRoleRestController {
	
	@Autowired
	UserRoleService userRoleService;

	@RequestMapping(value = "/listById", method = RequestMethod.POST)
	public ResponseEntity<?> listById(@RequestParam("id") Integer id){
		
		List<User> userRole = userRoleService.getlistById(id);
		
		return new ResponseEntity<>(userRole, HttpStatus.OK);
		
	}

}
