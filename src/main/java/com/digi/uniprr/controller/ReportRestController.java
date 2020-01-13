package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManuScriptByJournalVo;
import com.digi.uniprr.VO.ReportVO;
import com.digi.uniprr.VO.ReviewerDataWithCommentVO;
import com.digi.uniprr.VO.ReviewerOverviewVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.service.ReportSevice;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/report")
public class ReportRestController {

	@Autowired
	ReportSevice reportSevice;

	JSONObject obj = new JSONObject();

	@PostMapping("getReport")
	public List<ReportVO> getReport(@RequestBody UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ReportVO> report = reportSevice.getReport(userJournalManuscriptVo);

		return report;

	}

	@PostMapping("getManuScriptByJournal")
	public ResponseEntity<?> getManuScriptByJournal(@RequestBody ManuScriptByJournalVo manuScriptByJournalVo) {
		try {
			List<ManuScriptByJournalVo> list = reportSevice.getManuScriptByJournal(manuScriptByJournalVo);
			if (list != null &&!list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
			obj.put("message", "Data Not Found");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("message", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
	}
	
	@PostMapping("getReviewerOverview")
	public ResponseEntity<?> getReviewerOverview(@RequestBody IDVO userId) {
		try {
			List<ReviewerOverviewVO> list = reportSevice.getReviewerOverview(userId.getId());
			if (list != null &&!list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
			obj.put("message", "Data Not Found");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("message", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
	}
	
	
	@PostMapping("getReportByUserId")
	public ResponseEntity<?> getReportByUserId(@RequestBody IDVO userId) {
		
		List<List<ReportVO>> reportList=reportSevice.getReportByUserId(userId);
		if(reportList!=null && !reportList.isEmpty()) {
			obj.put("data", reportList);
		}
		else {
			obj.put("message", "Data Not Found");
		}	
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("getReviewerOverviewReport")
	public ResponseEntity<?> getReviewerOverviewReport(@RequestBody IDVO userId) {
		
		List<ReviewerDataWithCommentVO> reportList=reportSevice.getReviewerOverviewReport(userId);
		
		System.out.println(reportList);
		if(reportList!=null && !reportList.isEmpty()) {
			obj.put("data", reportList);
		}
		else {
			obj.put("data", "Data Not Found");
		}	
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	

}
