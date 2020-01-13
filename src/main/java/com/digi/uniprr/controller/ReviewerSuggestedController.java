package com.digi.uniprr.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.ReviewerSuggestedVO;
import com.digi.uniprr.VO.ReviewerSuggestionVO;
import com.digi.uniprr.model.ReviewerSuggested;
import com.digi.uniprr.model.User;
import com.digi.uniprr.service.ReviewerSuggestedService;
import com.digi.uniprr.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reviewerSuggested")
public class ReviewerSuggestedController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReviewerSuggestedService reviewerSuggestedService;
	 
	@RequestMapping(value = "/createDecline", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody ReviewerSuggestionVO reviewerSuggestionVO ) {
		JSONObject obj = new JSONObject();
		try {
			if(reviewerSuggestionVO.getBoxesofboxes() == "") {
				  reviewerSuggestedService.createUser(reviewerSuggestionVO);
			}else {
				for (int i = 0; i <= reviewerSuggestionVO.getReviewerSuggested().size() - 1; i++) {
					   User isExist = userService.getByEmail(reviewerSuggestionVO.getReviewerSuggested().get(i).getEmail());
						if (isExist != null ) {
							obj.put("data", "User already exist  .");
							return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
						}
					  }
					reviewerSuggestedService.createUser(reviewerSuggestionVO);
			}
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something Went Wrong ...");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
		obj.put("data", "User successfully created.");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/createReviewerSuggestedArray", method = RequestMethod.POST)
	public ResponseEntity<?> createReviewerSuggestedArray(@RequestBody ReviewerSuggestedVO reviewerSuggestedVO ) {
		JSONObject obj = new JSONObject();
		try {
			    ReviewerSuggested isExist = reviewerSuggestedService.getByEmailId(reviewerSuggestedVO.getEmail());
				if (isExist != null) {
					obj.put("data", "User already exist  .");
					return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
				}
			 reviewerSuggestedService.createReviewerSuggestedArray(reviewerSuggestedVO);
		 } 
	     catch (Exception e)
		     {
			    System.out.println(e);
			    obj.put("data", "Something Went Wrong.....");
			    return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		     }
		obj.put("data", "ReviewerSuggested successfully created.");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}


}
