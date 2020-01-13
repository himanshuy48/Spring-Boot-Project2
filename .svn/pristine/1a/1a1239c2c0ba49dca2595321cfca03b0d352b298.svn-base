package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.MasterAttributesVO;
import com.digi.uniprr.model.MasterAttributes;
import com.digi.uniprr.repository.MasterAttributesRepo;
import com.digi.uniprr.service.MasterAttributesService;

@Service
@Transactional
public class MasterAttributesServiceImpl implements MasterAttributesService {

	@Autowired
	MasterAttributesRepo masterAttributesRepo;

	@Override
	public String addmasterattributes(MasterAttributes masterAttributes) {
			
		masterAttributesRepo.save(masterAttributes);
		return "Data Added Successfully";
	}

	@Override
	public boolean isExist(String category) {
		List<MasterAttributes> isExist = masterAttributesRepo.getCheckList(category);
		if (isExist != null || isExist.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List<MasterAttributes> getCheckList(String category) {
		return masterAttributesRepo.getCheckList(category);
	}

	@Override
	public String updatemasterAttributesDeatils(MasterAttributesVO masterAttributesVO) {
		List<MasterAttributes> data = masterAttributesRepo.getCheckList(masterAttributesVO.getCategory());
		MasterAttributes masterAttributes1 = data.get(0);
		MasterAttributes masterAttributesData = masterAttributesRepo.getOne(masterAttributes1.getId());
		
		if (masterAttributesVO.getCategory() != null) {
			masterAttributesData.setCategory(masterAttributesVO.getCategory());
		}
		if (masterAttributesVO.getChkKey() != null) {
			masterAttributesData.setChkKey(masterAttributesVO.getChkKey());
		}
		
		masterAttributesRepo.save(masterAttributesData);
		return "Updated Data Sucessfully";
	}
}
