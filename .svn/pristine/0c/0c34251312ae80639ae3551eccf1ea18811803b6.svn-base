package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.ManuscriptTypeDetails;
import com.digi.uniprr.repository.ManuscriptTypeDetailsRepo;
import com.digi.uniprr.service.ManuscriptTypeDetailsService;

@Service
@Transactional
public class ManuscriptTypeDetailsServiceImpl implements ManuscriptTypeDetailsService {

	@Autowired
	ManuscriptTypeDetailsRepo manuscriptTypeDetailsRepo;
	
	@Override
	public void createManuscriptTypeDetails(ManuscriptTypeDetails manuscriptTypeDetails) {
		manuscriptTypeDetailsRepo.save(manuscriptTypeDetails);
	}

	@Override
	public List<ManuscriptTypeDetails> getManuscriptTypeDetails() {
		return manuscriptTypeDetailsRepo.findAll();
	}

	@Override
	public List<ManuscriptTypeDetails> getManuscriptTypeDetailsById(ManuscriptTypeDetails manuscriptTypeDetails) {
		return manuscriptTypeDetailsRepo.getManuscriptTypeDetailsById(manuscriptTypeDetails.getManuscriptId());
	}

}
