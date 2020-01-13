package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ExpertiseVO;
import com.digi.uniprr.model.Expertise;
import com.digi.uniprr.repository.ExpertiseRepo;
import com.digi.uniprr.service.ExpertiseService;

@Service
@Transactional
public class ExpertiseServiceImpl implements ExpertiseService {

	@Autowired
	ExpertiseRepo expertiseRepo;

	@Override
	public List<ExpertiseVO> getList() {
		List<Expertise> expertiseList = expertiseRepo.findAll();
		List<ExpertiseVO> list = new ArrayList<ExpertiseVO>();
		for(Expertise e :expertiseList )
		{
			ExpertiseVO vo = new ExpertiseVO();
			vo.setId(e.getId());
			vo.setJournalId(e.getJournalId());
	        vo.setCreatedBy(e.getCreatedBy());
	        vo.setCreatedOn(e.getCreatedOn());
	        vo.setUpdatedBy(e.getUpdatedBy());
	        vo.setUpdatedOn(e.getUpdatedOn());
	        vo.setAreaExpertise(e.getAreaExpertise());
			
			list.add(vo);
		}
		return list;
	}

	
}
