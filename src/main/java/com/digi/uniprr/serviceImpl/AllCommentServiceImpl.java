package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.CommentVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.KeywordsVO;
import com.digi.uniprr.VO.ManuscriptEditorCommentsVO;
import com.digi.uniprr.VO.ManuscriptFileVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ManuscriptReviewerCommentsVO;
import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.model.JournalChargeDetails;
import com.digi.uniprr.model.Keywords;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptCoAuthor;
import com.digi.uniprr.model.ManuScriptFile;
import com.digi.uniprr.model.ManuScriptKeywords;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptEditor;
import com.digi.uniprr.model.User;
import com.digi.uniprr.model.UserInvoice;
import com.digi.uniprr.repository.KeywordsRepo;
import com.digi.uniprr.repository.ManuScriptCoAuthorRepo;
import com.digi.uniprr.repository.ManuScriptFileRepo;
import com.digi.uniprr.repository.ManuScriptKeywordsRepo;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.ManuScriptReviewerRepo;
import com.digi.uniprr.repository.ManuscriptEditorCommentsRepo;
import com.digi.uniprr.repository.ManuscriptEditorRepo;
import com.digi.uniprr.repository.ManuscriptReviewerCommentsRepo;
import com.digi.uniprr.repository.UserInvoiceRepo;
import com.digi.uniprr.repository.UserLoginRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.AllCommentService;
import com.digi.uniprr.utils.ManuscriptTransformationUtil;
import com.digi.uniprr.utils.UserTransformationalUtils;

@Service
@Transactional
public class AllCommentServiceImpl implements AllCommentService {

	@Autowired
	ManuScriptRepo manuScriptRepo;

	@Autowired
	ManuScriptReviewerRepo manuScriptReviewerRepo;

	@Autowired
	ManuScriptFileRepo manuScriptFileRepo;

	@Autowired
	ManuscriptReviewerCommentsRepo manuscriptReviewerCommentsRepo;

	@Autowired
	ManuscriptEditorCommentsRepo manuscriptEditorCommentsRepo;

	@Autowired
	UserLoginRepo userLoginRepo;

	@Autowired
	ManuScriptCoAuthorRepo manuScriptCoAuthorRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ManuScriptKeywordsRepo manuScriptKeywordsRepo;

	@Autowired
	KeywordsRepo keywordsRepo;

	@Autowired
	ManuscriptEditorRepo manuscriptEditorRepo;
	
	@Autowired
	UserInvoiceRepo userInvoiceRepo;

