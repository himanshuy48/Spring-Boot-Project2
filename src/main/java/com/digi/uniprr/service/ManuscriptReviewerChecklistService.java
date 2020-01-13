package com.digi.uniprr.service;

import com.digi.uniprr.VO.ManuscriptReviewerChecklistVO;
import com.digi.uniprr.model.ManuScriptReviewerChecklist;

public interface ManuscriptReviewerChecklistService {
	
    public String addReviewerChecklistDeatils(ManuScriptReviewerChecklist manuScriptReviewerChecklist);
	
	public String updateReviewerChecklistDeatils(ManuscriptReviewerChecklistVO manuscriptReviewerChecklistVO);
	
	public boolean isExist(Integer manuscriptId,Integer reviewerId);

}
