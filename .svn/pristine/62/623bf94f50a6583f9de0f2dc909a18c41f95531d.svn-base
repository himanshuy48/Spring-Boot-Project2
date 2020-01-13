package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.AuthorDashboardVO;
import com.digi.uniprr.VO.EditorDashboardVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManagingEditorVO;
import com.digi.uniprr.VO.ManuScriptVO;
import com.digi.uniprr.VO.ManuscriptCoAuthorVO;
import com.digi.uniprr.VO.ManuscriptEditorVO;
import com.digi.uniprr.VO.ManuscriptKeywordsVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ManuscriptManagingEditorVO;
import com.digi.uniprr.VO.ManuscriptTypeJournalVO;
import com.digi.uniprr.VO.ManuscriptTypeTitleAbstractVO;
import com.digi.uniprr.VO.ReviewerDataWithCommentVO;
import com.digi.uniprr.VO.ReviewerDecisionVO;
import com.digi.uniprr.VO.ReviewerStatusData;
import com.digi.uniprr.VO.UserJournalManuscriptVo;
import com.digi.uniprr.model.Journal;
import com.digi.uniprr.model.Keywords;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptCoAuthor;
import com.digi.uniprr.model.ManuScriptKeywords;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptEditor;
import com.digi.uniprr.model.ManuscriptManagingEditor;
import com.digi.uniprr.model.ManuscriptTypeDetails;
import com.digi.uniprr.model.ManuscriptTypeJournal;
import com.digi.uniprr.model.StatusMaster;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.CountriesRepo;
import com.digi.uniprr.repository.JournalsRepo;
import com.digi.uniprr.repository.KeywordsRepo;
import com.digi.uniprr.repository.ManuScriptCoAuthorRepo;
import com.digi.uniprr.repository.ManuScriptKeywordsRepo;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.ManuScriptReviewerRepo;
import com.digi.uniprr.repository.ManuscriptEditorCommentsRepo;
import com.digi.uniprr.repository.ManuscriptEditorRepo;
import com.digi.uniprr.repository.ManuscriptManagingEditorRepo;
import com.digi.uniprr.repository.ManuscriptReviewerCommentsRepo;
import com.digi.uniprr.repository.ManuscriptTypeDetailsRepo;
import com.digi.uniprr.repository.ManuscriptTypeJournalsRepo;
import com.digi.uniprr.repository.RoleRepo;
import com.digi.uniprr.repository.StatusMasterRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ManuScriptReviewerService;
import com.digi.uniprr.service.ManuScriptService;
import com.digi.uniprr.service.ManuscriptEditorService;
import com.digi.uniprr.utils.KeywordsTransformationUtils;
import com.digi.uniprr.utils.ManuscriptCoAuthorTransformationUtils;
import com.digi.uniprr.utils.ManuscriptKeywordsTransformationUtils;
import com.digi.uniprr.utils.ManuscriptTypeJournalTransformationUtils;

