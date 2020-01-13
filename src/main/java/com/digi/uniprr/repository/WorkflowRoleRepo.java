package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.WorkflowRoleSeq;

public interface WorkflowRoleRepo extends JpaRepository<WorkflowRoleSeq, Integer> {

	@Modifying(clearAutomatically = true)
	@Query("update WorkflowRoleSeq wrs set wrs.tat =:tat,wrs.readOnly=:readOnly,wrs.emailFlag=:emailFlag where wrs.taskId =:taskId")
	public void updateTaskWorkflowRole(Integer taskId, String readOnly, String emailFlag, Integer tat);

	@Modifying

	@Query(value = "INSERT INTO workflow_role_seq (workflow_id, step_no, task_id, role_id, read_only, email_flag, tat,infloder,outfolder) VALUES (:workflowId, :stepNo, :taskId ,:roleId, :readOnly, :emailFlag,:tat,:inFolder,:outFolder)", nativeQuery = true)
	void createTaskWorkflowRole(Integer workflowId, Integer stepNo, Integer roleId, String emailFlag, String readOnly,
			Integer tat, Integer taskId, String inFolder, String outFolder);

	@Query(value = "SELECT * FROM workflow_role_seq  WHERE workflow_role_seq.workflow_id=:id", nativeQuery = true)
	public List<WorkflowRoleSeq> getTaskByWorkflow(Integer id);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "delete FROM workflow_role_seq  WHERE workflow_role_seq.workflow_id=:id", nativeQuery = true)
	void deleteByWorkflowId(Integer id);
	
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query(value =
	 * "update WorkflowRoleSeq wrs set wrs.readOnly =:readOnly, wrs.emailFlag =:emailFlag, wrs.tat =:tat WHERE wrs.taskId=:taskId"
	 * ) void updateWorkflowRoleByTaskId(Integer taskId, String readOnly, String
	 * emailFlag, Integer tat);
	 */

}
