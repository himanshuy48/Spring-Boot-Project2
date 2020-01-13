package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptEditorVO;
import com.digi.uniprr.model.ManuscriptEditorComments;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.ManuScriptReviewerRepo;
import com.digi.uniprr.repository.ManuscriptEditorCommentsRepo;
import com.digi.uniprr.service.ManuscriptEditorCommentsService;

@Service
@Transactional
public class ManuscriptEditorCommentsServiceImpl implements ManuscriptEditorCommentsService {
	@Autowired
	ManuScriptRepo manuScriptRepo;

	@Autowired
	ManuscriptEditorCommentsRepo manuscriptEditorCommentsRepo;

	@Autowired
	ManuScriptReviewerRepo manuScriptReviewerRepo;
	
	JSONObject obj = new JSONObject();
	
	@Override
	public void createManuscriptEditorComments(ManuscriptEditorComments manuscriptEditorComments) {
		manuscriptEditorCommentsRepo.save(manuscriptEditorComments);

	}

	@Override
	public ResponseEntity<?> updateManuScriptEditor(ManuscriptEditorVO manuscriptEditorVO) {
		if (manuscriptEditorVO.getStatusCode().equals("18") || manuscriptEditorVO.getStatusCode().equals("33")) {
			manuscriptEditorCommentsRepo.updateManuScriptEditorComments(manuscriptEditorVO.getManuscriptId(),
					manuscriptEditorVO.getManuscriptVersion(), manuscriptEditorVO.getStatusCode(),
					manuscriptEditorVO.getComments());
			manuScriptRepo.updateManuScriptEditor(manuscriptEditorVO.getManuscriptId(),
					manuscriptEditorVO.getManuscriptVersion(), manuscriptEditorVO.getStatusCode());
			manuScriptReviewerRepo.updateManuScriptEditorReviewer(manuscriptEditorVO.getManuscriptId(),
					manuscriptEditorVO.getManuscriptVersion(), 0);
			obj.put("message", " ManuScript Editor Comment Updated Successfully");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@Override
	public List<ManuscriptEditorComments> getManuscripEditorCommentsById(Integer id) {
		
		return manuscriptEditorCommentsRepo.getManuscriptEditorCommentsById(id);
	}

}