@Service
@Transactional
public class ManuScriptServiceImpl implements ManuScriptService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JournalsRepo journalsRepo;

	@Autowired
	KeywordsRepo keywordsRepo;

	@Autowired
	ManuScriptKeywordsRepo manuscriptKeywordsRepo;

	@Autowired
	ManuScriptRepo manuScriptRepo;

	@Autowired
	ManuscriptEditorCommentsRepo manuscriptEditorCommentsRepo;

	@Autowired
	ManuScriptReviewerRepo manuScriptReviewerRepo;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	ManuscriptEditorService manuscriptEditorService;

	@Autowired
	ManuScriptReviewerService manuScriptReviewerService;

	@Autowired
	StatusMasterRepo statusMasterRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ManuscriptTypeDetailsRepo manuscriptTypeDetailsRepo;

	@Autowired
	ManuScriptCoAuthorRepo manuScriptCoAuthorRepo;

	@Autowired
	ManuscriptTypeJournalsRepo manuscriptTypeJournalsRepo;

	@Autowired
	ManuscriptManagingEditorRepo manuscriptManagingEditorRepo;

	@Autowired
	ManuscriptEditorRepo manuscriptEditorRepo;

	@Autowired
	ManuscriptReviewerCommentsRepo manuscriptReviewerCommentsRepo;

	@Autowired
	CountriesRepo countriesRepo;

	JSONObject obj = new JSONObject();

	@Override
	public List<ManuScript> getManuScriptList() {
		return manuScriptRepo.findAll();
	}

	@Override
	public ManuScript createManuScript(ManuScript manuScript) {
		Journal journal = journalsRepo.getOne(manuScript.getJournalId());
		manuScript.setManuscriptStatusId(1);
		manuScript.setManuscriptVersion(0);
		manuScript.setIsActive(0);
		Integer countryId = userRepo.getOne(manuScript.getAuthorId()).getCountryId();
		
		if (countryId != null) {
			String countryName = countriesRepo.getOne(countryId).getName();
			manuScript.setManuscriptOrigin(countryName);
		}
		
		ManuScript manusScriptSaved = manuScriptRepo.save(manuScript);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		manusScriptSaved.setManuscriptCode(
				journal.getJournalCode() + manusScriptSaved.getManuScriptId() + calendar.get(Calendar.DAY_OF_MONTH) + ""
						+ (calendar.get(Calendar.MONTH) + 1) + "" + calendar.get(Calendar.YEAR));
		manuScriptRepo.save(manusScriptSaved);
		return manuScript;
	}

	@Override
	public String updateManuScript(ManuScript manuScript) {
		manuScriptRepo.save(manuScript);
		return "Updated successfully";
	}

	@Override
	public String deleteManuScriptById(Integer id) {
		manuScriptRepo.deleteById(id);
		return "Deleted successfully";
	}

	@Override
	public boolean isExist(Integer id) {
		return manuScriptRepo.existsById(id);
	}

	@Override
	public List<ManuScript> getManuScriptListById(Integer id) {
		return manuScriptRepo.getManuScripById(id);
	}

	@Override
	public void updateStage(ManuScript manuScript) {
		manuScriptRepo.updateStage(manuScript.getStatusMaster().getId(), manuScript.getManuScriptId());

	}

	@Override
	public List<ManuScript> getListByStatusId(Integer manuscriptStatus) {
		return manuScriptRepo.getListByStatusId(manuscriptStatus);
	}

	@Override
	public List<ManuScript> trackManuScript(Integer id) {
		return manuScriptRepo.trackManuScript(id);
	}

	@Override
	public List<ManuScript> gettrackManuScriptList(Integer id, Integer journalId, Date submissionDate) {
		return manuScriptRepo.gettrackManuScript(id, journalId, submissionDate);
	}

	@Override
	public List<ManuScript> gettrackManuScriptListDate(String submissionDateTo, String submissionDateFrom) {
		return manuScriptRepo.gettrackManuScriptDate(submissionDateTo, submissionDateFrom);
	}

	@Override
	public List<ManuScript> gettrackManuScriptListTitle(String manuscriptTitle) {
		return manuScriptRepo.gettrackManuScriptTitle(manuscriptTitle);
	}

	@Override
	public List<ManuScript> gettrackManuScriptListCode(String manuscriptCode) {
		return manuScriptRepo.gettrackManuScriptCode(manuscriptCode);
	}

	@Override
	public List<ManuScript> gettrackManuScriptJtitle(String journalTitle) {
		return manuScriptRepo.gettrackJTitle(journalTitle);
	}

	@Override
	public List<ManuScript> getAllManuScriptRecord() {
		return manuScriptRepo.findAll();
	}

	@Override
	public List<ManuScript> reviewerInvitationList(Integer reviewerId) {
		return manuScriptRepo.reviewerInvitationList(reviewerId);
	}

	@Override
	public List<ManuScript> reviewerReviewList(Integer reviewerId) {
		return manuScriptRepo.reviewerReviewList(reviewerId);
	}

	@Override
	public List<ManuScript> reviewerRevisionList(Integer reviewerId) {
		return manuScriptRepo.reviewerRevisionList(reviewerId);
	}

	@Override
	public List<ManuScript> reviewerCompletedList(Integer reviewerId) {
		return manuScriptRepo.reviewerCompletedList(reviewerId);
	}

	@Override
	public void reviewerAccept(IDVO vo) {
		manuScriptRepo.reviewerAccept(vo.getId());
	}

	@Override
	public void reviewerReject(IDVO vo) {
		manuScriptRepo.rejectReviewer(vo.getId());

	}

	@Override
	public List<AuthorDashboardVO> authorTask(Integer authorId) {
		List<ManuScript> list = manuScriptRepo.authorTask(authorId);
		List<AuthorDashboardVO> authorDashboardVOList = mapAuthorDashboardProperties(list);
		return authorDashboardVOList;
	}

	@Override
	public List<AuthorDashboardVO> authorUnderReview(Integer authorId) {
		List<ManuScript> list = manuScriptRepo.authorUnderReview(authorId);
		List<AuthorDashboardVO> authorDashboardVOList = mapAuthorDashboardProperties(list);
		return authorDashboardVOList;
	}

	@Override
	public List<AuthorDashboardVO> authorManuscriptAccepted(Integer authorId) {
		List<ManuScript> list = manuScriptRepo.authorManuscriptAccepted(authorId);
		List<AuthorDashboardVO> authorDashboardVOList = mapAuthorDashboardProperties(list);
		return authorDashboardVOList;
	}

	@Override
	public List<AuthorDashboardVO> authorManuscriptRejected(Integer authorId) {
		List<ManuScript> list = manuScriptRepo.authorManuscriptRejected(authorId);
		List<AuthorDashboardVO> authorDashboardVOList = mapAuthorDashboardProperties(list);
		return authorDashboardVOList;
	}

	public List<AuthorDashboardVO> mapAuthorDashboardProperties(List<ManuScript> list) {
		List<AuthorDashboardVO> voList = new ArrayList<AuthorDashboardVO>();
		for (ManuScript manuScript : list) {
			AuthorDashboardVO vo = new AuthorDashboardVO();
			vo.setManuscriptId(manuScript.getManuScriptId());
// vo.setJournalCode(manuScript.getJournal().getJournalCode());
			vo.setManuscriptCode(manuScript.getManuscriptCode());
			vo.setManuscriptTitle(manuScript.getManuscriptTitle());
			vo.setCreatedOn(manuScript.getCreatedOn());
			vo.setManuscriptStatus(manuScript.getStatusMaster().getStatusDesc());
			voList.add(vo);
		}

		return voList;
	}

