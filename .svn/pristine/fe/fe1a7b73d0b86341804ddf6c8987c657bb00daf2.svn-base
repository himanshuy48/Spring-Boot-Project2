package com.digi.uniprr.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.JournalVO;
import com.digi.uniprr.VO.ManuScriptTrackCodeVO;
import com.digi.uniprr.VO.ManuScriptTrackDateVO;
import com.digi.uniprr.VO.ManuScriptTrackJNameVO;
import com.digi.uniprr.VO.ManuScriptTrackTitleVO;
import com.digi.uniprr.VO.ManuScriptTrackVO;
import com.digi.uniprr.VO.ManuScriptVO;
import com.digi.uniprr.VO.ManuscriptFilterVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.TrackManuScriptVO;
import com.digi.uniprr.model.JournalChargeDetails;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.StatusMaster;
import com.digi.uniprr.service.CommonService;
import com.digi.uniprr.service.JournalService;
import com.digi.uniprr.service.ManuScriptService;
import com.digi.uniprr.service.StatusMasterService;
import com.digi.uniprr.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/manuScript")
public class ManuScriptRestController {
	
	@Autowired
	ManuScriptService manuscriptService;

	@Autowired
	StatusMasterService statusMasterService;
	
	@Autowired
	JournalService journalService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommonService commonService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createManuScript(@RequestBody ManuScript manuScript) {
		manuscriptService.createManuScript(manuScript);
		return new ResponseEntity<Object>("ManuScript created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ManuScript> getManuScriptList() {
		List<ManuScript> manuScriptList = manuscriptService.getManuScriptList();
		return manuScriptList;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Object> updateManuScript(@RequestBody ManuScript manuScript) {
		if (manuscriptService.isExist(manuScript.getManuScriptId())) {
			manuscriptService.updateManuScript(manuScript);
			return new ResponseEntity<Object>("Updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Does not exist", HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteManuScript(@RequestBody ManuScript manuScript) {
		if (manuscriptService.isExist(manuScript.getManuScriptId())) {
			manuscriptService.deleteManuScriptById(manuScript.getManuScriptId());
			return new ResponseEntity<Object>("ManuScript deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Id does not exist", HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/listById", method = RequestMethod.POST)
	public List<ManuScript> getManuScriptListById(@RequestParam Integer id) {

		List<ManuScript> manuScriptList = manuscriptService.getManuScriptListById(id);
		return manuScriptList;
	}

// assign stage for Editor Login
	@RequestMapping(value = "/sendBackToAuthor", method = RequestMethod.POST)
	public ResponseEntity<?> sendBackToAuthor(@RequestBody ManuScript manuScript) {

		manuscriptService.updateStage(manuScript);
		JSONObject obj = new JSONObject();
		obj.put("Status", "Assigned successfully.");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/startSubmission", method = RequestMethod.POST)
	public ResponseEntity<?> startSubmission(@RequestBody ManuScriptVO vo) {
		ManuScript manuScriptModel = new ManuScript();
		manuScriptModel.setJournalId(vo.getId());
		manuScriptModel.setAuthorId(vo.getAuthorId());
		ManuScript manuscriptDetail=manuscriptService.createManuScript(manuScriptModel);
		JournalVO journalVO = journalService.getJournalById(vo.getId());
		obj.put("manuscriptId", manuscriptDetail.getManuScriptId());
		obj.put("manuscriptversion",manuscriptDetail.getManuscriptVersion());
		obj.put("journalId", journalVO.getJournalId());
		obj.put("journalCode", journalVO.getJournalCode());
		obj.put("journalTitle", journalVO.getJournalTitle());
		obj.put("journalShortTitle", journalVO.getJournalShortTitle());
		obj.put("chargeFlag", journalVO.getChargeFlag());
		obj.put("journalBlindType", journalVO.getJournalBlindType());
		
		if (journalVO.getChargeFlag().equalsIgnoreCase("yes")) {
			JournalChargeDetails charge = journalService.getJournalChargeDetailsByJournalId(vo.getId());
			if (charge != null) {
				obj.put("fixedCharges", charge.getFixedCharges());
				obj.put("colorCharges", charge.getColorCharges());
				obj.put("blackWhiteCharges", charge.getBlackWhiteCharges());
				obj.put("tableCharges", charge.getTableCharges());
				obj.put("additionalCharges", charge.getAdditionalCharges());
				obj.put("productionCharges", charge.getProductionCharges());
				obj.put("fixedChargeAmount", charge.getFixedChargeAmount());
			}
		}
		
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

// assign stage for approveSubmission
	@RequestMapping(value = "/approveSubmission", method = RequestMethod.POST)
	public ResponseEntity<?> approveSubmission(@RequestBody ManuScript manuScript) {

		List<StatusMaster> statusMaster = statusMasterService.getStatusMasterDetailsById(manuScript.getManuScriptId());
		return new ResponseEntity<>(statusMaster, HttpStatus.OK);
	}

// assign stage for approveSubmission
	@RequestMapping(value = "/assignReviewer", method = RequestMethod.POST)
	public ResponseEntity<?> assignReviewer(@RequestBody ManuScript manuScript) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/trackManuScriptListById", method = RequestMethod.POST)
	public JSONObject trackManuScriptTestDone(@RequestParam Integer id) {

		JSONObject obj = null;
		List<ManuScriptTrackVO> manulList = new ArrayList<ManuScriptTrackVO>();
		List<ManuScript> manuScriptList = manuscriptService.trackManuScript(id);
		for (ManuScript ms : manuScriptList) {
			ManuScriptTrackVO vo = new ManuScriptTrackVO();
			vo.setManuScriptId(ms.getManuScriptId());
			vo.setJournalTitle(ms.getJournal().getJournalTitle());
			vo.setAuthorName(ms.getUser().getFirstName() + " " + ms.getUser().getLastName());
			vo.setSubmissionDate(ms.getSubmissionDate());
			vo.setManuScriptTitle(ms.getManuscriptTitle());
			vo.setJournalId(ms.getJournal().getJournalId());

			obj = new JSONObject();
			obj.put("ManuscriptId", ms.getManuScriptId());
			obj.put("JournalName", ms.getJournal().getJournalTitle());
			obj.put("AuthorName", ms.getUser().getFirstName() + " " + ms.getUser().getLastName());
			obj.put("Title", ms.getManuscriptTitle());
			obj.put("SubmissionDate", ms.getSubmissionDate());

// manulList.add(obj);
		}
		return obj;
	}

	@RequestMapping(value = "/trackManuScriptList", method = RequestMethod.POST)
	public List<ManuScriptTrackVO> gettrackManuScriptTestDone(@RequestParam Integer id) {

		List<ManuScriptTrackVO> manulList = new ArrayList<>();
		List<ManuScript> manuScriptList = manuscriptService.trackManuScript(id);
		for (ManuScript ms : manuScriptList) {
			ManuScriptTrackVO vo = new ManuScriptTrackVO();
			vo.setManuScriptId(ms.getManuScriptId());
			vo.setJournalTitle(ms.getJournal().getJournalTitle());
			vo.setJournalId(ms.getJournal().getJournalId());
			vo.setAuthorName(ms.getUser().getFirstName() + " " + ms.getUser().getLastName());
			vo.setManuScriptTitle(ms.getManuscriptTitle());
			vo.setSubmissionDate(ms.getSubmissionDate());
			manuScriptList = manuscriptService.gettrackManuScriptList(vo.getManuScriptId(), vo.getJournalId(),
					vo.getSubmissionDate());
			manulList.add(vo);
		}
		return manulList;
	}

	@RequestMapping(value = "/trackManuScriptDateList", method = RequestMethod.POST)
	public ResponseEntity<?> gettrackManuScriptDateTestDone(@RequestParam String submissionDateTo,
			@RequestParam String submissionDateFrom) {
		List<ManuScriptTrackDateVO> statusList = new ArrayList<ManuScriptTrackDateVO>();
		List<ManuScript> manuScriptList = manuscriptService.gettrackManuScriptListDate(submissionDateTo,
				submissionDateFrom);

		for (ManuScript ms : manuScriptList) {
			SimpleDateFormat formatter = new SimpleDateFormat();
			ManuScriptTrackDateVO vo = new ManuScriptTrackDateVO();
			vo.setManuScriptId(ms.getManuScriptId());
			vo.setJournalId(ms.getJournal());
			vo.setManuscriptCode(ms.getManuscriptCode());
			vo.setManuscriptAuthorId(ms.getUser().getId());
			vo.setStatusMaster(ms.getStatusMaster());
			vo.setManuscriptVersion(ms.getManuscriptVersion());
			vo.setSubmissionDate(ms.getSubmissionDate());
			vo.setSubmittedBy(ms.getSubmittedBy());
			vo.setCreatedBy(ms.getCreatedBy());
			vo.setCreatedOn(ms.getCreatedOn());
			vo.setUpdatedBy(ms.getUpdatedBy());
			vo.setUpdatedOn(ms.getUpdatedOn());
			vo.setManuscriptTitle(ms.getManuscriptTitle());
			vo.setSubmissionDateTo(formatter.format(ms.getSubmissionDate()));
			vo.setSubmissionDateFrom(formatter.format(ms.getSubmissionDate()));
			statusList.add(vo);
		}
		return new ResponseEntity<>(statusList, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trackManuScriptTitleList", method = RequestMethod.POST)
	public ResponseEntity<?> gettrackManuScriptTitleTestDone(@RequestBody ManuScript manuscript) {
		List<ManuScriptTrackTitleVO> statusList = new ArrayList<ManuScriptTrackTitleVO>();
		List<ManuScript> manuScriptList = manuscriptService
				.gettrackManuScriptListTitle(manuscript.getManuscriptTitle());

		for (ManuScript ms : manuScriptList) {
			ManuScriptTrackTitleVO vo = new ManuScriptTrackTitleVO();
			vo.setManuScriptId(ms.getManuScriptId());
			vo.setJournalId(ms.getJournal());
			vo.setManuscriptCode(ms.getManuscriptCode());
			vo.setManuscriptAuthorId(ms.getUser().getId());
			vo.setStatusMaster(ms.getStatusMaster());
			vo.setManuscriptVersion(ms.getManuscriptVersion());
			vo.setSubmissionDate(ms.getSubmissionDate());
			vo.setSubmittedBy(ms.getSubmittedBy());
			vo.setCreatedBy(ms.getCreatedBy());
			vo.setCreatedOn(ms.getCreatedOn());
			vo.setUpdatedBy(ms.getUpdatedBy());
			vo.setUpdatedOn(ms.getUpdatedOn());
			vo.setManuscriptTitle(ms.getManuscriptTitle());
			statusList.add(vo);
		}
		return new ResponseEntity<>(statusList, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trackManuScriptJTitleList", method = RequestMethod.POST)
	public ResponseEntity<?> gettrackManuScriptJtitleTestDone(@RequestParam String journalTitle) {
		List<ManuScriptTrackJNameVO> statusList = new ArrayList<>();
		List<ManuScript> manuScriptList = manuscriptService.gettrackManuScriptJtitle(journalTitle);

		for (ManuScript ms : manuScriptList) {
			ManuScriptTrackJNameVO vo = new ManuScriptTrackJNameVO();
			vo.setManuScriptId(ms.getManuScriptId());
			vo.setJournalTitle(ms.getJournal().getJournalTitle());
			vo.setAuthorName(ms.getUser().getFirstName() + " " + ms.getUser().getLastName());
			vo.setSubmissionDate(ms.getSubmissionDate());
			vo.setManuScriptTitle(ms.getManuscriptTitle());

			statusList.add(vo);
		}
		return new ResponseEntity<>(statusList, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trackManuScriptCodeList", method = RequestMethod.POST)
	public ResponseEntity<?> gettrackManuScriptCodeTestDone(@RequestBody ManuScript manuscript) {
		List<ManuScriptTrackCodeVO> statusList = new ArrayList<ManuScriptTrackCodeVO>();
		List<ManuScript> manuScriptList = manuscriptService.gettrackManuScriptListCode(manuscript.getManuscriptCode());

		for (ManuScript ms : manuScriptList) {
			ManuScriptTrackCodeVO vo = new ManuScriptTrackCodeVO();
			vo.setManuScriptId(ms.getManuScriptId());
			vo.setJournalId(ms.getJournal());
			vo.setManuscriptCode(ms.getManuscriptCode());
            vo.setManuscriptAuthorId(ms.getUser().getId());
			vo.setStatusMaster(ms.getStatusMaster());
			vo.setManuscriptVersion(ms.getManuscriptVersion());
			vo.setSubmissionDate(ms.getSubmissionDate());
			vo.setSubmittedBy(ms.getSubmittedBy());
			vo.setCreatedBy(ms.getCreatedBy());
			vo.setCreatedOn(ms.getCreatedOn());
			vo.setUpdatedBy(ms.getUpdatedBy());
			vo.setUpdatedOn(ms.getUpdatedOn());

			statusList.add(vo);
		}
		return new ResponseEntity<>(statusList, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trackManuScriptTotalList", method = RequestMethod.POST)
	public ResponseEntity<?> trackManuScriptCodeList(@RequestBody ManuscriptFilterVO manuscriptFilterVO) {
		List<TrackManuScriptVO> manuscriptList = commonService.queryManuscript(manuscriptFilterVO);
		return new ResponseEntity<>(manuscriptList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllManuScriptTotalList", method = RequestMethod.POST)
	public ResponseEntity<?> getAllManuScriptTotalList(@RequestBody ManuscriptFilterVO manuscriptFilterVO) {
		List<TrackManuScriptVO> manuscriptList = commonService.getManuscript(manuscriptFilterVO);
		return new ResponseEntity<>(manuscriptList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByJournalIdManuScriptTotalList", method = RequestMethod.POST)
	public ResponseEntity<?> getByJournalIdManuScriptTotalList(@RequestBody ManuscriptFilterVO manuscriptFilterVO) {
		List<TrackManuScriptVO> manuscriptList = commonService.getJournalIdManuscript(manuscriptFilterVO);
		return new ResponseEntity<>(manuscriptList, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/getManuscriptByStatus", method = RequestMethod.POST)
	public ResponseEntity<?> getManuscriptByStatus(@RequestBody ManuscriptListVO manuscriptVO) {
		
		List<ManuscriptListVO> manuscriptList = manuscriptService.getManuscriptByStatus(manuscriptVO);
		obj.put("data", manuscriptList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

}