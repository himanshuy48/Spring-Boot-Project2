package com.digi.uniprr.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.enums.YNStatus;
import com.digi.uniprr.model.ManuscriptAuthor;
import com.digi.uniprr.repository.ManuscriptAuthorRepo;
import com.digi.uniprr.service.ManuscriptAuthorService;

@Service
@Transactional
public class ManuscriptAuthorServiceImpl implements ManuscriptAuthorService {

	@Autowired
	ManuscriptAuthorRepo manuscriptAuthorRepo;

	@Override
	public void createManuscriptCoAuthor(ManuscriptAuthor manuscriptAuthor) {
	manuscriptAuthor.setPrimaryAuthor(YNStatus.No);
		manuscriptAuthorRepo.save(manuscriptAuthor);

	}

	@Override
	public void createManuscriptAuthor(ManuscriptAuthor manuscriptAuthor) {
		manuscriptAuthor.setPrimaryAuthor(YNStatus.Yes);
		manuscriptAuthorRepo.save(manuscriptAuthor);
		
	}

}
