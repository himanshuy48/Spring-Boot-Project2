package com.digi.uniprr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "workflow_role_seq")
public class WorkflowRoleSeq {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	private Integer id;

	@OneToOne(optional = false)
	@JoinColumn(name = "workflow_id",insertable = false,updatable = false)
	private Workflow workflow;
	
	@Column(name = "workflow_id")
	private Integer workflowId;

	@Column(name = "step_no")
	private Integer stepNo;

	@Column(name = "task_id")
	private Integer taskId;

	@Column(name = "role_id")
	private Integer RoleId;

	@Column(name = "read_only")
	private String readOnly;

	@Column(name = "email_flag")
	private String emailFlag;

	@Column(name = "tat")
	private Integer tat;

	@Column(name = "infloder")
	private String inFloder;

	@Column(name = "outfolder")
	private String outFolder;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at")
	private Date createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public Integer getStepNo() {
		return stepNo;
	}

	public void setStepNo(Integer stepNo) {
		this.stepNo = stepNo;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getEmailFlag() {
		return emailFlag;
	}

	public void setEmailFlag(String emailFlag) {
		this.emailFlag = emailFlag;
	}

	public Integer getTat() {
		return tat;
	}

	public void setTat(Integer tat) {
		this.tat = tat;
	}

	public String getInFloder() {
		return inFloder;
	}

	public void setInFloder(String inFloder) {
		this.inFloder = inFloder;
	}

	public String getOutFolder() {
		return outFolder;
	}

	public void setOutFolder(String outFolder) {
		this.outFolder = outFolder;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "WorkflowRoleSeq [id=" + id + ", workflow=" + workflow + ", workflowId=" + workflowId + ", stepNo="
				+ stepNo + ", taskId=" + taskId + ", RoleId=" + RoleId + ", readOnly=" + readOnly + ", emailFlag="
				+ emailFlag + ", tat=" + tat + ", inFloder=" + inFloder + ", outFolder=" + outFolder + ", createdBy="
				+ createdBy + ", createdAt=" + createdAt + "]";
	}

	

}