	@Override
	public CommentVO getAllComment(IDVO id) {

		CommentVO commentVO = new CommentVO();

		List<ManuscriptFileVO> fileVo = new ArrayList<ManuscriptFileVO>();
		List<ManuscriptReviewerCommentsVO> reviewerCommentVo = new ArrayList<>();
		List<ManuscriptEditorCommentsVO> manuscriptEditorCommentsVO = new ArrayList<>();
		List<UserVO> userVO = new ArrayList();
		List<KeywordsVO> keywordVO = new ArrayList();

		List<ManuScript> manuscript = manuScriptRepo.getManuScripByVersion(id.getId(), id.getVersion());
		if (manuscript != null && !manuscript.isEmpty()) {
			ManuscriptListVO mv = ManuscriptTransformationUtil.mapManuscriptModelToManuscriptVO(manuscript.get(0));
			commentVO.setManuscriptListVO(mv);

			// ManuscriptFile
			List<ManuScriptFile> manuscriptFile = manuScriptFileRepo.getManuscriptByactive(id.getId(), id.getVersion(),
					1);
			if (manuscriptFile != null && !manuscriptFile.isEmpty()) {
				for (ManuScriptFile mf : manuscriptFile) {
					ManuscriptFileVO manuscriptFileVO = new ManuscriptFileVO();
					manuscriptFileVO.setManuscriptFileId(mf.getManuscriptFileId());
					manuscriptFileVO.setFileName(mf.getFileName());
					manuscriptFileVO.setFilePath(mf.getFilePath());
					manuscriptFileVO.setFileSize(mf.getFileSize());
					manuscriptFileVO.setCreatedOn(mf.getCreatedOn());
					manuscriptFileVO.setLegend(mf.getLegend());
					// Added by Mudit
					manuscriptFileVO.setFileType(mf.getFileType());
					fileVo.add(manuscriptFileVO);
				}
				commentVO.setManuscriptFileVO(fileVo);
			}

			// ManuscriptReviewerComment
			List<ManuScriptReviewer> manuScriptReviewerList = manuScriptReviewerRepo
					.getManuscriptReviewerListByManuScriptIdAndVersion(id.getId(), id.getVersion());

			if (manuScriptReviewerList != null && !manuScriptReviewerList.isEmpty()) {
				for (ManuScriptReviewer mrc : manuScriptReviewerList) {
					User user = userLoginRepo.getOne(mrc.getReviewerId());
					ManuscriptReviewerCommentsVO mrcv = new ManuscriptReviewerCommentsVO();
					mrcv.setDecisionLetter(mrc.getDecisionLetter());
					mrcv.setReviewerId(mrc.getReviewerId());
					mrcv.setCommentsToAuthor(mrc.getCommentsToAuthor());
					mrcv.setCommentsToEditor(mrc.getCommentsToEditor());
					if (user != null && user.getFirstName() != null) {
						mrcv.setUserName(user.getFirstName());
					}
					reviewerCommentVo.add(mrcv);
				}
				commentVO.setManuscriptReviewerCommentsVO(reviewerCommentVo);
			}

			// ManuscriptEditorComment
			// List<ManuscriptEditorComments> manuscriptEditorComments =
			// manuscriptEditorCommentsRepo.getManuscriptEditorCommentsById(id.getId());
			List<ManuscriptEditor> manuscriptEditor = manuscriptEditorRepo.getByVersion(id.getId(), id.getVersion());
			if (manuscriptEditor != null && !manuscriptEditor.isEmpty()) {
				for (ManuscriptEditor mec : manuscriptEditor) {
					User user = userLoginRepo.getOne(mec.getEditorId());
					ManuscriptEditorCommentsVO mecv = new ManuscriptEditorCommentsVO();
					// Added by Mudit
					mecv.setCommentsForAuthor(mec.getCommentsForAuthor());
					mecv.setCommentsForEditor(mec.getCommentsForEditor());
					mecv.setCommentsForManagingEditor(mec.getCommentsForManagingEditor());
					mecv.setCommentsForReviewer(mec.getCommentsForReviewer());

					// mecv.setComments(mec.getComments());
					if (user != null) {
						mecv.setUserName(user.getFirstName());
					}
					manuscriptEditorCommentsVO.add(mecv);
				}
				commentVO.setManuscriptEditorCommentsVO(manuscriptEditorCommentsVO);
			}

			// Co-Author Detail
			List<ManuScriptCoAuthor> coAuthorDetail = manuScriptCoAuthorRepo
					.getCoAuthorListFromManuscriptId(id.getId());
			List<Integer> coAuthorId = new ArrayList<>();
			if (coAuthorDetail != null && !coAuthorDetail.isEmpty()) {
				for (ManuScriptCoAuthor coAuthor : coAuthorDetail) {
					coAuthorId.add(coAuthor.getCoAuthorId());
				}
				if (coAuthorId != null && !coAuthorId.isEmpty()) {
					List<User> userDetails = userRepo.getAllActiveUserByUserList(coAuthorId);
					userVO = UserTransformationalUtils.mapUserListToUserVOList(userDetails);

				}
			}
			commentVO.setCoAuthorVO(userVO);
			// keyword
			List<ManuScriptKeywords> manuScriptKeywordDetails = manuScriptKeywordsRepo
					.getManuscriptKeywordsFromManuscriptId(id.getId());
			List<Integer> keywordId = new ArrayList();
			if (manuScriptKeywordDetails != null && !manuScriptKeywordDetails.isEmpty()) {
				for (ManuScriptKeywords manuScriptKeyword : manuScriptKeywordDetails) {
					keywordId.add(manuScriptKeyword.getKeyId());
				}
				if (keywordId != null && !keywordId.isEmpty()) {
					List<Keywords> keywordList = keywordsRepo.getKeywordListByIdList(keywordId);
					for (Keywords keyword : keywordList) {
						KeywordsVO keywordVOData = new KeywordsVO();
						keywordVOData.setId(keyword.getId());
						keywordVOData.setJournalId(keyword.getJournalId());
						keywordVOData.setKeyword(keyword.getKeyword());
						keywordVOData.setType(keyword.getType());
						keywordVO.add(keywordVOData);
					}
				}
			}
			// Journal Charges
			if (manuscript.get(0).getJournalId() != null && manuscript.get(0).getJournal().getCharge() != null) {
				JournalChargeDetails journalChargeDetails = new JournalChargeDetails();
				journalChargeDetails.setJournalId(manuscript.get(0).getJournal().getCharge().getJournalId());
				journalChargeDetails.setComponent(manuscript.get(0).getJournal().getCharge().getComponent());
				journalChargeDetails.setChargeAmount(manuscript.get(0).getJournal().getCharge().getChargeAmount());
				journalChargeDetails.setFixedCharges(manuscript.get(0).getJournal().getCharge().getFixedCharges());
				journalChargeDetails.setColorCharges(manuscript.get(0).getJournal().getCharge().getColorCharges());
				journalChargeDetails
						.setBlackWhiteCharges(manuscript.get(0).getJournal().getCharge().getBlackWhiteCharges());
				journalChargeDetails.setTableCharges(manuscript.get(0).getJournal().getCharge().getTableCharges());
				journalChargeDetails
						.setTypeSettingCharges(manuscript.get(0).getJournal().getCharge().getTypeSettingCharges());
				journalChargeDetails
						.setAdditionalCharges(manuscript.get(0).getJournal().getCharge().getAdditionalCharges());
				journalChargeDetails
						.setProductionCharges(manuscript.get(0).getJournal().getCharge().getProductionCharges());
				journalChargeDetails.setCurrency(manuscript.get(0).getJournal().getCharge().getCurrency());
				journalChargeDetails
						.setFixedChargeAmount(manuscript.get(0).getJournal().getCharge().getFixedChargeAmount());
				commentVO.setJournalChargeDetails(journalChargeDetails);
			}
			commentVO.setKeyword(keywordVO);
			
			UserInvoice userInvoice = userInvoiceRepo.getPaymentDetailByMid(id.getId());
			if(userInvoice!=null) {
				commentVO.setUserInvoice(userInvoice);
			}
		}
		return commentVO;
	}

}
