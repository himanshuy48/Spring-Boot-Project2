package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.Institution;
import com.digi.uniprr.repository.InstitutionRepo;
import com.digi.uniprr.service.InstitutionService;

@Service
@Transactional
public class InstitutionServiceImpl implements InstitutionService {

	@Autowired
	InstitutionRepo institutionRepo;
	@Override
	public List<Institution> getInstitutionList() {
		
		return institutionRepo.findAll();
	}
	@Override
	public List<Institution> listByIdInstitution(Integer id) {
		// TODO Auto-generated method stub
		return institutionRepo.listByIdInstitution(id);
	}

}