// Editor Dashboard
	@Override
	public List<ManuScript> getEditorSubmitted(Integer id) {
		return manuScriptRepo.getEditorSubmitted(id);
	}

	@Override
	public List<ManuScript> getEditorReSubmitted(Integer id) {

		return manuScriptRepo.getEditorReSubmitted(id);
	}

	@Override
	public List<ManuScriptReviewer> getEditorSentForReview(Integer id) {
		return manuScriptRepo.getEditorSentForReview(id);
	}

	@Override
	public List<ManuScriptReviewer> getEditorAllList(Integer id) {
		return manuScriptRepo.getEditorAllList(id);
	}

	@Override
	public String updateManuScriptEditor(ManuscriptEditorVO manuscriptEditorVO) {
		if (manuscriptEditorVO.getStatusCode().equals("18") || manuscriptEditorVO.getStatusCode().equals("33")) {
			manuscriptEditorCommentsRepo.updateManuScriptEditorComments(manuscriptEditorVO.getManuscriptId(),
					manuscriptEditorVO.getManuscriptVersion(), manuscriptEditorVO.getStatusCode(),
					manuscriptEditorVO.getComments());
			manuScriptRepo.updateManuScriptEditor(manuscriptEditorVO.getManuscriptId(),
					manuscriptEditorVO.getManuscriptVersion(), manuscriptEditorVO.getStatusCode());
			manuScriptReviewerRepo.updateManuScriptEditorReviewer(manuscriptEditorVO.getManuscriptId(),
					manuscriptEditorVO.getManuscriptVersion(), 0);
			return "ManuScript Editor Updated Successfully";
		} else {
			manuScriptRepo.updateManuScriptStatusById(manuscriptEditorVO.getManuscriptId(),
					manuscriptEditorVO.getStatusCode());
			return "ManuScript Updated Successfully";
		}
	}

	@Override
	public List<ManuScript> getUniqueManuScript(Integer journalId) {
		return manuScriptRepo.getUniqueManuScript(journalId);
	}

	@Override
	public List<ManuscriptListVO> getManuscriptByStatus(ManuscriptListVO manuscriptVO) {
		List<ManuscriptListVO> newList = new ArrayList<>();
		for (Integer mStatus : manuscriptVO.getManuscriptStatusId()) {
			List<ManuScript> list = manuScriptRepo.getManuscriptByStatus(mStatus, manuscriptVO.getJournalId());
			StatusMaster statusCode = statusMasterRepo.getOne(mStatus);
			if (list != null) {
				for (ManuScript data : list) {
					List<ManuscriptTypeDetails> manuScriptType = manuscriptTypeDetailsRepo
							.getManuscriptTypeDetailsById(data.getManuScriptId());
					User user = userRepo.getOne(data.getAuthorId());
					ManuscriptListVO manuscriptListVO = new ManuscriptListVO();
					manuscriptListVO.setJournalId(data.getJournalId());
					manuscriptListVO.setManuscripCode(data.getManuscriptCode());
					manuscriptListVO.setManuscriptAuthorId(data.getAuthorId());
					manuscriptListVO.setManuscripTitle(data.getManuscriptTitle());
					manuscriptListVO.setManuScriptId(data.getManuScriptId());
					manuscriptListVO.setManuscriptVersion(data.getManuscriptVersion());
					manuscriptListVO.setSubmissionDate(data.getSubmissionDate());
					manuscriptListVO.setSubmittedBy(data.getSubmittedBy());
					manuscriptListVO.setCreatedBy(data.getCreatedBy());
					manuscriptListVO.setCreatedOn(data.getCreatedOn());
					manuscriptListVO.setUpdatedBy(data.getUpdatedBy());
					manuscriptListVO.setUpdatedOn(data.getUpdatedOn());
					manuscriptListVO.setManuStatusCode(statusCode.getStatusValue());
					manuscriptListVO.setAuthorName(user.getFirstName() + " " + user.getLastName());
					manuscriptListVO.setJournalTitle(data.getJournal().getJournalTitle());
					manuscriptListVO.setJournalCode(data.getJournal().getJournalCode());
					manuscriptListVO.setManuStatusId(mStatus);
					if (manuScriptType != null && !manuScriptType.isEmpty()) {
						manuscriptListVO.setManuScriptType(manuScriptType.get(0).getManuscriptType());
					}

					List<ManuscriptManagingEditor> manuscriptManagingEditor = manuscriptManagingEditorRepo
							.getByJournalAndManuscriptId(data.getManuScriptId(), data.getJournalId());
					if (manuscriptManagingEditor != null && !manuscriptManagingEditor.isEmpty()) {
						List<ManuscriptManagingEditorVO> mmeVoList = new ArrayList<>();
						for (ManuscriptManagingEditor mme : manuscriptManagingEditor) {
							User managingEditor = userRepo.getOne(data.getAuthorId());
							ManuscriptManagingEditorVO mmeVO = new ManuscriptManagingEditorVO();
							mmeVO.setUserId(mme.getUserId());
							mmeVO.setName(managingEditor.getFirstName() + " " + managingEditor.getLastName());
							mmeVoList.add(mmeVO);

						}
						manuscriptListVO.setManagingEditor(mmeVoList);
					}

					List<ManuscriptEditor> me = manuscriptEditorRepo.getByJournalAndManuscript(data.getManuScriptId(),
							data.getJournalId());
					if (me != null && !me.isEmpty()) {
						List<ManagingEditorVO> meVOList = new ArrayList<>();
						for (ManuscriptEditor meData : me) {
							User editor = userRepo.getOne(data.getAuthorId());
							ManagingEditorVO meVO = new ManagingEditorVO();
							meVO.setEditorId(meData.getEditorId());
							meVO.setName(editor.getFirstName() + " " + editor.getLastName());
							meVOList.add(meVO);
						}
						manuscriptListVO.setEditorList(meVOList);
					}
					newList.add(manuscriptListVO);
				}
			}
		}
		return newList;
	}

	@Override
	public List<EditorDashboardVO> getManuscriptByData(UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ManuScript> manuScriptList = new ArrayList<>();
		List<EditorDashboardVO> newList = new ArrayList<>();
		Journal journalCode = journalsRepo.getOne(userJournalManuscriptVo.getJournalId());
		if (userJournalManuscriptVo.getRoleId() == 3) {
			List<ManuscriptEditor> dataList = manuscriptEditorService.getManuscriptEditor(userJournalManuscriptVo);
			if (dataList != null) {
				for (ManuscriptEditor editordata : dataList) {
					StatusMaster statusdDetail = statusMasterRepo.getOne(editordata.getManuscriptStatus());
					User user = userRepo.getOne(editordata.getEditorId());
					Integer manuscriptId = editordata.getManuscriptId();
					List<ManuScript> manuscriptData = getManuScriptListById(manuscriptId);
					if (manuscriptData != null) {
						for (ManuScript data : manuscriptData) {
							List<ManuscriptTypeDetails> manuScriptType = manuscriptTypeDetailsRepo
									.getManuscriptTypeDetailsById(data.getManuScriptId());
							EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
							editorDashboardVO.setManuscriptId(data.getManuScriptId());
							editorDashboardVO.setManuscriptCode(data.getManuscriptCode());
							editorDashboardVO.setManuscriptTitle(data.getManuscriptTitle());
							editorDashboardVO.setSubmittedDate(data.getSubmissionDate());
							editorDashboardVO.setJournalCode(journalCode.getJournalCode());
							editorDashboardVO.setJournalTitle(journalCode.getJournalTitle());
							editorDashboardVO.setStatusId(statusdDetail.getId());
							editorDashboardVO.setStatusValue(statusdDetail.getStatusValue());
							editorDashboardVO.setManuscriptVersion(data.getManuscriptVersion());
							editorDashboardVO.setAuthorName(user.getFirstName() + " " + user.getLastName());
							editorDashboardVO.setAuthorId(user.getId());
							if (manuScriptType != null && !manuScriptType.isEmpty()) {
								editorDashboardVO.setManuscriptType(manuScriptType.get(0).getManuscriptType());

							}
							newList.add(editorDashboardVO);
						}
					}
				}
			}
		} else if (userJournalManuscriptVo.getRoleId() == 5) {
			List<ManuScriptReviewer> dataList = manuScriptReviewerService
					.getManuscriptReviewer(userJournalManuscriptVo);
			if (dataList != null) {
				for (ManuScriptReviewer reviewerData : dataList) {
					List<ManuScript> manuscriptData = getManuScriptListById(reviewerData.getManuscriptId());
					StatusMaster statusMasterValue = statusMasterRepo
							.getStatusMaster(reviewerData.getManuscriptStatus());
					if (manuscriptData != null) {
						for (ManuScript data : manuscriptData) {
							List<ManuscriptTypeDetails> manuScriptType = manuscriptTypeDetailsRepo
									.getManuscriptTypeDetailsById(data.getManuScriptId());
							EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
							editorDashboardVO.setManuscriptId(data.getManuScriptId());
							editorDashboardVO.setManuscriptCode(data.getManuscriptCode());
							editorDashboardVO.setManuscriptTitle(data.getManuscriptTitle());
							editorDashboardVO.setSubmittedDate(data.getSubmissionDate());
							editorDashboardVO.setJournalCode(journalCode.getJournalCode());
							editorDashboardVO.setJournalTitle(journalCode.getJournalTitle());
							editorDashboardVO.setStatusId(data.getStatusMaster().getId());
							editorDashboardVO.setStatusValue(data.getStatusMaster().getStatusValue());
							editorDashboardVO.setManuscriptVersion(data.getManuscriptVersion());
							editorDashboardVO.setAuthorId(data.getUser().getId());
							editorDashboardVO
									.setAuthorName(data.getUser().getFirstName() + " " + data.getUser().getLastName());
							if (manuScriptType != null && !manuScriptType.isEmpty()) {
								editorDashboardVO.setManuscriptType(manuScriptType.get(0).getManuscriptType());
							}
							editorDashboardVO.setAssignedDate(reviewerData.getAssignedDate());
							editorDashboardVO.setUnassignedDate(reviewerData.getUnassignedDate());
							editorDashboardVO.setStartDate(reviewerData.getStartDate());
							editorDashboardVO.setCompleteDate(reviewerData.getCompleteDate());
							editorDashboardVO.setRejectDate(reviewerData.getRejectDate());
							editorDashboardVO.setAcceptDate(reviewerData.getAcceptDate());
							editorDashboardVO.setDueDate(reviewerData.getDueDate());
							editorDashboardVO.setStatusValueForUser(statusMasterValue.getStatusValue());
							newList.add(editorDashboardVO);
						}
					}
				}
			}
		}

		else if (userJournalManuscriptVo.getRoleId() == 4) {
			List<ManuScript> list = manuScriptRepo.authorDashboardData(userJournalManuscriptVo.getUserId(),
					userJournalManuscriptVo.getManuscriptStatusId());

			if (list != null && !list.isEmpty()) {
				for (ManuScript data : list) {
					EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
					editorDashboardVO.setManuscriptId(data.getManuScriptId());
					editorDashboardVO.setManuscriptCode(data.getManuscriptCode());
					editorDashboardVO.setManuscriptTitle(data.getManuscriptTitle());
					editorDashboardVO.setSubmittedDate(data.getSubmissionDate());
					editorDashboardVO.setJournalCode(data.getJournal().getJournalCode());
					editorDashboardVO.setJournalTitle(data.getJournal().getJournalTitle());
					editorDashboardVO.setStatusId(data.getStatusMaster().getId());
					editorDashboardVO.setStatusValue(data.getStatusMaster().getStatusValue());
					editorDashboardVO.setManuscriptVersion(data.getManuscriptVersion());
					editorDashboardVO.setAuthorName(data.getUser().getFirstName() + " " + data.getUser().getLastName());

					ManuscriptTypeDetails detail = manuscriptTypeDetailsRepo
							.getDetailsFromManuscriptId(data.getManuScriptId());
					if (detail != null)
						editorDashboardVO.setManuscriptType(detail.getManuscriptType());

					newList.add(editorDashboardVO);
				}
			}
		}

		else {
			manuScriptList = getDataFromManuScript(userJournalManuscriptVo);
			if (manuScriptList != null) {
				for (ManuScript data : manuScriptList) {
					List<ManuscriptTypeDetails> manuScriptType = manuscriptTypeDetailsRepo
							.getManuscriptTypeDetailsById(data.getManuScriptId());
					StatusMaster statusdDetail = statusMasterRepo.getOne(data.getManuscriptStatusId());
					User user = userRepo.getOne(data.getAuthorId());
					EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
					editorDashboardVO.setManuscriptId(data.getManuScriptId());
					editorDashboardVO.setManuscriptCode(data.getManuscriptCode());
					editorDashboardVO.setManuscriptTitle(data.getManuscriptTitle());
					editorDashboardVO.setSubmittedDate(data.getSubmissionDate());
					editorDashboardVO.setJournalCode(journalCode.getJournalCode());
					editorDashboardVO.setJournalTitle(journalCode.getJournalTitle());
					editorDashboardVO.setStatusId(statusdDetail.getId());
					editorDashboardVO.setStatusValue(statusdDetail.getStatusValue());
					editorDashboardVO.setManuscriptVersion(data.getManuscriptVersion());
					editorDashboardVO.setAuthorName(user.getFirstName() + " " + user.getLastName());
					if (manuScriptType != null && !manuScriptType.isEmpty()) {
						editorDashboardVO.setManuscriptType(manuScriptType.get(0).getManuscriptType());
					}
					newList.add(editorDashboardVO);
				}
			}
		}

		return newList;
	}

	public List<ManuScript> getDataFromManuScript(UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ManuScript> dataList = new ArrayList<>();
		for (Integer statusList : userJournalManuscriptVo.getManuscriptStatusId()) {

			List<ManuScript> list = new ArrayList<>();
			Integer status = statusList;
			list = manuScriptRepo.getManuScriptDataByID(userJournalManuscriptVo.getUserId(),
					userJournalManuscriptVo.getJournalId(), status);
			if (list != null && !list.isEmpty()) {
				dataList.add(list.get(0));
			}
		}

		return dataList;
	}

	@Override
	public List<EditorDashboardVO> getAssignedManuscriptData(UserJournalManuscriptVo userJournalManuscriptVo) {
		List<EditorDashboardVO> newList = new ArrayList<>();
		if (userJournalManuscriptVo.getRoleId() != null && userJournalManuscriptVo.getRoleId() == 3) {
			List<ManuscriptEditor> manuScriptIdByEditor = manuscriptEditorService
					.getManuscriptEditorListById(userJournalManuscriptVo);
			for (ManuscriptEditor data : manuScriptIdByEditor) {
				Integer mID = data.getManuscriptId();
				StatusMaster statusdDetail = statusMasterRepo.getOne(data.getManuscriptStatus());
				List<ManuScript> manuscriptData = getManuScriptListById(mID);
				if (manuscriptData != null) {
					for (ManuScript mdata : manuscriptData) {
						EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
						editorDashboardVO.setManuscriptId(mdata.getManuScriptId());
						editorDashboardVO.setManuscriptCode(mdata.getManuscriptCode());
						editorDashboardVO.setManuscriptTitle(mdata.getManuscriptTitle());
						editorDashboardVO.setSubmittedDate(mdata.getSubmissionDate());
						editorDashboardVO.setAuthorId(mdata.getUser().getId());
						editorDashboardVO.setAuthorName(mdata.getUser().getFirstName() + mdata.getUser().getLastName());
						editorDashboardVO.setStatusValue(mdata.getStatusMaster().getStatusValue());
						editorDashboardVO.setStatusValueForUser(statusdDetail.getStatusValue());
						editorDashboardVO.setManuscriptVersion(mdata.getManuscriptVersion());
						editorDashboardVO.setManuscriptType(mdata.getManuscriptTypeDetails().getManuscriptType());
						newList.add(editorDashboardVO);
					}
				}
			}
		} else if (userJournalManuscriptVo.getRoleId() != null && userJournalManuscriptVo.getRoleId() == 5) {
			List<ManuScriptReviewer> dataList = manuScriptReviewerService
					.getManuscriptReviewerListById(userJournalManuscriptVo);
			if (dataList != null) {
				for (ManuScriptReviewer reviewerData : dataList) {
					Integer manuscriptId = reviewerData.getManuscriptId();
					StatusMaster statusdDetail = statusMasterRepo.getOne(reviewerData.getManuscriptStatus());
					List<ManuScript> manuscriptData = getManuScriptListById(manuscriptId);
					if (manuscriptData != null) {
						for (ManuScript data : manuscriptData) {

							EditorDashboardVO editorDashboardVO = new EditorDashboardVO();
							editorDashboardVO.setManuscriptId(data.getManuScriptId());
							editorDashboardVO.setManuscriptCode(data.getManuscriptCode());
							editorDashboardVO.setManuscriptTitle(data.getManuscriptTitle());
							editorDashboardVO.setSubmittedDate(data.getSubmissionDate());
							editorDashboardVO.setAuthorId(data.getUser().getId());
							editorDashboardVO
									.setAuthorName(data.getUser().getFirstName() + data.getUser().getLastName());
							editorDashboardVO.setStatusValue(data.getStatusMaster().getStatusValue());
							editorDashboardVO.setStatusValueForUser(statusdDetail.getStatusValue());
							editorDashboardVO.setManuscriptVersion(data.getManuscriptVersion());
							if(data.getManuscriptTypeDetails()!=null) {
								editorDashboardVO.setManuscriptType(data.getManuscriptTypeDetails().getManuscriptType());
							}
							
							newList.add(editorDashboardVO);
						}
					}
				}
			}
		}
		return newList;
	}

	@Override
	public void saveManuscriptDetails(ManuScript manuscriptData) {
		manuScriptRepo.save(manuscriptData);
	}

	@Override
	public List<ManuscriptTypeJournalVO> getManuscriptTypeJournalListByJournalId(Integer manuscriptId) {
		log.info("Inside getManuscriptTypeJournalListByJournalId Impl");
		ManuScript manuscript = manuScriptRepo.getOne(manuscriptId);
		List<ManuscriptTypeJournal> list = manuscriptTypeJournalsRepo
				.getManuscriptTypesFromJournalId(manuscript.getJournalId());
		List<ManuscriptTypeJournalVO> voList = ManuscriptTypeJournalTransformationUtils.mapModelListToVOList(list);
		return voList;
	}

	@Override
	public ManuscriptTypeTitleAbstractVO getManuscriptTypeAbstractDetails(IDVO vo) {
		log.info("Inside getManuscriptTypeAbstractDetails Impl");
		ManuScript manuScript = manuScriptRepo.getOne(vo.getId());
		ManuscriptTypeDetails details = manuscriptTypeDetailsRepo.getDetailsFromManuscriptId(vo.getId());
		ManuscriptTypeTitleAbstractVO  vo1 = new ManuscriptTypeTitleAbstractVO();
		if (manuScript != null) {
			vo1.setManuscriptCode(manuScript.getManuscriptCode());
			vo1.setTitle(manuScript.getManuscriptTitle());
			vo1.setShortTitle(manuScript.getManuscriptShortTitle());
			vo1.setManuscriptAbstract(manuScript.getManuscriptAbstract());
			vo1.setManuscriptRegionOfOrigin(manuScript.getManuscriptOrigin());
			vo1.setManuscriptVersion(vo.getVersion());
		}
		if (details != null) {
			vo1.setManuscriptTypeJournal(details.getManuscriptType());
			vo1.setManuscriptWords(details.getManuscriptWords());
			vo1.setBlackAndWhiteFigures(details.getManuscriptBlackWhiteFigures());
			vo1.setManuscriptColorFigures(details.getManuscriptColorFigures());
			vo1.setManuscriptTables(details.getManuscriptTables());
			vo1.setManuscriptPages(details.getManuscriptPages());
		}
		List<Keywords> journalKeywords = keywordsRepo.getKeywordsByJournalId(manuScript.getJournalId());
		List<ManuScriptKeywords> manuscriptKeywordsList = manuscriptKeywordsRepo.getManuscriptKeywordsFromManuscriptId(vo.getId());
		List<Keywords> finalJournalKeywordList = new ArrayList<Keywords>();
		int flag = 0;
		for (Keywords keyword : journalKeywords) {
			flag = 0;
			for (ManuScriptKeywords mk : manuscriptKeywordsList)
				if (mk.getKeyId().equals(keyword.getId()))
					flag = 1;
			if (flag == 1)
				continue;
			finalJournalKeywordList.add(keyword);
		}
		vo1.setManuscriptId(vo.getId());
		vo1.setJournalKeywords(KeywordsTransformationUtils.mapModelListToVOList
				(finalJournalKeywordList));
		vo1.setManuscriptKeywords(ManuscriptKeywordsTransformationUtils.mapModelListToVoList
				(manuscriptKeywordsList));
		return vo1;
	}

	@Override
	public void saveTypeTitleAbstractDetails(ManuscriptTypeTitleAbstractVO vo) {
		log.info("Inside saveTypeTitleAbstractDetails Impl");
		ManuScript manuscript = manuScriptRepo.getOne(vo.getManuscriptId());
		manuscript.setManuscriptTitle(vo.getTitle());
		manuscript.setManuscriptShortTitle(vo.getShortTitle());
		manuscript.setManuscriptAbstract(vo.getManuscriptAbstract());
		manuscript.setManuscriptVersion(vo.getManuscriptVersion());
		manuscript.setIsActive(1);
		manuScriptRepo.save(manuscript);

		ManuscriptTypeDetails details = manuscriptTypeDetailsRepo.getDetailsFromManuscriptId(vo.getManuscriptId());

		if (details == null) {
			details = new ManuscriptTypeDetails();
			details.setManuscriptId(vo.getManuscriptId());
		}

		details.setManuscriptType(vo.getManuscriptTypeJournal());
		details.setManuscriptWords(vo.getManuscriptWords());
		details.setManuscriptBlackWhiteFigures(vo.getBlackAndWhiteFigures());
		details.setManuscriptColorFigures(vo.getManuscriptColorFigures());
		details.setManuscriptTables(vo.getManuscriptTables());
		details.setManuscriptPages(vo.getManuscriptPages());

		manuscriptTypeDetailsRepo.save(details);
		
        try {
        	List<ManuscriptKeywordsVO> voList = vo.getManuscriptKeywords();
        	for (ManuscriptKeywordsVO manuscriptKeywordsVO : voList) {
        		if (manuscriptKeywordsVO.getIsAdded() == 1) {
        			ManuScriptKeywords mk = new ManuScriptKeywords();
        			mk.setKeyId(manuscriptKeywordsVO.getKeywordId());
        			mk.setManuscriptId(vo.getManuscriptId());
        			mk.setIsActive(1);
        			manuscriptKeywordsRepo.save(mk);
        		}
        		
        		if (manuscriptKeywordsVO.getIsDeleted() == 1) {
        			manuscriptKeywordsRepo.deleteManuscriptTypeKeyword(manuscriptKeywordsVO.getId());
        		}
        	}
			
		}
		catch (Exception e) {
			log.info("Error");
		}
	}

	@Override
	public List<ManuscriptCoAuthorVO> getCoAuthorList(Integer manuscriptId) {
		List<ManuScriptCoAuthor> list = manuScriptCoAuthorRepo.getCoAuthorListFromManuscriptId(manuscriptId);
		List<ManuscriptCoAuthorVO> voList = ManuscriptCoAuthorTransformationUtils.mapModelListToVoList(list);
		
		try {
			ManuScript manuscript = manuScriptRepo.getOne(manuscriptId);
			User user = userRepo.getOne(manuscript.getAuthorId());
			ManuscriptCoAuthorVO vo = new ManuscriptCoAuthorVO();
			vo.setFirstName(user.getFirstName());
			vo.setMiddleName(user.getMiddleName());
			vo.setLastName(user.getLastName());
			vo.setAddress(user.getAddress());
			vo.setAddressTwo(user.getAddressTwo());
			vo.setAddressThree(user.getAddressThree());
			vo.setEmail(user.getEmail());
			vo.setInstitution(user.getInstitute());
			vo.setSalutation(user.getSalutation());
			vo.setOrder(0);
			voList.add(vo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Collections.sort(voList, (v1, v2) -> v1.getOrder().compareTo(v2.getOrder()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return voList;
	}

	@Override
	public void saveCoAuthorOrderList(List<ManuscriptCoAuthorVO> voList) {
		int order = 1;
		List<ManuScriptCoAuthor> list = new ArrayList<ManuScriptCoAuthor>();
		for (ManuscriptCoAuthorVO vo : voList) {
			ManuScriptCoAuthor coAuthor = manuScriptCoAuthorRepo.getOne(vo.getId());
			coAuthor.setAuthorOrder(order++);
			list.add(coAuthor);
		}

		manuScriptCoAuthorRepo.saveAll(list);
	}

	@Override
	public ManuscriptTypeDetails getManuscriptTypeDetailsByManuscriptId(Integer manuscriptId) {
		ManuscriptTypeDetails details = manuscriptTypeDetailsRepo.getDetailsFromManuscriptId(manuscriptId);
		return details;
	}

	@Override
	public void saveWordCountDetails(ManuScriptVO vo) {
		ManuscriptTypeDetails details = manuscriptTypeDetailsRepo.getOne(vo.getManuscriptTypeDetailsId());
		details.setManuscriptFigures(vo.getManuscriptFigures());
		details.setManuscriptColorFigures(vo.getManuscriptColorFigures());

		try {
			if (vo.getManuscriptColorFigures() != null && vo.getManuscriptColorFigures().length() > 0
					&& vo.getBlackAndWhiteFigures() != null && vo.getBlackAndWhiteFigures().length() > 0) {
				Integer figures = 0;
				figures = Integer.parseInt(vo.getManuscriptColorFigures())
						+ Integer.parseInt(vo.getBlackAndWhiteFigures());
				details.setManuscriptFigures(figures.toString());
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		details.setManuscriptTables(vo.getManuscriptTables());
		details.setManuscriptWords(vo.getManuscriptWords());
		details.setManuscriptPages(vo.getManuscriptPages());
		manuscriptTypeDetailsRepo.save(details);
		
	}

	@Override
	public void deleteCoAuthor(Integer authorId) {
		manuScriptCoAuthorRepo.deactivateCoAuthor(authorId);
	}

	@Override
	public void submitManuscript(ManuScriptVO vo) {
		ManuScript manuscript = manuScriptRepo.getOne(vo.getId());
			manuscript.setManuscriptVersion(vo.getManuscriptVersion());
			manuscript.setSubmissionDate(new Date());
		    manuscript.setDeclarationOfInterest(vo.getDeclarationOfInterest());
		    manuscript.setCopyrightAgreement(vo.getCopyrightAgreement());
		    manuScriptRepo.save(manuscript);
	}

	@Override
	public List<ReviewerDecisionVO> getReviewerDecision(UserJournalManuscriptVo userJournalManuscriptVo) {
		List<ReviewerDecisionVO> reviewerDecisionVO = new ArrayList<>();
		List<ManuScript> manuscript = manuScriptRepo.getManuScriptByJournalId(userJournalManuscriptVo.getJournalId());

		for (ManuScript m : manuscript) {
			ReviewerDecisionVO RDVO = new ReviewerDecisionVO();
			List<ManuScriptReviewer> manuScriptReviewer = manuScriptReviewerRepo
					.getManuscriptReviewerListByManuScriptIdAndStatus(m.getManuScriptId(), m.getManuscriptVersion(),
							userJournalManuscriptVo.getManuscriptStatusId());
			List<ReviewerDataWithCommentVO> rsdList = new ArrayList<>();
			if (manuScriptReviewer != null && !manuScriptReviewer.isEmpty()) {
				for (ManuScriptReviewer mr : manuScriptReviewer) {
					ReviewerDataWithCommentVO rsd = new ReviewerDataWithCommentVO();

					rsd.setReviewerName(mr.getManuscript().getUser().getFirstName() + " "
							+ mr.getManuscript().getUser().getLastName());
					rsd.setManuscriptVersion(mr.getManuscriptVersion());
					rsd.setReviewerId(mr.getReviewerId());
					rsd.setManuscriptId(mr.getManuscriptId());
					rsd.setManuscriptStatus(mr.getManuscriptStatus());
					rsd.setEditorId(mr.getEditorId());
					rsd.setManuscriptStatusCode(mr.getManuscript().getStatusMaster().getStatusValue());
					rsd.setCommentsToAuthor(mr.getCommentsToAuthor());
					rsd.setCommentsToEditor(mr.getCommentsToEditor());
					rsd.setDecisionLetter(mr.getDecisionLetter());
					rsdList.add(rsd);
				}
			}
			if (m.getManuscriptTypeDetails() != null) {
				RDVO.setManuscriptType(m.getManuscriptTypeDetails().getManuscriptType());
			}

			RDVO.setManuscriptId(m.getManuScriptId());
			RDVO.setManuscriptCode(m.getManuscriptCode());
			RDVO.setAuthornAME(m.getUser().getFirstName() + " " + m.getUser().getLastName());
			RDVO.setManuscriptTitle(m.getManuscriptTitle());
			RDVO.setSubmissionDate(m.getSubmissionDate());
			RDVO.setReviewerDataWithCommentVO(rsdList);

			reviewerDecisionVO.add(RDVO);

		}

		return reviewerDecisionVO;
	}

	@Override
	public void resubmissionSaveTypeTitleAbstract(ManuscriptTypeTitleAbstractVO vo) {
		ManuScript manuscript = manuScriptRepo.getOne(vo.getManuscriptId());
		manuscript.setManuscriptVersion(vo.getManuscriptVersion() + 1);
		manuscript.setManuscriptTitle(vo.getTitle());
		manuscript.setManuscriptShortTitle(vo.getShortTitle());
		manuscript.setManuscriptAbstract(vo.getManuscriptAbstract());
		manuScriptRepo.save(manuscript);
		ManuscriptTypeDetails details = manuscriptTypeDetailsRepo.getDetailsFromManuscriptId(vo.getManuscriptId());

		if (details == null) {
			details = new ManuscriptTypeDetails();
			details.setManuscriptId(vo.getManuscriptId());
		}
		details.setManuscriptType(vo.getManuscriptTypeJournal());
		details.setManuscriptWords(vo.getManuscriptWords());
		details.setManuscriptBlackWhiteFigures(vo.getBlackAndWhiteFigures());
		details.setManuscriptColorFigures(vo.getManuscriptColorFigures());
		details.setManuscriptTables(vo.getManuscriptTables());
		details.setManuscriptPages(vo.getManuscriptPages());
		manuscriptTypeDetailsRepo.save(details);
	}

	@Override
	public void resubmissionSaveWordCountDetails(ManuScriptVO vo) {
		ManuScript manuscript = manuScriptRepo.getOne(vo.getManuscriptId());
		manuscript.setManuscriptVersion(vo.getManuscriptVersion() + 1);
		manuScriptRepo.save(manuscript);

		ManuscriptTypeDetails details = manuscriptTypeDetailsRepo.getOne(vo.getManuscriptTypeDetailsId());
		details.setManuscriptFigures(vo.getManuscriptFigures());
		details.setManuscriptColorFigures(vo.getManuscriptColorFigures());

		try {
			if (vo.getManuscriptColorFigures() != null && vo.getManuscriptColorFigures().length() > 0
					&& vo.getBlackAndWhiteFigures() != null && vo.getBlackAndWhiteFigures().length() > 0) {
				Integer figures = 0;
				figures = Integer.parseInt(vo.getManuscriptColorFigures())
						+ Integer.parseInt(vo.getBlackAndWhiteFigures());
				details.setManuscriptFigures(figures.toString());
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		details.setManuscriptTables(vo.getManuscriptTables());
		details.setManuscriptWords(vo.getManuscriptWords());
		details.setManuscriptPages(vo.getManuscriptPages());
		manuscriptTypeDetailsRepo.save(details);

	}

}