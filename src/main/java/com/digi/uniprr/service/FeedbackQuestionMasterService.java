package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.FeedbackQuestionMaster;

public interface FeedbackQuestionMasterService {

	List<FeedbackQuestionMaster> getFeedbackList();

	List<FeedbackQuestionMaster> getFeedbackListById(Integer id);

}
