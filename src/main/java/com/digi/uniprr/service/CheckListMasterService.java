package com.digi.uniprr.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.digi.uniprr.VO.CheckListMasterSimpleVO;
import com.digi.uniprr.VO.CheckListMasterVO;
import com.digi.uniprr.model.CheckListMaster;

public interface CheckListMasterService {
	
	public String addChecklistDeatils(CheckListMaster checkListMaster);
	
	JSONObject saveCheckListMaster(CheckListMasterVO checkListMasterVO);

	List<CheckListMasterSimpleVO> getCheckListByRole();
	
	List<CheckListMaster> getCheckList(Integer journalId, String chkCategory);
	
	List<CheckListMaster> getCheckListAll(Integer journalId, String chkCategory);

	boolean isExist(Integer journalId, String chkCategory);
	
	public String deletechecklistById(Integer chkid);
	
	public boolean isExist(Integer chkid);
	
}
