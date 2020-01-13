package com.digi.uniprr.controller;
import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ForgotPassword;



@RestController
@SuppressWarnings({ "unchecked" })
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ForgotPasswordRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ForgotPassword forgotPassword;

	@Autowired
	UserRepo userRepo;

	@PostMapping("forgotPassword")
	public ResponseEntity<?> forgotUserPassword(@RequestBody User user) {
		log.info("Inside ForgotPasswordRestController forgotUserPassword");
		JSONObject obj = new JSONObject();
		User existingUser = userRepo.findByEmail(user.getEmail());
		
		if (existingUser != null) {
			String token = UUID.randomUUID().toString();
			forgotPassword.sendMailForPassword(user.getEmail(), token);
			obj.put("message", "Password reset link sended");
		} else {
			obj.put("message", "This email address does not exist!");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("resetPassword")
	public ResponseEntity<?> resetPassword(@RequestBody User user) {
		log.info("Inside ForgotPasswordRestController resetPassword");
		JSONObject obj = new JSONObject();
		List<User> usersDetailsList = forgotPassword.findUserDetailsByToken(user.getToken());
		if (usersDetailsList!=null && !usersDetailsList.isEmpty()) {
			forgotPassword.saveUpdatedPassword(user.getToken(), user.getPassword());
			obj.put("message", "password has been updated successfully.");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} else {
			obj.put("message", "token is expired.");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
	}

}