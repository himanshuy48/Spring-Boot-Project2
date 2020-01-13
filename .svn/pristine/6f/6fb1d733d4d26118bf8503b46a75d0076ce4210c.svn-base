package com.digi.uniprr.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ReviewerAvailabilityVO;
import com.digi.uniprr.VO.ReviewerFilterVO;
import com.digi.uniprr.VO.ReviewerStatusData;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.VO.SearchReviewerVO;
import com.digi.uniprr.model.Reviewer;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.model.User;
import com.digi.uniprr.service.CommonService;
import com.digi.uniprr.service.ReviewerService;
import com.digi.uniprr.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reviewer")
public class ReviewerRestController {
	@Autowired
	ReviewerService reviewerService;

	@Autowired
	private CommonService commonService;

	@Autowired
	UserService userService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getReviewerListDeatils() {
		List<User> reviewerList = reviewerService.getReviewerListDeatils();
		return reviewerList;
	}

	@RequestMapping(value = "/getReviewerWithAvailability", method = RequestMethod.GET)
	public List<ReviewerVO> getReviewerWithAvailability() {
		List<ReviewerVO> reviewerList = reviewerService.getReviewerWithAvailability();
		return reviewerList;
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<?> getReviewerList() {
		List<ReviewerVO> reviewervoList = reviewerService.getReviewerList();
		obj.put("data", reviewervoList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createReviewer(@RequestBody Reviewer reviewer) {
		if (reviewerService.isExistById(reviewer.getId())) {
			obj.put("data", "Id already exist " + reviewer.getId());
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
		reviewerService.createReviewer(reviewer);
		return new ResponseEntity<>("Created successfully", HttpStatus.OK);
	}

	@PostMapping("saveReviewerAvailability")
	public ResponseEntity<?> saveReviewerAvailability(@RequestBody ReviewerAvailability reviewerAvailability) {
		JSONObject obj = new JSONObject();
		try {
			reviewerService.saveReviewerAvailability(reviewerAvailability);
			obj.put("data", "Created successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("getReviewerAvailability")
	public ResponseEntity<?> getReviewerAvailabilityById(@RequestBody IDVO id) {
		JSONObject obj = new JSONObject();
		List<ReviewerAvailabilityVO> reviewerAvailabilityList = new ArrayList<>();
		try {
			reviewerAvailabilityList = reviewerService.getReviewerAvailabilityById(id.getId());
			obj.put("data", reviewerAvailabilityList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("deleteReviewerAvailability")
	public ResponseEntity<?> deleteReviewerAvailabilityById(@RequestBody IDVO id) {
		JSONObject obj = new JSONObject();
		try {
			reviewerService.deleteReviewerAvailabilityById(id.getId());
			obj.put("data", "Data deleted successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResponseEntity<?> searchReviewer(@RequestBody SearchReviewerVO searchReviewerVO) {
		List<SearchReviewerVO> reviewerList = commonService.queryReviewer(searchReviewerVO);
		return new ResponseEntity<>(reviewerList, HttpStatus.OK);
	}

	@PostMapping("getReviewerByJournalId")
	public ResponseEntity<?> getReviewerByJournalId(@RequestBody IDVO id) {
		List<ReviewerStatusData> data = reviewerService.getReviewerByJournalId(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/searchReviwer", method = RequestMethod.POST)
	public ResponseEntity<?> searchReviwer(@RequestBody ReviewerFilterVO vo) {
		List<ReviewerVO> list = userService.reviewerFilter(vo);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
