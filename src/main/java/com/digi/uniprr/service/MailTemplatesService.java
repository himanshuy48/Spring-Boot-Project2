package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.MailTemplates;

public interface MailTemplatesService {
	
	public void saveMailTemplate(MailTemplates template);
	
	public List<MailTemplates> getMailTemplates();

	public MailTemplates getMailTemplatesById(Integer id);
	
	public void deleteMailTemplate(Integer id);
}
