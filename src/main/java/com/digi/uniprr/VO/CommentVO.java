package com.digi.uniprr.VO;

import java.util.List;

import com.digi.uniprr.model.JournalChargeDetails;
import com.digi.uniprr.model.PaymentDetails;
import com.digi.uniprr.model.UserInvoice;

public class CommentVO {

	private ManuscriptListVO manuscriptListVO;
	private List<ManuscriptFileVO> manuscriptFileVO;
	private List<ManuscriptReviewerCommentsVO> manuscriptReviewerCommentsVO;
	private List<ManuscriptEditorCommentsVO> manuscriptEditorCommentsVO;
	private List<UserVO> coAuthorVO;
	private List<KeywordsVO> keyword;
	private JournalChargeDetails journalChargeDetails;
	
	private UserInvoice userInvoice;

	public ManuscriptListVO getManuscriptListVO() {
		return manuscriptListVO;
	}

	public void setManuscriptListVO(ManuscriptListVO manuscriptListVO) {
		this.manuscriptListVO = manuscriptListVO;
	}

	public List<ManuscriptFileVO> getManuscriptFileVO() {
		return manuscriptFileVO;
	}

	public void setManuscriptFileVO(List<ManuscriptFileVO> manuscriptFileVO) {
		this.manuscriptFileVO = manuscriptFileVO;
	}

	public List<ManuscriptReviewerCommentsVO> getManuscriptReviewerCommentsVO() {
		return manuscriptReviewerCommentsVO;
	}

	public void setManuscriptReviewerCommentsVO(List<ManuscriptReviewerCommentsVO> manuscriptReviewerCommentsVO) {
		this.manuscriptReviewerCommentsVO = manuscriptReviewerCommentsVO;
	}

	public List<ManuscriptEditorCommentsVO> getManuscriptEditorCommentsVO() {
		return manuscriptEditorCommentsVO;
	}

	public void setManuscriptEditorCommentsVO(List<ManuscriptEditorCommentsVO> manuscriptEditorCommentsVO) {
		this.manuscriptEditorCommentsVO = manuscriptEditorCommentsVO;
	}

	public List<UserVO> getCoAuthorVO() {
		return coAuthorVO;
	}

	public void setCoAuthorVO(List<UserVO> coAuthorVO) {
		this.coAuthorVO = coAuthorVO;
	}

	public List<KeywordsVO> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<KeywordsVO> keyword) {
		this.keyword = keyword;
	}

	public JournalChargeDetails getJournalChargeDetails() {
		return journalChargeDetails;
	}

	public void setJournalChargeDetails(JournalChargeDetails journalChargeDetails) {
		this.journalChargeDetails = journalChargeDetails;
	}

	public UserInvoice getUserInvoice() {
		return userInvoice;
	}

	public void setUserInvoice(UserInvoice userInvoice) {
		this.userInvoice = userInvoice;
	}
}
