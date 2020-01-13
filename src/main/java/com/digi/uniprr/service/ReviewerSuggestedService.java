package com.digi.uniprr.service;

import com.digi.uniprr.VO.ReviewerSuggestedVO;
import com.digi.uniprr.VO.ReviewerSuggestionVO;
import com.digi.uniprr.model.ReviewerSuggested;
import com.digi.uniprr.model.User;

public interface ReviewerSuggestedService {

	public User getByEmail(String email);
	
	public ReviewerSuggested getByEmailId(String email);
	
	public String createUser(ReviewerSuggestionVO reviewerSuggestionVO);
	
	public String createReviewerSuggestedArray(ReviewerSuggestedVO reviewerSuggestedVO);
	
	
}
