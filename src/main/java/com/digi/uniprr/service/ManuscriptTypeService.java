package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.ManuscriptType;

public interface ManuscriptTypeService {
	
	List<ManuscriptType> getManuscriptTypeList();
	
	void saveManuscriptType(ManuscriptType type);
	
	void deleteManuscriptType(Integer id);
	
	ManuscriptType getManuscriptTypeById(Integer id);

}
