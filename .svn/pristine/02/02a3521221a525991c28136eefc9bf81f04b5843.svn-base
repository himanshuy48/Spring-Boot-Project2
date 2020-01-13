package com.digi.uniprr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuScriptReviewer;

public interface ManuScriptReviewerRepo extends JpaRepository<ManuScriptReviewer, Integer> {

	@Query(value = "SELECT * FROM manuscript_reviewer r WHERE r.manuscript_id=:manuscriptId AND r.reviewer_id=:reviewerId AND r.manuscript_version=:manuscriptVersion", nativeQuery = true)
	List<ManuScriptReviewer> getmanuScriptReviewerById(Integer manuscriptId, Integer reviewerId,
			Integer manuscriptVersion);

	@Modifying
	@Query(value = "INSERT INTO manuscript_reviewer (manuscript_id,manuscript_version,reviewer_id,editor_id,manuscript_status,publon_credit,assigned_date,journal_id,is_assigned) VALUES(:manuscriptId, :manuscriptVersion, :reviewerId, :editorId, :manuscriptStatus, :publonCredit, :assignedDate, :journalId, :isAssigned) ", nativeQuery = true)
	void saveManuScriptReviewer(Integer manuscriptId, Integer manuscriptVersion, Integer reviewerId, Integer editorId,
			Integer manuscriptStatus, String publonCredit, Date assignedDate, Integer journalId, Integer isAssigned);

	@Modifying(clearAutomatically = true)
	@Query("update ManuScriptReviewer wrs set wrs.isActive =:active where wrs.manuscriptId =:manuscriptId and wrs.manuscriptVersion=:manuscriptVersion")
	void updateManuScriptEditorReviewer(Integer manuscriptId, Integer manuscriptVersion, Integer active);

	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.manuscriptStatus=:manuscriptStatus AND m.journalId=:journalId AND m.reviewerId=:reviewerId")
	List<ManuScriptReviewer> getManuscriptReviewer(Integer manuscriptStatus, Integer journalId, Integer reviewerId);

	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.manuscriptStatus=:manuscriptStatus AND m.journalId=:journalId")
	List<ManuScriptReviewer> getManuscriptReviewerListById(Integer manuscriptStatus, Integer journalId);

	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.journalId=:journalId GROUP BY m.reviewerId")
	List<ManuScriptReviewer> getManuscriptReviewerListByJournalId(Integer journalId);

	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.manuscriptId=:manuScriptId AND m.manuscriptVersion=:manuscriptVersion AND m.journalId=:journalId AND m.reviewerId=:assignToId")
	ManuScriptReviewer findManuscriptReviewerDetails(Integer manuScriptId, Integer manuscriptVersion, Integer journalId,
			Integer assignToId);

	@Modifying
	@Query("UPDATE ManuScriptReviewer m SET m.manuscriptStatus=:manuStatusId WHERE m.Id=:id")
	void updateReviewerDetails(Integer manuStatusId, Integer id);
	
	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.manuscriptId=:manuscriptId AND m.manuscriptVersion=:manuscriptVersion")
	List<ManuScriptReviewer> getManuscriptReviewerListByManuScriptIdAndVersion(Integer manuscriptId,Integer manuscriptVersion);
	
	@Query("SELECT r FROM ManuScriptReviewer r WHERE r.manuscriptId=:manuscriptId")
	List<ManuScriptReviewer> getById(Integer manuscriptId);
	
	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.manuscriptId=:manuscriptId AND m.manuscriptVersion=:manuscriptVersion AND m.manuscriptStatus IN :manuStatusId")
	List<ManuScriptReviewer> getManuscriptReviewerListByManuScriptIdAndStatus(Integer manuscriptId,Integer manuscriptVersion,List<Integer> manuStatusId);
	
	@Query("Select mr from ManuScriptReviewer mr where mr.reviewerId=:reviewerId")
	List<ManuScriptReviewer> getReviewerDataById(Integer reviewerId);
	
	@Query("Select mr from ManuScriptReviewer mr where mr.manuscriptId =:manuscriptId AND mr.manuscriptVersion =:manuscriptVersion AND mr.journalId =:journalId")
	List<ManuScriptReviewer> getReviewerDataByManuscriptVersion(Integer manuscriptId, Integer manuscriptVersion,
			Integer journalId);
	
	@Query("Select mr from ManuScriptReviewer mr where mr.journalId =:journalId AND mr.manuscriptId !=:manuscriptId OR mr.manuscriptVersion !=:manuscriptVersion")
	List<ManuScriptReviewer> getAssignedReviewer(Integer manuscriptId, Integer manuscriptVersion, Integer journalId);
	
	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.journalId IN :journalId")
	List<ManuScriptReviewer> getManuscriptReviewerListByJournal(List<Integer> journalId);
	
	@Query("Select mr from ManuScriptReviewer mr where mr.journalId =:journalId AND mr.manuscriptId !=:manuscriptId OR mr.manuscriptVersion !=:manuscriptVersion GROUP BY mr.reviewerId")
	List<ManuScriptReviewer> getUniqueUnassignedReviewer(Integer manuscriptId, Integer manuscriptVersion, Integer journalId);
	
	@Query("SELECT m FROM ManuScriptReviewer m WHERE m.journalId=:journalId")
	List<ManuScriptReviewer> getManuscriptReviewerByJournalId(Integer journalId);

}
