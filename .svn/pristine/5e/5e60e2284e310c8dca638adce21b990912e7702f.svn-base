package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Workflow;
import com.digi.uniprr.model.WorkflowRoleSeq;

public interface WorkflowRepo extends JpaRepository<Workflow, Integer> {

	
	@Query(value ="SELECT * FROM workflow_role_seq wrs WHERE wrs.workflow_id=:id", nativeQuery = true)
	public List<WorkflowRoleSeq> getTaskByWorkflow(Integer id);
}
