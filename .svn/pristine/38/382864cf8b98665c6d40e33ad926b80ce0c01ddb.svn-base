package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.KeywordsVO;
import com.digi.uniprr.model.KeywordMaster;
import com.digi.uniprr.model.Keywords;
import com.digi.uniprr.service.KeywordsService;
import com.digi.uniprr.utils.CustomErrorType;

@RestController
@RequestMapping("/keywords")
public class KeywordRestController {

	@Autowired
	KeywordsService keywordsService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createKeywords(@RequestBody Keywords keywords) {
		if (!keywordsService.isExistByJournalId(keywords.getJournalId())) {
			return new ResponseEntity<>(
					new CustomErrorType("Keywords with journal Id " + keywords.getJournalId() + " already Exist"),
					HttpStatus.CONFLICT);
		}
		keywordsService.createKeywords(keywords);
		obj.put("data", "Keywords with journal id " + keywords.getJournalId() + " Created successfully");
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getKeywordsList() {
		List<Keywords> list = keywordsService.getKeywordsList();
		obj.put("data", list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/listById", method = RequestMethod.POST)
	public ResponseEntity<?> getKeywordsListById(@RequestBody IDVO vo) {
		if (keywordsService.isExist(vo.getId())) {
			List<Keywords> keywordsList = keywordsService.getKeywordsListById(vo.getId());
			obj.put("data", keywordsList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Id does not exist");
		return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateKeywords(@RequestBody Keywords keywords) {
		if (keywordsService.isExist(keywords.getId())) {
			keywordsService.updateKeywords(keywords);
			obj.put("data", "Keywords with id " + keywords.getId() + " Updated successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Id does not exist");
		return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ResponseEntity<?> getDetails() {
		List<Keywords> keywordsList = keywordsService.getDetails();
		obj.put("data", keywordsList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<?> keywordsDetails() {
		List<KeywordsVO> keywordsList = keywordsService.getKeywordsDetails();
		obj.put("data", keywordsList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/listByJournalId", method = RequestMethod.POST)
	public ResponseEntity<?> listByJournalId(@RequestBody IDVO vo) {
		List<KeywordsVO> keywordsList = keywordsService.listByJournalId(vo);
		if (keywordsList != null && !keywordsList.isEmpty()) {
			obj.put("data", keywordsList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Data not found");
		return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/deleteKeyword", method = RequestMethod.POST)
	public ResponseEntity<?> deleteKeyword(@RequestBody IDVO vo) {
		try {
			keywordsService.deleteKeyword(vo);
			obj.put("data", "deleted...");
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	// KeywordMaster

	@PostMapping("getKeyeordMaster")
	public ResponseEntity<?> getKeyeordMaster(@RequestBody IDVO id) {
		KeywordMaster KeywordMaster = keywordsService.getKeyeordMaster(id);
		if (KeywordMaster != null) {
			obj.put("data", KeywordMaster);
		} else {
			obj.put("data", "Data Not Found");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/getKeyeordMasterList", method = RequestMethod.GET)
	public ResponseEntity<?> getKeyeordMasterList() {
		List<KeywordMaster> KeywordMasterList = keywordsService.getKeyeordMasterList();
		if (KeywordMasterList != null) {
			obj.put("data", KeywordMasterList);
		} else {
			obj.put("data", "Data Not Found");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("updateKeyeordMaster")
	public ResponseEntity<?> updateKeyeordMaster(@RequestBody KeywordMaster keywordMaster) {
		try {
			keywordsService.updateKeywordMaster(keywordMaster);
			obj.put("data", "Updated successfully");
		} catch (Exception e) {
			obj.put("data", "Something Went wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("deleteKeywordMaster")
	public ResponseEntity<?> deleteKeyeordMaster(@RequestBody IDVO id) {
		try {
			keywordsService.deleteKeywordMaster(id);
			obj.put("data", "Deleted successfully");
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something Went wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("createKeyeordMasters")
	public ResponseEntity<?> createKeyeordMaster(@RequestBody KeywordMaster keywordMaster) {
		try {
			keywordsService.cretaeKeywordMaster(keywordMaster);
			obj.put("data", "Created successfully");
		} catch (Exception e) {
			obj.put("data", "Something Went wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
