package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.WorkflowVO;
import com.digi.uniprr.model.Workflow;
import com.digi.uniprr.model.WorkflowRoleSeq;
import com.digi.uniprr.service.WorkflowRoleService;
import com.digi.uniprr.service.WorkflowService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/workflow")
public class WorkflowRestController {

	@Autowired
	WorkflowService worflowService;

	@Autowired
	WorkflowRoleService workflowRoleService;
	
	//Create WorkFlow
	@RequestMapping(value = "/createWorkflow", method = RequestMethod.POST)
	public ResponseEntity<?> createWorkflow(@RequestBody WorkflowVO workflow) {
		JSONObject jsonObj = new JSONObject();

		try {
			Workflow wf = new Workflow();
			WorkflowRoleSeq wrs = new WorkflowRoleSeq();
			wf.setName(workflow.getWorkflowName());
			wf.setType(workflow.getType());
			wf.setStatus(1);
			// wf.setActive(workflow.getActive());
			wf.setCreatedBy(workflow.getCreatedBy());
			int workflowID = worflowService.saveWorkflow(wf);

			for (int i = 0; i <= workflow.getTaskSeqVO().size() - 1; i++) {

				wrs.setWorkflowId(workflowID);
				wrs.setStepNo(workflow.getTaskSeqVO().get(i).getSeqNo());
				wrs.setRoleId(workflow.getRoleID());
				wrs.setEmailFlag(workflow.getEmailFlag());
				wrs.setReadOnly(workflow.getReadOnly());
				wrs.setTat(workflow.getTat());
				wrs.setTaskId(workflow.getTaskSeqVO().get(i).getTaskID());

				workflowRoleService.createWorkflowRole(wrs);
			}
			jsonObj.put("workflowID", workflowID);
			jsonObj.put("workflowCreated", "workflow is Created successfully.");
			return new ResponseEntity<>(jsonObj, HttpStatus.CREATED);
		} catch (Exception e) {
			jsonObj.put("workflowCreated", "workflow is not Created successfully.");
			return new ResponseEntity<>(jsonObj, HttpStatus.FORBIDDEN);

		}

	}

	//Get All workFlow
	@RequestMapping(value = "/getWorkflow", method = RequestMethod.GET)
	public ResponseEntity<?> getWorkflow() {

		List<Workflow> wokflowList = worflowService.getWorkflow();
		return new ResponseEntity<>(wokflowList, HttpStatus.OK);

	}

	//Delete Workflow By ID
	@RequestMapping(value = "/deleteWorkflow", method = RequestMethod.POST)
	public ResponseEntity<?> deleteWorkflow(@RequestParam("id") Integer id) {

		JSONObject jsonObj = new JSONObject();
		try {
			workflowRoleService.deleteByWorkflowId(id);

			worflowService.deleteWorkflowById(id);
			jsonObj.put("taskDeleted", "task is Deleted successfully.");
			return new ResponseEntity<>(jsonObj, HttpStatus.OK);
		} catch (Exception e) {
			jsonObj.put("taskDeleted", "task is not Deleted successfully.");
			return new ResponseEntity<>(jsonObj, HttpStatus.FORBIDDEN);
		}

	}

	//Update WorkFlow
	@RequestMapping(value = "/updateworkflowrole", method = RequestMethod.POST)
	public ResponseEntity<?> updateWorkflowRoleByTaskId(@RequestBody WorkflowVO workflow) {
		JSONObject jsonObj = new JSONObject();

		Integer taskId = workflow.getTaskID();
		String readOnly = workflow.getReadOnly();
		String emailFlag = workflow.getEmailFlag();
		Integer tat = workflow.getTat();

		workflowRoleService.updateTaskWorkflowRole(taskId, readOnly, emailFlag, tat);

		return new ResponseEntity<>(jsonObj, HttpStatus.FORBIDDEN);
	}

}
