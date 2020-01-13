package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptReviewerComments;

public interface ManuscriptReviewerCommentsRepo extends JpaRepository<ManuscriptReviewerComments, Integer> {

	@Query(value = "SELECT * FROM manuscript_reviewer_comments r WHERE r.manuscript_id=:manuscriptId AND r.reviewer_id=:reviewerId AND r.manuscript_version=:manuscriptVersion", nativeQuery = true)
	List<ManuscriptReviewerComments> getmanuScriptReviewerById(Integer manuscriptId, Integer reviewerId,Integer manuscriptVersion);

	@Query("SELECT mrc from ManuscriptReviewerComments mrc WHERE mrc.manuscriptId=:id")
	List<ManuscriptReviewerComments> getManuscriptReviewerCommentsById(Integer id);
	
	@Query("SELECT m FROM ManuscriptReviewerComments m WHERE m.manuscriptId=:manuscriptId AND m.manuscriptVersion=:manuscriptVersion")
	ManuscriptReviewerComments getManuscriptReviewerListByManuScriptIdAndVersion(Integer manuscriptId,Integer manuscriptVersion);

	
	
}
