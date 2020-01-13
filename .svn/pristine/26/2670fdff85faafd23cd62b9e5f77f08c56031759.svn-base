package com.digi.uniprr.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.CheckListMaster;

public interface CheckListMasterRepo extends JpaRepository<CheckListMaster, Integer> {

	@Query("select cm from CheckListMaster cm where cm.journalId=:journalId AND cm.chkCategory=:chkCategory AND cm.isActive=1")
	List<CheckListMaster> getCheckListByisActive(Integer journalId,String chkCategory);
	
	@Query("select cm from CheckListMaster cm where cm.journalId=:journalId AND cm.chkCategory=:chkCategory")
	List<CheckListMaster> getCheckList(Integer journalId,String chkCategory);
	
	@Modifying
	@Query(value="INSERT INTO checklist_master  (journal_id,chk_category,created_by,created_on,updated_by,updated_on,chk_key,chk_rule,is_active) VALUES(:journalId, :chkCategory, :createdBy, :createdOn, :updatedBy, :updatedOn, :chkKey, :chkRule, :isActive) ",nativeQuery = true)
	void saveCheckListMaster(Integer journalId,String chkCategory,Integer createdBy,Date createdOn,Integer updatedBy,Date updatedOn,String chkKey, String chkRule, Integer isActive);
	
	@Modifying
	@Query("UPDATE CheckListMaster SET isActive=0 WHERE chkid=:chkid")
	public void deactivateisActive(Integer chkid);
	
}
