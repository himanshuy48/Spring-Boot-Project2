package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.model.EditorAvailability;

public interface EditorService {

	List<ManuscriptListVO> getManuScriptDataByStatus(ManuscriptListVO  manuscriptListVO);
	
	void updateManuScriptByAuthor(ManuscriptListVO  manuscriptListVO);
	
	void saveEditorAvailability(EditorAvailability editorAvailability);
	
	List<EditorAvailability> getEditorAvailabilityById(Integer id);

	void deleteEditorAvailabilityById(Integer id);
	
	List<ReviewerVO> getEditorWithAvailability();
}
