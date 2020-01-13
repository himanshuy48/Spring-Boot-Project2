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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.CommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerCommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerVO;
import com.digi.uniprr.VO.ReviewerAvailabilityStatusVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.service.ManuScriptReviewerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuScriptReviewer")
public class ManuScriptReviewerController {

	@Autowired
	private ManuScriptReviewerService manuScriptReviewerService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/addManuScriptReviewer", method = RequestMethod.POST)
	public ResponseEntity<?> addManuScriptReviewer(@RequestBody ManuScriptReviewer manuScriptReviewer) {
		manuScriptReviewerService.addReviewerDeatils(manuScriptReviewer);
		return new ResponseEntity<>("Added Sucessfully", HttpStatus.OK);
	}

	@PostMapping("addReviwerIdWithArray")
	public ResponseEntity<?> addCheckListMaster(@RequestBody ManuScriptReviewerVO manuScriptReviewerVo) {
		return new ResponseEntity<>(manuScriptReviewerService.saveManuScriptReviewer(manuScriptReviewerVo),
				HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/updateManuScriptReviewer", method =
	 * RequestMethod.POST) public ResponseEntity<?>
	 * updateManuScriptReviewer(@RequestBody ManuScriptReviewer manuScriptReviewer)
	 * { if (manuScriptReviewerService.isExist(manuScriptReviewer.getManuscriptId(),
	 * manuScriptReviewer.getReviewerId())) {
	 * manuScriptReviewerService.updateReviewerDeatils(manuScriptReviewer); return
	 * new ResponseEntity<Object>("Updated successfully", HttpStatus.OK); } return
	 * new ResponseEntity<Object>("Does not exist", HttpStatus.FORBIDDEN); }
	 */

	@RequestMapping(value = "/updateManuScriptReviewer", method = RequestMethod.POST)
	public ResponseEntity<?> updateManuScriptReviewer(@RequestBody ManuScriptReviewerVO manuScriptReviewerVo) {
		JSONObject obj = new JSONObject();
		try {
			if (manuScriptReviewerService.isExist(manuScriptReviewerVo.getManuscriptId(),
					manuScriptReviewerVo.getReviewerId(), manuScriptReviewerVo.getManuscriptVersion()))
				manuScriptReviewerService.updateReviewerDeatils(manuScriptReviewerVo);
			obj.put("updated", "Updated Data Sucessfully.");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("updated", "Does not exist Table.");
			return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("addMultipleRecord")
	public ResponseEntity<?> addMultipleRecord(@RequestBody ManuScriptReviewerCommonVO manuScriptReviewerCommonVO) {
		try {
			manuScriptReviewerService.addAllDetailsMultipleTableRCC(manuScriptReviewerCommonVO);
			obj.put("data", "Data inserted Succesfully...");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong..");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

	}

	@PostMapping("getManuscriptReviewer")
	public ResponseEntity<?> getManuscriptEditor(@RequestBody UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ManuScriptReviewer> manuscriptReviewerList = manuScriptReviewerService
				.getManuscriptReviewer(userJournalManuscriptVo);
		obj.put("data", manuscriptReviewerList);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("getReviewerByManuScriptIdAndVersion")
	public ResponseEntity<?> getReviewerByManuScriptIdAndVersion(
			@RequestBody ManuScriptReviewerCommonVO manuScriptReviewerCommonVO) {
		try {
			List<ManuScriptReviewerCommonVO> data = manuScriptReviewerService.getReviewerByManuScriptIdAndVersion(
					manuScriptReviewerCommonVO.getManuscriptId(), manuScriptReviewerCommonVO.getManuscriptVersion());
			obj.put("data", data);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong..");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
	}

	@PostMapping("getReviewerDataById")
	public ResponseEntity<?> getReviewerDataById(@RequestBody CommonVO id) {
		try {
			List<ReviewerAvailabilityStatusVO> data = manuScriptReviewerService.getReviewerDataById(id);
			obj.put("data", data);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping("getReviewerDataByManuscriptVersion")
	public ResponseEntity<?> getReviewerDataByManuscriptVersion(@RequestBody ManuScriptReviewerCommonVO manuScriptReviewerCommonVO) {
		try {
			List<ManuScriptReviewerCommonVO> data = manuScriptReviewerService.getReviewerDataByManuscriptVersion(manuScriptReviewerCommonVO.getManuscriptId(), manuScriptReviewerCommonVO.getManuscriptVersion(), manuScriptReviewerCommonVO.getJournalId());
			obj.put("data", data);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("getUniqueReviewer")
	public ResponseEntity<?> getUniqueReviewer(@RequestBody ManuScriptReviewerCommonVO manuScriptReviewerCommonVO) {
		int count =0;
		try {
			List<ManuScriptReviewerCommonVO> assignedReviewer = manuScriptReviewerService.getAssignedReviewer(manuScriptReviewerCommonVO.getManuscriptId(), manuScriptReviewerCommonVO.getManuscriptVersion(), manuScriptReviewerCommonVO.getJournalId());
			List<ManuScriptReviewerCommonVO> unassignedReviewer = manuScriptReviewerService.getReviewerDataByManuscriptVersion(manuScriptReviewerCommonVO.getManuscriptId(), manuScriptReviewerCommonVO.getManuscriptVersion(), manuScriptReviewerCommonVO.getJournalId());
			for(ManuScriptReviewerCommonVO tempData :assignedReviewer) {
				for(ManuScriptReviewerCommonVO data : unassignedReviewer) {
					if(data.getReviewerId().equals(tempData.getReviewerId())) {
						tempData.setTempFlag("true");
					}
				}
			}
			obj.put("assignedReviewer", assignedReviewer);
			obj.put("unassignedReviewer", unassignedReviewer);
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			System.out.println(e);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
