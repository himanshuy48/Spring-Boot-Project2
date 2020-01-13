package com.digi.uniprr.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.JournalEditorMapping;
import com.digi.uniprr.repository.JournalEditorMappingRepo;
import com.digi.uniprr.service.JournalEditorMappingService;

@Service
@Transactional
public class JournalEditorMappingServiceImpl implements JournalEditorMappingService {

	@Autowired
	JournalEditorMappingRepo journalEditorMappingRepo;

	@Override
	public JournalEditorMapping getJournalEditorMappingById(Integer id) {
		return journalEditorMappingRepo.getJournalEditorMappingById(id);
	}
	
}	
	
