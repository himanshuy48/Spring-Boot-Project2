package com.digi.uniprr.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.ManuscriptsInvoice;
import com.digi.uniprr.repository.ManuscriptsInvoiceRepo;
import com.digi.uniprr.service.ManuscriptsInvoiceService;

@Service
@Transactional

public class ManuscriptsInvoiceServiceImpl implements ManuscriptsInvoiceService {
	
	@Autowired
	ManuscriptsInvoiceRepo manuscriptsInvoiceRepo;

	@Override
	public String createInvoice(ManuscriptsInvoice manuscriptsInvoice) {
		manuscriptsInvoiceRepo.save(manuscriptsInvoice);
		return "Created successfully";
	}


}
