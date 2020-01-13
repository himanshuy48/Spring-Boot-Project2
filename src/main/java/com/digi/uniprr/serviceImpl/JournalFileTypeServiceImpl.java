package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.JournalFileType;
import com.digi.uniprr.repository.JournalFileTypeRepo;
import com.digi.uniprr.service.JournalFileTypeService;

@Service
@Transactional

public class JournalFileTypeServiceImpl implements JournalFileTypeService {

	@Autowired
	private JournalFileTypeRepo journalFileTypeRepo;

	public List<JournalFileType> getDetails() {
		return journalFileTypeRepo.findAll();
	}

}
