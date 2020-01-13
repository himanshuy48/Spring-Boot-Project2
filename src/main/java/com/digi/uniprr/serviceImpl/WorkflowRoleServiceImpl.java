package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.WorkflowRoleSeq;
import com.digi.uniprr.repository.WorkflowRoleRepo;
import com.digi.uniprr.service.WorkflowRoleService;

@Service
@Transactional
public class WorkflowRoleServiceImpl implements WorkflowRoleService {

	@Autowired
	WorkflowRoleRepo workflowRoleRepo;
	
	@Override
	public void createWorkflowRole(WorkflowRoleSeq workflowRole) {
		workflowRoleRepo.createTaskWorkflowRole(workflowRole.getWorkflowId(), workflowRole.getStepNo(),
				workflowRole.getRoleId(), workflowRole.getEmailFlag(), workflowRole.getReadOnly(),
				workflowRole.getTat(), workflowRole.getTaskId(), workflowRole.getInFloder(),
				workflowRole.getOutFolder());

	}

	@Override
	public List<WorkflowRoleSeq> getWorkflowRole() {
		return workflowRoleRepo.findAll();
	}

	@Override
	public Integer saveWorkflowRole(WorkflowRoleSeq workflowRole) {
		workflowRoleRepo.save(workflowRole);
		workflowRoleRepo.flush();
		return workflowRole.getId();
	}

	@Override
	public void deleteWorkflowRoleById(Integer workflowRoleId) {
		workflowRoleRepo.deleteById(workflowRoleId);

	}

	@Override
	public void updateTaskWorkflowRole(Integer taskId, String readOnly, String emailFlag, Integer tat) {
		workflowRoleRepo.updateTaskWorkflowRole(taskId, readOnly, emailFlag, tat);

	}

	@Override
	public void deleteByWorkflowId(Integer id) {
		workflowRoleRepo.deleteByWorkflowId(id);
		
	}

	/*
	 * @Override public void updateWorkflowRoleByTaskId(Integer taskId, String
	 * readOnly, String emailFlag, Integer tat) {
	 * workflowRoleRepo.updateWorkflowRoleByTaskId(taskId, readOnly, emailFlag,
	 * tat);
	 * 
	 * }
	 */

}
