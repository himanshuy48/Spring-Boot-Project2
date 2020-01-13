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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.JournalListVO;
import com.digi.uniprr.VO.JournalVO;
import com.digi.uniprr.model.Groups;
import com.digi.uniprr.model.Journal;
import com.digi.uniprr.service.GroupService;
import com.digi.uniprr.service.JournalService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/journal")
public class JournalRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JournalService journalService;

	@Autowired
	GroupService groupService;
	
	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createJournal(@RequestBody Journal journals) {
		log.info("Inside journal createJournal ");
		if (journalService.isIdExist(journals.getJournalId())) {
			return new ResponseEntity<Object>("Already exist", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		journalService.createJournal(journals);
		return new ResponseEntity<Object>("Journal created", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/listEditorById", method = RequestMethod.POST)
	public ResponseEntity<?> getEditorGroupId(@RequestParam Integer id) {
		log.info("Inside journal getEditorGroupId ");
		JournalVO vo = new JournalVO();
		List<JournalVO> vos = new ArrayList<JournalVO>();
		List<Groups> groupList = groupService.getgroupsById(id);
		for (int i = 0; i < groupList.size(); i++) {
			vo.setId(groupList.get(i).getId());
			vo.setGroupName(groupList.get(i).getGroupName());
			vos.add(vo);
		}
		return new ResponseEntity<>(vos, HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<JournalListVO> getJournalDetails() {
		log.info("Inside journal getJournalDetails ");
		List<JournalListVO> journalsList = journalService.getJournalDetails();
		return journalsList;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Object> updateJournal(@RequestBody Journal journals) {
		log.info("Inside journal updateJournal ");
		if (journalService.isIdExist(journals.getJournalId())) {
			journalService.updateJournal(journals);
			return new ResponseEntity<Object>("Journal Updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>("Does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseEntity<Object> deleteJournal(@RequestBody Journal journals) {
		log.info("Inside journal deleteJournal ");
		if (journalService.isIdExist(journals.getJournalId())) {
			journalService.deleteJournalById(journals.getJournalId());
			return new ResponseEntity<Object>("Journal deleted", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Id does not exist", HttpStatus.BAD_REQUEST);
	}
	
	

	@RequestMapping(value="/listEditorByJId" , method=RequestMethod.POST)
	public ResponseEntity<?> getEditorByJournalId(@RequestParam Integer id)
	{
		log.info("Inside journal getEditorByJournalId ");
		List<Groups> groupList = groupService.getJournalDetailsById(id);
		return new ResponseEntity<>(groupList , HttpStatus.OK);
	}
	
	@RequestMapping(value="/getById" , method=RequestMethod.POST)
	public ResponseEntity<?> getJournalById(@RequestBody IDVO id){
		log.info("Inside journal getJournalById ");
		JournalVO journalDetail = journalService.getJournalById(id.getId());
		if(journalDetail != null) {
			obj.put("data", journalDetail);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}else {
			obj.put("data", "No data found");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
		
	}
	
	
}
