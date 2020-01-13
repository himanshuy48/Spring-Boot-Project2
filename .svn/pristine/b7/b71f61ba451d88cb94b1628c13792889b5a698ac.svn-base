package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ReviewerAvailabilityVO;
import com.digi.uniprr.VO.ReviewerStatusData;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.model.Reviewer;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.model.User;

public interface ReviewerService {

	List<User> getReviewerListDeatils();

	String createReviewer(Reviewer reviewer);

	void saveReviewerAvailability(ReviewerAvailability reviewerAvailability);

	List<ReviewerAvailabilityVO> getReviewerAvailabilityById(Integer id);

	void deleteReviewerAvailabilityById(Integer id);

	boolean isExistById(Integer id);

	List<ReviewerVO> getReviewerList();

	List<ReviewerStatusData> getReviewerByJournalId(IDVO id);

	List<ReviewerVO> getReviewerWithAvailability();

}
