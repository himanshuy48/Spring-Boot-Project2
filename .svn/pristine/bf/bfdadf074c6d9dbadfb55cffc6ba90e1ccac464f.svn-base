package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.FeedbackQuestionMaster;

public interface FeedbackQuestionMasterRepo extends JpaRepository<FeedbackQuestionMaster, Integer>{

	@Query("select f from FeedbackQuestionMaster f where f.rmId=:rm_id")
	List<FeedbackQuestionMaster> getFeedbackListById(Integer rm_id);

}
