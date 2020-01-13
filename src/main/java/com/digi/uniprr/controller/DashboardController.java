package com.digi.uniprr.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.AuthorDashboardVO;
import com.digi.uniprr.VO.DashboardCountVO;
import com.digi.uniprr.VO.EditorDashboardVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ListCountVO;
import com.digi.uniprr.VO.ReviewerDecisionVO;
import com.digi.uniprr.VO.StatusMasterVO;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.Groups;
import com.digi.uniprr.model.Journal;
import com.digi.uniprr.model.JournalEditorMapping;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.StatusMaster;
import com.digi.uniprr.model.User;
import com.digi.uniprr.service.GroupRoleService;
import com.digi.uniprr.service.JournalEditorMappingService;
import com.digi.uniprr.service.ManuScriptService;
import com.digi.uniprr.service.StatusMasterService;
import com.digi.uniprr.service.UserService;
import com.digi.uniprr.utils.CustomErrorType;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ManuScriptService manuScriptService;

	@Autowired
	StatusMasterService statusMasterService;

	@Autowired
	GroupRoleService groupRoleService;

	@Autowired
	UserService userService;

	@Autowired
	JournalEditorMappingService journalEditorMappingService;

	// Admin List Count for Unsubmitted_Manuscripts
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listCount", method = RequestMethod.POST)
	public JSONObject getManuScriptListCount(@RequestBody ListCountVO Vo) {
		log.info("Inside dashboard getManuScriptListCount");
		// ListCountVO Vo = new ListCountVO();
		JSONObject obj = new JSONObject();
		int m = 0, j = 0, k = 0, l = 0;
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		for (int i = 0; i < manuScriptList.size(); i++) {

			String statusValue = manuScriptList.get(i).getStatusMaster().getStatusValue();
			// unsubmittedManuscripts && majorRevision && minorRevision
			if (statusValue.equalsIgnoreCase(Vo.getUnsubmittedManuscripts())
					|| statusValue.equalsIgnoreCase(Vo.getMajorRevision())
					|| statusValue.equalsIgnoreCase(Vo.getMinorRevision())) {
				m++;
				obj.put("MyTask", m);
			}
			// MANUSCRIPT SENT FOR acceptedByAdmin && declinedByAdmin && rejected
			if (statusValue.equalsIgnoreCase(Vo.getAcceptedByAdmin())
					|| statusValue.equalsIgnoreCase(Vo.getDeclinedByAdmin())
					|| statusValue.equalsIgnoreCase(Vo.getRejected())) {
				j++;
				obj.put("Accepted/Rejected", j);
			}
			// published List
			if (statusValue.equalsIgnoreCase(Vo.getPublished())
					|| statusValue.equalsIgnoreCase(Vo.getReadyForProduction())) {
				k++;
				obj.put("Final", k);
			}
			// newReviewerInvitation List
			if (statusValue.equalsIgnoreCase(Vo.getNewReviewerInvitation())) {
				l++;
				obj.put("UnderReview", l);
			}
		}
		return obj;
	}

	@RequestMapping(value = "/manuScriptList", method = RequestMethod.POST)
	public JSONObject getManuScriptList(@RequestBody ListCountVO Vo) {
		log.info("Inside dashboard getManuScriptList");
		JSONObject obj = new JSONObject();

		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		for (int i = 0; i < manuScriptList.size(); i++) {

			String statusValue = manuScriptList.get(i).getStatusMaster().getStatusValue();
			// unsubmittedManuscripts && majorRevision && minorRevision
			if (statusValue.equalsIgnoreCase(Vo.getUnsubmittedManuscripts())
					|| statusValue.equalsIgnoreCase(Vo.getMajorRevision())
					|| statusValue.equalsIgnoreCase(Vo.getMinorRevision())) {

				obj.put("MyTask", manuScriptList);
			}
			// MANUSCRIPT SENT FOR acceptedByAdmin && declinedByAdmin && rejected
			if (statusValue.equalsIgnoreCase(Vo.getAcceptedByAdmin())
					|| statusValue.equalsIgnoreCase(Vo.getDeclinedByAdmin())
					|| statusValue.equalsIgnoreCase(Vo.getRejected())) {

				obj.put("Accepted/Rejected", manuScriptList);
			}
			// published List
			if (statusValue.equalsIgnoreCase(Vo.getPublished())
					|| statusValue.equalsIgnoreCase(Vo.getReadyForProduction())) {

				obj.put("Final", manuScriptList);
			}
			// newReviewerInvitation List
			if (statusValue.equalsIgnoreCase(Vo.getNewReviewerInvitation())) {

				obj.put("UnderReview", manuScriptList);
			}
		}
		return obj;
	}

	// Admin List for MyTask
	@RequestMapping(value = "/listMyTask", method = RequestMethod.GET)
	public ResponseEntity<?> getListMyTask() {
		log.info("Inside dashboard getListMyTask");
		List<StatusMasterVO> statusList = new ArrayList<StatusMasterVO>();
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		for (ManuScript manuScript : manuScriptList) {
			String manuSriptCode = manuScript.getStatusMaster().getStatusValue();

			if (manuSriptCode.equalsIgnoreCase("Unsubmitted Manuscripts")
					|| manuSriptCode.equalsIgnoreCase("Minor Revision")
					|| manuSriptCode.equalsIgnoreCase("Major Revision")) {

				List<StatusMaster> statuSmasterList = statusMasterService.getListByStatusValue(manuSriptCode);
				for (StatusMaster status : statuSmasterList) {
					StatusMasterVO vo = new StatusMasterVO();

					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					// vo.setJournalCode(manuScript.getJournal().getJournalCode());
					vo.setManuScriptCode(manuScript.getManuscriptCode());
					vo.setManuscriptId(manuScript.getManuScriptId());
					vo.setManuscriptTitle(manuScript.getManuscriptTitle());
					vo.setStatusDesc(manuScript.getStatusMaster().getStatusDesc());
					vo.setSubmittedon(formatter.format(manuScript.getSubmissionDate()));
					statusList.add(vo);
				}
			}
		}
		return new ResponseEntity<>(statusList, HttpStatus.OK);
	}

	// Admin List for Accepted/Rejected
	@RequestMapping(value = "/listAcceptedRejected", method = RequestMethod.GET)
	public ResponseEntity<?> getListunsubmittedManuscripts(@RequestBody ListCountVO Vo) {
		log.info("Inside dashboard getListunsubmittedManuscripts");
		List<StatusMasterVO> statusList = new ArrayList<StatusMasterVO>();
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		for (ManuScript manuScript : manuScriptList) {
			String manuSriptCode = manuScript.getStatusMaster().getStatusValue();
			// RE-SUBMITTED MANUSCRIPT

			if (manuSriptCode.equalsIgnoreCase(Vo.getDeclinedByAdmin())
					|| manuSriptCode.equalsIgnoreCase(Vo.getRejected())
					|| manuSriptCode.equalsIgnoreCase(Vo.getAcceptedByAdmin())
					|| manuSriptCode.equalsIgnoreCase(Vo.getDeclineRecommendation())) {
				List<StatusMaster> statuSmasterList = statusMasterService.getListByStatusValue(manuSriptCode);
				for (StatusMaster status : statuSmasterList) {
					StatusMasterVO vo = new StatusMasterVO();
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Journal journal = new Journal();
					vo.setJournalCode(journal.getJournalCode());
					vo.setManuscriptId(manuScript.getManuScriptId());
					vo.setManuscriptTitle(manuScript.getManuscriptTitle());
					vo.setSubmittedon(formatter.format(manuScript.getSubmissionDate()));
					statusList.add(vo);
				}
			}
		}
		return new ResponseEntity<>(statusList, HttpStatus.OK);
	}

	// Admin List for Accepted/Rejected
	@RequestMapping(value = "/listFinal", method = RequestMethod.GET)
	public ResponseEntity<?> getListFinal() {
		log.info("Inside dashboard getListFinal");
		List<StatusMasterVO> statusList = new ArrayList<StatusMasterVO>();
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		for (ManuScript manuScript : manuScriptList) {
			String manuSriptCode = manuScript.getStatusMaster().getStatusValue();
			// RE-SUBMITTED MANUSCRIPT
			if (manuSriptCode.equalsIgnoreCase("Published")) {
				List<StatusMaster> statuSmasterList = statusMasterService.getListByStatusValue(manuSriptCode);
				for (StatusMaster status : statuSmasterList) {
					StatusMasterVO vo = new StatusMasterVO();
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Journal journal = new Journal();
					vo.setJournalCode(journal.getJournalCode());
					vo.setManuscriptId(manuScript.getManuScriptId());
					vo.setManuscriptTitle(manuScript.getManuscriptTitle());
					vo.setSubmittedon(formatter.format(manuScript.getSubmissionDate()));
					statusList.add(vo);
				}
			}
		}
		return new ResponseEntity<>(statusList, HttpStatus.OK);
	}

	// Admin List for Accepted/Rejected
	@RequestMapping(value = "/underReviewList", method = RequestMethod.GET)
	public ResponseEntity<?> getReviewerList() {
		log.info("Inside dashboard getReviewerList");
		List<StatusMasterVO> statusList = new ArrayList<StatusMasterVO>();
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		for (ManuScript manuScript : manuScriptList) {
			String manuSriptCode = manuScript.getStatusMaster().getStatusValue();
			if (manuSriptCode.equalsIgnoreCase("New Reviewer Invitation")) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				StatusMasterVO vo = new StatusMasterVO();
				Journal journal = new Journal();
				vo.setManuscriptId(manuScript.getManuScriptId());
				vo.setManuscriptTitle(manuScript.getManuscriptTitle());
				vo.setSubmittedon(formatter.format(manuScript.getSubmissionDate()));
				vo.setJournalCode(journal.getJournalCode());
			}
		}

		return new ResponseEntity<>(statusList, HttpStatus.OK);
	}

	@RequestMapping(value = "/allList", method = RequestMethod.GET)
	public List<ManuScript> getAllList() {
		log.info("Inside dashboard getAllList");
		List<ManuScript> manuScriptList = manuScriptService.getManuScriptList();
		return manuScriptList;
	}

	@RequestMapping(value = "/listById", method = RequestMethod.POST)
	public ResponseEntity<?> getListById(@RequestBody ManuScript manuScript) {
		log.info("Inside dashboard getListById");
		if (manuScriptService.isExist(manuScript.getManuScriptId())) {
			List<ManuScript> manuScriptlist = manuScriptService.getManuScriptListById(manuScript.getManuScriptId());
			return new ResponseEntity<>(manuScriptlist, HttpStatus.OK);
		}

		return new ResponseEntity<>(new CustomErrorType("Id not found"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/reviewerCount", method = RequestMethod.POST)
	public ResponseEntity<?> reviewerDashboard(@RequestBody IDVO vo) {
		log.info("Inside dashboard reviewerDashboard");
		List<ManuScript> listInvitation = manuScriptService.reviewerInvitationList(vo.getId());
		List<ManuScript> listReview = manuScriptService.reviewerReviewList(vo.getId());
		List<ManuScript> listRevision = manuScriptService.reviewerRevisionList(vo.getId());
		List<ManuScript> listCompleted = manuScriptService.reviewerCompletedList(vo.getId());
		int size = listInvitation.size() + listReview.size() + listRevision.size() + listCompleted.size();
		DashboardCountVO dashboardCountVO = new DashboardCountVO();
		dashboardCountVO.setInvitationCount(listInvitation.size());
		dashboardCountVO.setReviewCount(listReview.size());
		dashboardCountVO.setRevisionCount(listRevision.size());
		dashboardCountVO.setCompletedCount(listCompleted.size());

		return new ResponseEntity<>(dashboardCountVO, HttpStatus.OK);
	}

	@RequestMapping(value = "/reviewerInvitationList", method = RequestMethod.POST)
	public ResponseEntity<?> reviewerInvitationList(@RequestBody IDVO vo) {
		log.info("Inside dashboard reviewerInvitationList");
		try {
			List<ManuScript> listInvitation = manuScriptService.reviewerInvitationList(vo.getId());
			return new ResponseEntity<>(listInvitation, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		obj.put("message", "Something went wrong");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/reviewerReviewList", method = RequestMethod.POST)
	public ResponseEntity<?> reviewerReviewList(@RequestBody IDVO vo) {
		log.info("Inside dashboard reviewerReviewList");
		List<ManuScript> listReview = manuScriptService.reviewerReviewList(vo.getId());
		return new ResponseEntity<>(listReview, HttpStatus.OK);
	}

	@RequestMapping(value = "/reviewerRevisionList", method = RequestMethod.POST)
	public ResponseEntity<?> reviewerRevisionList(@RequestBody IDVO vo) {
		log.info("Inside dashboard reviewerRevisionList");
		List<ManuScript> listRevision = manuScriptService.reviewerRevisionList(vo.getId());
		return new ResponseEntity<>(listRevision, HttpStatus.OK);
	}

	@RequestMapping(value = "/reviewerCompletedList", method = RequestMethod.POST)
	public ResponseEntity<?> reviewerCompletedList(@RequestBody IDVO vo) {
		log.info("Inside dashboard reviewerCompletedList");
		List<ManuScript> listCompleted = manuScriptService.reviewerCompletedList(vo.getId());
		return new ResponseEntity<>(listCompleted, HttpStatus.OK);
	}

	@RequestMapping(value = "/reviewerAccept", method = RequestMethod.POST)
	public ResponseEntity<?> reviewerAccept(@RequestBody IDVO vo) {
		log.info("Inside dashboard reviewerAccept");
		manuScriptService.reviewerAccept(vo);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);

	}

	@RequestMapping(value = "/reviewerReject", method = RequestMethod.POST)
	public ResponseEntity<?> reviewerReject(@RequestBody IDVO vo) {
		log.info("Inside dashboard reviewerReject");
		manuScriptService.reviewerReject(vo);
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

	/***** Author Dashboard ******/
	@RequestMapping(value = "/authorCount", method = RequestMethod.POST)
	public ResponseEntity<?> authorCount(@RequestBody IDVO vo) {
		log.info("Inside dashboard authorCount");
		List<AuthorDashboardVO> taskList = manuScriptService.authorTask(vo.getId());
		List<AuthorDashboardVO> reviewList = manuScriptService.authorUnderReview(vo.getId());
		List<AuthorDashboardVO> acceptList = manuScriptService.authorManuscriptAccepted(vo.getId());
		List<AuthorDashboardVO> rejectList = manuScriptService.authorManuscriptRejected(vo.getId());
		JSONObject obj = new JSONObject();
		obj.put("tasksize", taskList.size());
		obj.put("reviewList", reviewList.size());
		obj.put("acceptList", acceptList.size());
		obj.put("rejectList", rejectList.size());
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/authorTask", method = RequestMethod.POST)
	public ResponseEntity<?> authorTask(@RequestBody IDVO vo) {
		log.info("Inside dashboard authorTask");
		List<AuthorDashboardVO> list = manuScriptService.authorTask(vo.getId());
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "/authorUnderReview", method = RequestMethod.POST)
	public ResponseEntity<?> authorUnderReview(@RequestBody IDVO vo) {
		log.info("Inside dashboard authorUnderReview");
		List<AuthorDashboardVO> list = manuScriptService.authorUnderReview(vo.getId());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/authorManuscriptAccepted", method = RequestMethod.POST)
	public ResponseEntity<?> authorManuscriptAccepted(@RequestBody IDVO vo) {
		log.info("Inside dashboard authorManuscriptAccepted");
		List<AuthorDashboardVO> list = manuScriptService.authorManuscriptAccepted(vo.getId());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/authorManuscriptRejected", method = RequestMethod.POST)
	public ResponseEntity<?> authorManuscriptRejected(@RequestBody IDVO vo) {
		log.info("Inside dashboard authorManuscriptRejected");
		List<AuthorDashboardVO> list = manuScriptService.authorManuscriptRejected(vo.getId());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/***** Editor Dashboard *******/

	@RequestMapping(value = "/editorSubmitted", method = RequestMethod.POST)
	public ResponseEntity<?> editorSubmitted(@RequestBody IDVO vo) {
		log.info("Inside dashboard editorSubmitted");
		JSONObject obj = new JSONObject();

		List<User> userList = userService.getUserListById(vo.getId());

		List<Groups> list = userList.get(0).getGroup();
		List<EditorDashboardVO> resultData = new ArrayList<>();

		if (list != null) {
			for (Groups groupList : list) {
				JournalEditorMapping journalEditorMappingData = journalEditorMappingService
						.getJournalEditorMappingById(groupList.getId());
				if (journalEditorMappingData != null) {
					List<ManuScript> invitaionList = manuScriptService
							.getEditorSubmitted(journalEditorMappingData.getJournalId());

					if (!invitaionList.isEmpty()) {
						for (ManuScript manuScript : invitaionList) {
							EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
							editorDashboardVO.setManuscriptId(manuScript.getManuScriptId());
							editorDashboardVO.setManuscriptTitle(manuScript.getManuscriptTitle());
							editorDashboardVO.setSubmittedDate(manuScript.getSubmissionDate());
							editorDashboardVO.setManuscriptCode(manuScript.getManuscriptCode());
							resultData.add(editorDashboardVO);
						}
						obj.put("data", resultData);
					}
				}

			}
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

		obj.put("data", "Data not found");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/editorReSubmitted", method = RequestMethod.POST)
	public ResponseEntity<?> editorReSubmitted(@RequestBody IDVO vo) {
		log.info("Inside dashboard editorReSubmitted");
		JSONObject obj = new JSONObject();
		List<User> userList = userService.getUserListById(vo.getId());

		List<Groups> list = userList.get(0).getGroup();
		List<EditorDashboardVO> resultData = new ArrayList<>();

		if (list != null) {
			for (Groups groupList : list) {
				JournalEditorMapping journalEditorMappingData = journalEditorMappingService
						.getJournalEditorMappingById(groupList.getId());
				if (journalEditorMappingData != null) {
					List<ManuScript> invitaionList = manuScriptService
							.getEditorReSubmitted(journalEditorMappingData.getJournalId());

					if (!invitaionList.isEmpty()) {
						for (ManuScript manuScript : invitaionList) {
							EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
							editorDashboardVO.setManuscriptId(manuScript.getManuScriptId());
							editorDashboardVO.setManuscriptTitle(manuScript.getManuscriptTitle());
							editorDashboardVO.setSubmittedDate(manuScript.getSubmissionDate());
							editorDashboardVO.setManuscriptCode(manuScript.getManuscriptCode());
							resultData.add(editorDashboardVO);
						}
						obj.put("data", resultData);
					}
				}

			}
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Data not found");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/editorSentForReview", method = RequestMethod.POST)
	public ResponseEntity<?> editorSentForReview(@RequestBody IDVO vo) {
		log.info("Inside dashboard editorSentForReview");
		JSONObject obj = new JSONObject();

		List<ManuScriptReviewer> invitaionList = manuScriptService.getEditorSentForReview(vo.getId());
		List<EditorDashboardVO> data = new ArrayList<>();
		if (invitaionList != null) {
			for (ManuScriptReviewer list : invitaionList) {
				EditorDashboardVO m = new EditorDashboardVO();
				m.setManuscriptId(list.getManuscript().getManuScriptId());
				m.setManuscriptTitle(list.getManuscript().getManuscriptTitle());
				m.setSubmittedDate(list.getManuscript().getSubmissionDate());
				m.setManuscriptCode(list.getManuscript().getManuscriptCode());
				data.add(m);
			}
			obj.put("data", data);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}

		obj.put("data", "Data not found");
		return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/editorGetAll", method = RequestMethod.POST)
	public ResponseEntity<?> editorGetAll(@RequestBody IDVO vo) {
		log.info("Inside dashboard editorGetAll");
		JSONObject obj = new JSONObject();

		List<ManuScriptReviewer> invitaionList = manuScriptService.getEditorAllList(vo.getId());
		List<EditorDashboardVO> data = new ArrayList<>();
		if (invitaionList != null) {
			for (ManuScriptReviewer list : invitaionList) {
				EditorDashboardVO m = new EditorDashboardVO();
				m.setManuscriptId(list.getManuscript().getManuScriptId());
				m.setManuscriptTitle(list.getManuscript().getManuscriptTitle());
				m.setSubmittedDate(list.getManuscript().getSubmissionDate());
				m.setManuscriptCode(list.getManuscript().getManuscriptCode());
				data.add(m);
			}
			obj.put("data", data);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Data not found");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/getManuscriptByDataById", method = RequestMethod.POST)
	public ResponseEntity<?> getManuscriptByData(@RequestBody UserJournalManuscriptVo userJournalManuscriptVo) {
		log.info("Inside dashboard getManuscriptByData");
		JSONObject obj = new JSONObject();
		try {
			List<EditorDashboardVO> resultData = manuScriptService.getManuscriptByData(userJournalManuscriptVo);
			if (resultData != null) {
				obj.put("data", resultData);
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else {
				obj.put("data", "Data not found");
				return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}

	}
	
	@RequestMapping(value = "/getAssignedManuscriptData", method = RequestMethod.POST)
	public ResponseEntity<?> getAssignedManuscriptData(@RequestBody UserJournalManuscriptVo userJournalManuscriptVo) {
		log.info("Inside dashboard getAssignedManuscriptData");
		JSONObject obj = new JSONObject();
		try {
			List<EditorDashboardVO> resultData = manuScriptService.getAssignedManuscriptData(userJournalManuscriptVo);
			if (resultData != null) {
				obj.put("data", resultData);
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else {
				obj.put("data", "Data not found");
				return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}

	}
	
	@PostMapping("getReviewerDecision")
	public ResponseEntity<?> getReviewerDecision(@RequestBody UserJournalManuscriptVo userJournalManuscriptVo){
		log.info("Inside dashboard getReviewerDecision");
		JSONObject obj = new JSONObject();
		try {
			List<ReviewerDecisionVO> lst = manuScriptService.getReviewerDecision(userJournalManuscriptVo);
			obj.put("data", lst);
		}catch(Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	

}