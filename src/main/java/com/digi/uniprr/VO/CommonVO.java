package com.digi.uniprr.VO;

import java.util.List;

public class CommonVO {
	
	private List<Integer> roleId;
	
	private List<KeywordsVO> reviewer;

	public List<Integer> getRoleId() {
		return roleId;
	}

	public void setRoleId(List<Integer> roleId) {
		this.roleId = roleId;
	}

	public List<KeywordsVO> getReviewer() {
		return reviewer;
	}

	public void setReviewer(List<KeywordsVO> reviewer) {
		this.reviewer = reviewer;
	}
	
	
}
