package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.WorkflowRoleSeq;


public interface WorkflowRoleService {

	public void createWorkflowRole(WorkflowRoleSeq workflowRole);

	public List<WorkflowRoleSeq> getWorkflowRole();

	public Integer saveWorkflowRole(WorkflowRoleSeq workflowRole);

	public void deleteWorkflowRoleById(Integer workflowRoleId);

	public void updateTaskWorkflowRole(Integer taskId, String readOnly, String emailFlag, Integer tat);
	
	public void deleteByWorkflowId(Integer id);
	
	/*
	 * public void updateWorkflowRoleByTaskId(Integer taskId, String readOnly,
	 * String emailFlag, Integer tat);
	 */
}
