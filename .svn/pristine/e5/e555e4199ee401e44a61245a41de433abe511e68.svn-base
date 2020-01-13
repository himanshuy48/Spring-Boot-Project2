package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.StatusMaster;

public interface StatusMasterRepo extends JpaRepository<StatusMaster, Integer> {

	@Query("select sm from StatusMaster sm where sm.statusValue=:statusValue")
	List<StatusMaster> getListByStatusValue(String statusValue);
	
	@Query("select sm from StatusMaster sm where sm.id=:id")
	List<StatusMaster> getStatusMasterDetailsById(Integer id);
	
	@Query(value="SELECT * FROM status_master u WHERE u.required_for_tat='Y' ", nativeQuery = true)
	List<StatusMaster> getStatusMasterTatValue();
	
	@Query(value="SELECT * FROM status_master u WHERE u.status_id=:statusId ", nativeQuery = true)
	StatusMaster getStatusMaster(Integer statusId);

}