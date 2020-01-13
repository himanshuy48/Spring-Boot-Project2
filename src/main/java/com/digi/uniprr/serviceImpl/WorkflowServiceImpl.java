package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.Workflow;
import com.digi.uniprr.repository.WorkflowRepo;
import com.digi.uniprr.service.WorkflowService;

@Service
@Transactional
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	WorkflowRepo workflowRepo;

	@Override
	public List<Workflow> getWorkflow() {
		return workflowRepo.findAll();
	}

	@Override
	public Integer saveWorkflow(Workflow workflow) {
		workflowRepo.save(workflow);
		workflowRepo.flush();
		
		return workflow.getWorkflowId();
	}

	@Override
	public void deleteWorkflowById(Integer workflowId) {
		workflowRepo.deleteById(workflowId);
		
	}
	
	

}
