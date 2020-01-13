package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.model.Notification;
import com.digi.uniprr.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationRestController {

	@Autowired
	NotificationService notificationService;
	
	JSONObject obj = new JSONObject();
	
	@PostMapping("getNotificationByUserId")
	public ResponseEntity<?> getNotificationByUserId(@RequestBody IDVO id){
		
		List<Notification> notification= notificationService.getNotificationByUserId(id);
		if(notification!=null && !notification.isEmpty()) {
			obj.put("data", notification);
		}else {
			obj.put("data", "Data Not Found");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping("createNotification")
	public ResponseEntity<?> createNotification(@RequestBody Notification notification){
		try {
			notificationService.createNotification(notification);
			obj.put("data", "Notification Created...");
		}catch(Exception e) {
			obj.put("data", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
