package com.digi.uniprr.VO;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileVO {

	private MultipartFile[] files;
	private Integer type;
	private Integer journalId;
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getJournalId() {
		return journalId;
	}
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	
}
