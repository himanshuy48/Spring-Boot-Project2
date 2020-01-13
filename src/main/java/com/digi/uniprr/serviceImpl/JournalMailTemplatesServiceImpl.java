package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.JournalMailTemplates;
import com.digi.uniprr.repository.JournalMailTemplatesRepo;
import com.digi.uniprr.service.JournalMailTemplatesService;
@Service
@Transactional
public class JournalMailTemplatesServiceImpl implements JournalMailTemplatesService {

	@Autowired
	JournalMailTemplatesRepo journalMailTemplatesRepo;
	
	@Override
	public String createJournalTemplates(JournalMailTemplates journalMailTemplates) {
		journalMailTemplatesRepo.save(journalMailTemplates);
		return "Created successfully";
	}

	@Override
	public List<JournalMailTemplates> getJournalMailTemplatesDetails() {
		return journalMailTemplatesRepo.findAll();
	}

	@Override
	public List<JournalMailTemplates> getJournalMailTemplatesDetailsById(Integer id) {
		return journalMailTemplatesRepo.getJournalMailTemplatesById(id);
	}

	@Override
	public String updateJournalMailTemplates(JournalMailTemplates journalMailTemplates) {
		journalMailTemplatesRepo.save(journalMailTemplates);
		return "Updated Successfully";
	}

	@Override
	public String deleteJournalMailTemplatesById(Integer id) {
		journalMailTemplatesRepo.deleteById(id);
		return "Deleted successfully";
	}

}
