package com.digi.uniprr.VO;

import java.util.List;

public class JournalTatConfigurationVO {
	
	private Integer id;
	
	private Integer journalId;
	
	private String status;
	
	private Integer statusId;
	
	private Integer turnAroundTime;
	
	private Integer bufferedTime;
	
	private Integer requiredAlert;

	private List<TurnAroundTimeVO> turnAroundTimeVO;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getTurnAroundTime() {
		return turnAroundTime;
	}

	public void setTurnAroundTime(Integer turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

	public Integer getBufferedTime() {
		return bufferedTime;
	}

	public void setBufferedTime(Integer bufferedTime) {
		this.bufferedTime = bufferedTime;
	}

	public Integer getRequiredAlert() {
		return requiredAlert;
	}

	public void setRequiredAlert(Integer requiredAlert) {
		this.requiredAlert = requiredAlert;
	}

	public List<TurnAroundTimeVO> getTurnAroundTimeVO() {
		return turnAroundTimeVO;
	}

	public void setTurnAroundTimeVO(List<TurnAroundTimeVO> turnAroundTimeVO) {
		this.turnAroundTimeVO = turnAroundTimeVO;
	}

}
