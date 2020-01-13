package com.digi.uniprr.service;

import com.digi.uniprr.VO.ManuscriptManagingEditorChecklistVO;
import com.digi.uniprr.model.ManuscriptManagingEditorChecklist;

public interface ManuscriptManagingEditorChecklistService {

	    public String addManagingEditorChecklistDeatils(ManuscriptManagingEditorChecklist manuscriptManagingEditorChecklist);
		
		public String updateManagingEditorChecklistDeatils(ManuscriptManagingEditorChecklistVO manuscriptManagingEditorChecklistVO);
		
		public boolean isExist(Integer manuscriptId,Integer reviewerId,Integer manuscriptVersion);
		
		String addAllDetailsMultipleTable(ManuscriptManagingEditorChecklistVO manuscriptManagingEditorChecklistVO);
}
