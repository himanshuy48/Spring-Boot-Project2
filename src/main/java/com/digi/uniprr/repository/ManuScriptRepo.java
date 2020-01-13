package com.digi.uniprr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptEditorComments;

public interface ManuScriptRepo extends JpaRepository<ManuScript, Integer> {

	@Query("select m from ManuScript m where m.manuScriptId=:id And m.isActive=1")
	List<ManuScript> getManuScripById(Integer id);

	@Modifying
	@Query(value = "update manuscript m set m.manuscript_status_id=:manuscriptStatus where m.manuscript_id=:manuScriptId", nativeQuery = true)
	void updateStage(Integer manuscriptStatus, Integer manuScriptId);

	@Query(value = "select m from ManuScript m where m.manuscriptStatusId=:manuscriptStatus")
	List<ManuScript> getListByStatusId(Integer manuscriptStatus);

	@Query(value = "select * from manuscript where manuscript_id=:id", nativeQuery = true)
	List<ManuScript> trackManuScript(Integer id);

	@Query(value = "select * from manuscript where manuscript_id=:id and journal_id=:journalId and submission_date=:submissionDate", nativeQuery = true)
	List<ManuScript> gettrackManuScript(Integer id, Integer journalId, Date submissionDate);

	@Query(value = "select * from manuscript where submission_date between :submissionDateTo and :submissionDateFrom", nativeQuery = true)
	List<ManuScript> gettrackManuScriptDate(String submissionDateTo, String submissionDateFrom);

	@Query(value = "SELECT * FROM manuscript WHERE manuscript_title LIKE %:manuscriptTitle%", nativeQuery = true)
	List<ManuScript> gettrackManuScriptTitle(@Param("manuscriptTitle") String manuscriptTitle);

	@Query(value = "SELECT * FROM manuscript where manuscript_code=:manuscriptCode", nativeQuery = true)
	List<ManuScript> gettrackManuScriptCode(String manuscriptCode);

	@Query(value = "SELECT * FROM manuscript WHERE journal_id IN (SELECT journal_id FROM journal WHERE journal_title LIKE %:journalTitle%)", nativeQuery = true)
	List<ManuScript> gettrackJTitle(@Param("journalTitle") String journalTitle);

	/******** Get Track ManuScript By Auhtor *********/
	@Query(value = "select * from manuscript where manuscript_code=:manuscriptCode and manuscript_title=:manuscriptTitle and submission_date=:submissionDateFrom and and submission_date=:submissionDateTo", nativeQuery = true)
	List<ManuScript> gettrackManuScriptAuthor(String manuscriptCode, String manuscriptTitle, Date submissionDateFrom,
			Date submissionDateTo);

	/******* Reviewer DashBoard *******/

	@Query(value = "SELECT * FROM manuscript WHERE manuscript_status_id=8 AND manuscript_id IN (SELECT manuscript_id FROM manuscript_reviewer WHERE reviewer_id=:reviewerId)", nativeQuery = true)
	List<ManuScript> reviewerInvitationList(Integer reviewerId);

	@Query(value = "SELECT * FROM manuscript WHERE manuscript_status_id=12 AND manuscript_id IN (SELECT manuscript_id FROM manuscript_reviewer WHERE reviewer_id=:reviewerId)", nativeQuery = true)
	List<ManuScript> reviewerReviewList(Integer reviewerId);

	@Query(value = "SELECT * FROM manuscript WHERE manuscript_status_id in (14,15) AND manuscript_id IN (SELECT manuscript_id FROM manuscript_reviewer WHERE reviewer_id=:reviewerId)", nativeQuery = true)
	List<ManuScript> reviewerRevisionList(Integer reviewerId);

	@Query(value = "SELECT * FROM manuscript WHERE manuscript_status_id=20 AND manuscript_id IN (SELECT manuscript_id FROM manuscript_reviewer WHERE reviewer_id=:reviewerId)", nativeQuery = true)
	List<ManuScript> reviewerCompletedList(Integer reviewerId);

	@Modifying
	@Query(value = "UPDATE manuscript SET manuscript_status_id=12 WHERE manuscript_id=:id ", nativeQuery = true)
	void reviewerAccept(Integer id);

	@Modifying
	@Query(value = "UPDATE manuscript SET manuscript_status_id=13 WHERE manuscript_id=:id ", nativeQuery = true)
	void rejectReviewer(Integer id);

	/***** Author Dashboard ******/
	@Query(value = "SELECT * from manuscript WHERE manuscript_author_id=:authorId AND manuscript_status_id IN (1, 14, 15)", nativeQuery = true)
	List<ManuScript> authorTask(Integer authorId);

	@Query(value = "SELECT * from manuscript WHERE manuscript_author_id=:authorId AND manuscript_status_id IN (3, 8, 9, 10, 11, 12, 13)", nativeQuery = true)
	List<ManuScript> authorUnderReview(Integer authorId);

	@Query(value = "SELECT * from manuscript WHERE manuscript_author_id=:authorId AND manuscript_status_id IN (19, 32)", nativeQuery = true)
	List<ManuScript> authorManuscriptAccepted(Integer authorId);

