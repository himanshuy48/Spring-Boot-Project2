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

import com.digi.uniprr.VO.ManuScriptEditorCommonVO;
import com.digi.uniprr.VO.ManuScriptReviewerCommonVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.ManuscriptEditor;
import com.digi.uniprr.service.ManuscriptEditorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuscriptEditor")
public class ManuscriptEditorRestController {

	@Autowired
	ManuscriptEditorService manuscriptEditorService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createManuscriptEditor(@RequestBody ManuscriptEditor manuscriptEditor) {
		try {
			manuscriptEditorService.createManuscriptEditor(manuscriptEditor);
			obj.put("data", "Data inserted...");
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong...");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("getManuscriptEditor")
	public ResponseEntity<?> getManuscriptEditor(@RequestBody UserJournalManuscriptVo userJournalManuscriptVo) {

		List<ManuscriptEditor> manuscriptEditorList = manuscriptEditorService
				.getManuscriptEditor(userJournalManuscriptVo);
		obj.put("data", manuscriptEditorList);
		return new ResponseEntity<>(obj, HttpStatus.OK);

	}

	@PostMapping("addMultipleEditorRecord")
	public ResponseEntity<?> addMultipleEditorRecord(@RequestBody ManuScriptEditorCommonVO manuScriptEditorCommonVO) {
		try {
			manuscriptEditorService.addAllDetailsMultipleTableRCC(manuScriptEditorCommonVO);
			obj.put("data", "Data inserted Succesfully...");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong..");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
	}

	@PostMapping("sendBackToAuthor")
	public ResponseEntity<?> sendBackToAuthor(@RequestBody ManuScriptEditorCommonVO manuScriptEditorCommonVO) {
		try {
			manuscriptEditorService.addsendBackToAuthor(manuScriptEditorCommonVO);
			obj.put("data", "Data inserted Succesfully...");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong..");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

	}

}
