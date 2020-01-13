package com.digi.uniprr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuScriptReviewerChecklist;

public interface ManuscriptReviewerChecklistRepo extends JpaRepository<ManuScriptReviewerChecklist, Integer> {

	@Query(value = "SELECT * FROM manuscript_reviewer_checklist r WHERE r.manuscript_id=:manuscriptId AND r.reviewer_id=:reviewerId", nativeQuery = true)
	List<ManuScriptReviewerChecklist> getmanuScriptReviewerById(Integer manuscriptId, Integer reviewerId);
	
	@Modifying
	@Query(value="INSERT INTO manuscript_reviewer_checklist (manuscript_id,manuscript_version,reviewer_id,chk_id,chk_type,chck_comments,created_by,created_on,updated_by,updated_on) VALUES(:manuscriptId, :manuscriptVersion, :reviewerId, :chkId, :chkType, :chckComments, :createdBy, :createdOn, :updatedBy , :updatedOn) ",nativeQuery = true)
	void saveChecklist(Integer manuscriptId,Integer manuscriptVersion,Integer reviewerId,Integer chkId,Integer chkType,String chckComments,Integer createdBy ,Date createdOn,Integer updatedBy ,Date updatedOn);
}
