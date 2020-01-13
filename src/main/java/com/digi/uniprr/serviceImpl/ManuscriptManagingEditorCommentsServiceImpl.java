package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.ManuscriptManagingEditorComments;
import com.digi.uniprr.repository.ManuscriptManagingEditorCommentsRepo;

import com.digi.uniprr.service.ManuscriptManagingEditorCommentsService;

@Service
@Transactional
public class ManuscriptManagingEditorCommentsServiceImpl implements ManuscriptManagingEditorCommentsService {

	@Autowired
	ManuscriptManagingEditorCommentsRepo manuscriptManagingEditorCommentsRepo;
	
	@Override
	public void createManuscriptManagingEditorComments(
			ManuscriptManagingEditorComments manuscriptManagingEditorComments) {
		manuscriptManagingEditorCommentsRepo.save(manuscriptManagingEditorComments);
	}

	@Override
	public List<ManuscriptManagingEditorComments> getManuscriptManagingEditorComments() {
		return manuscriptManagingEditorCommentsRepo.findAll();
	}

	@Override
	public List<ManuscriptManagingEditorComments> getManuscriptManagingEditorCommentsById(Integer id) {
		return manuscriptManagingEditorCommentsRepo.getManuscriptManagingEditorCommentsById(id);
	}

	@Override
	public void updateManuscriptManagingEditorComments(ManuscriptManagingEditorComments manuscriptManagingEditorComments) {
		manuscriptManagingEditorCommentsRepo.save(manuscriptManagingEditorComments);
	}

	@Override
	public boolean isExistById(Integer id) {
		return manuscriptManagingEditorCommentsRepo.existsById(id);
	}

	


}
