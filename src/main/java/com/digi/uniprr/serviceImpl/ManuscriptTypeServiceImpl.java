package com.digi.uniprr.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digi.uniprr.model.ManuscriptType;
import com.digi.uniprr.repository.ManuscriptTypeRepo;
import com.digi.uniprr.service.ManuscriptTypeService;

@Service
@Transactional
public class ManuscriptTypeServiceImpl implements ManuscriptTypeService {

	@Autowired
	ManuscriptTypeRepo manuscriptTypeRepo;
	
	@Override
	public List<ManuscriptType> getManuscriptTypeList() {
		return manuscriptTypeRepo.getActiveManuscriptTypes();
	}

	@Override
	public void saveManuscriptType(ManuscriptType type) {
		type.setIsActive(1);
		manuscriptTypeRepo.save(type);
	}

	@Override
	public void deleteManuscriptType(Integer id) {
		ManuscriptType type = manuscriptTypeRepo.getOne(id);
		type.setIsActive(0);
		manuscriptTypeRepo.save(type);
	}

	@Override
	public ManuscriptType getManuscriptTypeById(Integer id) {
		return manuscriptTypeRepo.getOne(id);
	}

}
