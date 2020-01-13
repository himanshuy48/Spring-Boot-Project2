package com.digi.uniprr.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManuscriptEditorVO;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.service.ManuScriptService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/manuscript")
public class ManuScriptController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ManuScriptService manuScriptService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/createManuScript", method = RequestMethod.POST)
	public ResponseEntity<Object> createManuScript(@RequestBody ManuScript manuScript) {
		log.info("Inside In manuscript createManuScript");
		if (manuScriptService.isExist(manuScript.getManuScriptId())) {
			return new ResponseEntity<Object>("Id already exist", HttpStatus.CONFLICT);
		}
		manuScriptService.createManuScript(manuScript);
		return new ResponseEntity<Object>("ManuScript created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getManuScriptList", method = RequestMethod.GET)
	public List<ManuScript> getManuScriptList() {
		log.info("Inside In manuscript getManuScriptList");
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		return manuScriptList;
	}

	@RequestMapping(value = "/updateManuScript", method = RequestMethod.GET)
	public ResponseEntity<Object> updateManuScript(@RequestBody ManuScript manuScript) {
		log.info("Inside In manuscript updateManuScript");
		if (manuScriptService.isExist(manuScript.getManuScriptId())) {
			manuScriptService.updateManuScript(manuScript);
			return new ResponseEntity<Object>("Updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Does not exist", HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/deleteManuScript", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteManuScript(@RequestBody ManuScript manuScript) {
		log.info("Inside In manuscript deleteManuScript");
		if (manuScriptService.isExist(manuScript.getManuScriptId())) {
			manuScriptService.deleteManuScriptById(manuScript.getManuScriptId());
			return new ResponseEntity<Object>("ManuScript deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Id does not exist", HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/getManuScriptListById", method = RequestMethod.POST)
	public List<ManuScript> getManuScriptListById(@RequestParam Integer id) {
		log.info("Inside In manuscript getManuScriptListById");
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptListById(id);
		return manuScriptList;
	}

	@RequestMapping(value = "/trackManuScript", method = RequestMethod.POST)
	public List<ManuScript> trackManuScript(@RequestParam Integer id) {
		log.info("Inside In manuscript trackManuScript");
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptListById(id);
		return manuScriptList;
	}

	@RequestMapping(value = "/startSubmission", method = RequestMethod.POST)
	public ResponseEntity<?> startSubmission(@RequestBody IDVO vo) {
		log.info("Inside In manuscript startSubmission");
		ManuScript manuScriptModel = new ManuScript();
		manuScriptModel.setJournalId(vo.getId());
		obj.put("manuscriptId", manuScriptService.createManuScript(manuScriptModel).getManuScriptId());
		obj.put("manuscriptCode", manuScriptService.createManuScript(manuScriptModel).getManuscriptCode());
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	@PostMapping("updateManuScriptEditor")
	public ResponseEntity<?> updateManuScriptEditor(@RequestBody ManuscriptEditorVO manuscriptEditorVO) {
		log.info("Inside In manuscript updateManuScriptEditor");
		String manu=manuScriptService.updateManuScriptEditor(manuscriptEditorVO);
		obj.put("message", manu);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	@PostMapping("getUniqueManuScript")
	public ResponseEntity<?> getUniqueManuScript(@RequestParam("journalId") Integer journalId) {
		log.info("Inside In manuscript getUniqueManuScript");
		return new ResponseEntity<Object>(manuScriptService.getUniqueManuScript(journalId), HttpStatus.OK);
	}

}
