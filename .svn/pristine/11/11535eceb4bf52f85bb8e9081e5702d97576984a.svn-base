package com.digi.uniprr.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.CommentVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.service.AllCommentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/comment")
public class AllComment {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AllCommentService allCommentService;
	
	JSONObject obj = new JSONObject();
	
	
	@PostMapping("getAllComment")
	public ResponseEntity<?> getAllComment(@RequestBody IDVO id){
		log.info("comment getAllComment");
		try {
			CommentVO commentData = allCommentService.getAllComment(id);
			if(commentData != null) {
				List<CommentVO> listcommentData = new ArrayList<>();
				listcommentData.add(commentData);
				obj.put("data", listcommentData);
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			return new ResponseEntity<>("Data not found", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Something went wrong", HttpStatus.OK);
		}
		
	}
}
