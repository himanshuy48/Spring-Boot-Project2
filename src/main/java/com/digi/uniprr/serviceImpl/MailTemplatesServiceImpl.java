package com.digi.uniprr.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.MailTemplates;
import com.digi.uniprr.repository.MailTemplatesRepo;
import com.digi.uniprr.service.MailTemplatesService;

@Service
@Transactional
public class MailTemplatesServiceImpl implements MailTemplatesService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	MailTemplatesRepo mailTemplatesRepo;

	@Override
	public void saveMailTemplate(MailTemplates template) {
		mailTemplatesRepo.save(template);
	}
	
	@Override
	public List<MailTemplates> getMailTemplates() {
		return mailTemplatesRepo.getActiveMailTemplates();
	}

	@Override
	public MailTemplates getMailTemplatesById(Integer id) {
		return mailTemplatesRepo.getOne(id);
	}

	@Override
	public void deleteMailTemplate(Integer id) {
		mailTemplatesRepo.deleteMailTemplate(id);
	}

}