	@Query(value = "SELECT * from manuscript WHERE manuscript_author_id=:authorId AND manuscript_status_id IN (18, 30)", nativeQuery = true)
	List<ManuScript> authorManuscriptRejected(Integer authorId);

	@Query("SELECT m from ManuScript m WHERE m.manuscriptStatusId =2 AND m.journalId=:id")
	List<ManuScript> getEditorSubmitted(Integer id);

	@Query("SELECT m from ManuScript m WHERE m.manuscriptStatusId =26 AND m.journalId=:id")
	List<ManuScript> getEditorReSubmitted(Integer id);

	@Query("SELECT mr from ManuScriptReviewer mr WHERE mr.manuscriptStatus =8 OR mr.manuscriptStatus =35  AND mr.journalId=:id")
	List<ManuScriptReviewer> getEditorSentForReview(Integer id);

	@Query(value = "SELECT mr from ManuScriptReviewer mr WHERE mr.manuscriptStatus =14 OR mr.manuscriptStatus =15 OR mr.manuscriptStatus =37 OR mr.manuscriptStatus =38 AND mr.journalId=:id")
	List<ManuScriptReviewer> getEditorAllList(Integer id);


	@Query(value = "SELECT manuscript_id FROM manuscript WHERE manuscript_id IN (SELECT manuscript_id FROM manuscript_reviewer WHERE author_id=:reviewerId)", nativeQuery = true)
	List<Integer> getManuscriptIdListByReviewerId(Integer reviewerId);

	@Query("select m from ManuScript m where m.manuscriptStatusId=:manuscriptStatusId AND m.isActive=1  AND m.journalId=:journalId ORDER BY m.submissionDate DESC")
	List<ManuScript> getManuscriptByStatus(Integer manuscriptStatusId, Integer journalId);

	///
	@Modifying(clearAutomatically = true)
	@Query("update ManuScript wrs set wrs.manuscriptStatusId =:statusCode where wrs.manuScriptId =:manuscriptId and wrs.manuscriptVersion=:manuscriptVersion")
	void updateManuScriptEditor(Integer manuscriptId, Integer manuscriptVersion, Integer statusCode);

	@Query(value = "SELECT * FROM manuscript a WHERE a.journal_id=:journalId", nativeQuery = true)
	List<ManuScript> getUniqueManuScript(Integer journalId);

	@Query(value = "select m from ManuScript m where m.manuScriptId=:id")
	List<ManuScript> getAllDetail(Integer id);
	
	@Query(value = "select m from ManuScript m where m.manuScriptId=:manuscriptId")
	List<ManuScript> getAllDetails(Integer manuscriptId);

	@Query(value = "select m from ManuScript m where m.authorId=:userId AND m.journalId=:journalId AND m.manuscriptStatusId=:statusId")
	List<ManuScript> getManuScriptDataByID(Integer userId, Integer journalId, Integer statusId);

	@Query(value = "select m from ManuScript m where m.journalId=:journalId AND m.manuscriptStatusId=:manuStatusId")
	List<ManuScript> getManuScriptDataByStatus(Integer journalId, Integer manuStatusId);

	@Query("SELECT m from ManuScript m WHERE m.authorId=:authorId And m.isActive=1 AND m.manuscriptStatusId IN :statusList ORDER BY m.submissionDate DESC")
	List<ManuScript> authorDashboardData(Integer authorId, List<Integer> statusList);

	@Modifying(clearAutomatically = true)
	@Query("update ManuScript wrs set wrs.manuscriptStatusId =:statusId where wrs.manuScriptId =:manuscriptId and wrs.authorId=:authorId")
	void updateManuScriptByAuthor(Integer manuscriptId, Integer authorId, Integer statusId);

	@Modifying(clearAutomatically = true)
	@Query("update ManuScript wrs set wrs.manuscriptStatusId =:statuscode where wrs.manuScriptId =:manuStatusId")
	void updateManuScriptStatusById(Integer manuStatusId, Integer statuscode);

	@Query("select m from ManuScript m where m.manuscriptStatusId IN :manuStatusId AND m.journalId IN (SELECT j.journalId from Journal j where j.journalId IN (select uj.journalId from UserJournal uj where uj.userId = :userId))")
	List<ManuScript> getManuscriptByUser(Integer userId, List<Integer> manuStatusId);
	
	@Query("SELECT m FROM ManuScript m WHERE m.journalId IN :journalId")
	List<ManuScript> getManuscriptByJournalList(List<Integer> journalId);

	@Query("Select m from ManuScript m where m.journalId =:journalId ")
	List<ManuScript> getManuScriptByJournalId(Integer journalId);

	@Query("Select m from ManuScript m where m.manuScriptId=:id AND m.manuscriptVersion=:version")
	List<ManuScript> getManuScripByVersion(Integer id, Integer version);
	
	@Query("Select m from ManuScript m where m.authorId=:id")
	List<ManuScript> getManuScripAuthorId(Integer id);
	
}