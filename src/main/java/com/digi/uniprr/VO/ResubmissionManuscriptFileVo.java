package com.digi.uniprr.VO;

import java.util.List;

public class ResubmissionManuscriptFileVo {

	private List<ManuscriptFileVO> manuscriptFileVO;
	
	private Integer manuScriptId;
	
	private Integer manuscriptVersion;

	public List<ManuscriptFileVO> getManuscriptFileVO() {
		return manuscriptFileVO;
	}

	public void setManuscriptFileVO(List<ManuscriptFileVO> manuscriptFileVO) {
		this.manuscriptFileVO = manuscriptFileVO;
	}

	public Integer getManuScriptId() {
		return manuScriptId;
	}

	public void setManuScriptId(Integer manuScriptId) {
		this.manuScriptId = manuScriptId;
	}

	public Integer getManuscriptVersion() {
		return manuscriptVersion;
	}

	public void setManuscriptVersion(Integer manuscriptVersion) {
		this.manuscriptVersion = manuscriptVersion;
	}
	
}
