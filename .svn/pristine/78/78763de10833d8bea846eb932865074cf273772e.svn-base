package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.CheckListMasterSimpleVO;
import com.digi.uniprr.VO.CheckListMasterVO;
import com.digi.uniprr.model.CheckListMaster;
import com.digi.uniprr.repository.CheckListMasterRepo;
import com.digi.uniprr.service.CheckListMasterService;

@Service
@Transactional
public class CheckListMasterServiceImpl implements CheckListMasterService {

	@Autowired
	CheckListMasterRepo checkListMasterRepo;
	
	JSONObject obj = new JSONObject();
	
	@Override
	public String addChecklistDeatils(CheckListMaster checkListMaster) {
		checkListMasterRepo.save(checkListMaster);
		return "Data Added Successfully";
	}
	
	@Override
	public JSONObject saveCheckListMaster(CheckListMasterVO checkListMasterVO) {
	  try {
		for (int i = 0; i <= checkListMasterVO.getCheckList().size() - 1; i++) {
			checkListMasterRepo.saveCheckListMaster(checkListMasterVO.getJournalId(), checkListMasterVO.getChkCategory(), checkListMasterVO.getCreatedBy(), checkListMasterVO.getCreatedOn(), checkListMasterVO.getUpdatedBy(), checkListMasterVO.getUpdatedOn(), checkListMasterVO.getCheckList().get(i).getChkKey(), checkListMasterVO.getChkRule(), checkListMasterVO.getCheckList().get(i).getIsActive());
		}
		obj.put("message", "Checklist Save Successfully");
		return obj;
	  }
	  catch(Exception e) {
		  System.out.println(e);
		  return obj;  
	  }	
	}

	@Override
	public List<CheckListMasterSimpleVO> getCheckListByRole() {
		List<CheckListMaster> checkList = checkListMasterRepo.findAll();
		List<CheckListMasterSimpleVO> list = new ArrayList<CheckListMasterSimpleVO>();
		for(CheckListMaster cm :checkList )
		{
			CheckListMasterSimpleVO vo = new CheckListMasterSimpleVO();
			vo.setJournalId(cm.getJournalId());
			vo.setChkCategory(cm.getChkCategory());
			vo.setChkKey(cm.getChkKey());
			vo.setChkRule(cm.getChkRule());
			vo.setCreatedBy(cm.getCreatedBy());
			vo.setCreatedOn(cm.getCreatedOn());
			vo.setUpdatedBy(cm.getUpdatedBy());
			vo.setUpdatedOn(cm.getUpdatedOn());
			vo.setIsActive(cm.getIsActive());
			
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<CheckListMaster> getCheckList(Integer journalId, String chkCategory) {
		return checkListMasterRepo.getCheckList(journalId, chkCategory);
	}
	
	@Override
	public boolean isExist(Integer journalId, String chkCategory) {
		List<CheckListMaster> isExist = checkListMasterRepo.getCheckList(journalId, chkCategory);
		if (isExist != null || isExist.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String deletechecklistById(Integer chkid) {
		checkListMasterRepo.deactivateisActive(chkid);
		return "Deleted successfully";
	}

	@Override
	public boolean isExist(Integer chkid) {
		return checkListMasterRepo.existsById(chkid);
	}

	@Override
	public List<CheckListMaster> getCheckListAll(Integer journalId, String chkCategory) {
		return checkListMasterRepo.getCheckListByisActive(journalId, chkCategory);
	}

}
