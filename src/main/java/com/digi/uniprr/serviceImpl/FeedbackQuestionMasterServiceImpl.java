package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.FeedbackQuestionMaster;
import com.digi.uniprr.repository.FeedbackQuestionMasterRepo;
import com.digi.uniprr.service.FeedbackQuestionMasterService;

@Service
@Transactional
public class FeedbackQuestionMasterServiceImpl implements FeedbackQuestionMasterService {

	@Autowired
	FeedbackQuestionMasterRepo feedbackQuestionMasterRepo; 
	
	@Override
	public List<FeedbackQuestionMaster> getFeedbackList() 
	{
		return feedbackQuestionMasterRepo.findAll();
	}

	@Override
	public List<FeedbackQuestionMaster> getFeedbackListById(Integer id) {
		
		return feedbackQuestionMasterRepo.getFeedbackListById(id);
	}

	

}
