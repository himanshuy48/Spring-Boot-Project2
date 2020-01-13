package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.Workflow;

public interface WorkflowService {

	public List<Workflow> getWorkflow();

	public Integer saveWorkflow(Workflow workflow);

	public void deleteWorkflowById(Integer workflowId);
	
	

	
}
