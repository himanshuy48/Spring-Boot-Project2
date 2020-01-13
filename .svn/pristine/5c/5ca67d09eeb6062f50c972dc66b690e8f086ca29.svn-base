package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.JournalListVO;
import com.digi.uniprr.model.Expertise;
import com.digi.uniprr.model.Journal;
import com.digi.uniprr.model.Specialization;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.ExpertiseRepo;
import com.digi.uniprr.repository.JournalsRepo;
import com.digi.uniprr.repository.SpecializationRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.AutoCompleteService;
import com.digi.uniprr.utils.JournalListTransformationUtils;

@Service
@Transactional
public class AutoCompleteServiceImpl implements AutoCompleteService {

	@Autowired
	JournalsRepo journalsRepo;

	@Autowired
	ExpertiseRepo expertiseRepo;

	@Autowired
	SpecializationRepo specializationRepo;

	@Autowired
	UserRepo userRepo;

	@Override
	public List<JournalListVO> getJournalList(IDVO name) {

		List<Journal> journalList = journalsRepo.getJournalByName(name.getName());
		List<JournalListVO> data = JournalListTransformationUtils.mapModelListToVoList(journalList);
		return data;
	}

	@Override
	public List<IDVO> getExpertiseList(IDVO name) {
		List<IDVO> data = new ArrayList<>();
		List<Expertise> expertiseData = expertiseRepo.getExpertiseListByName(name.getName());
		if (expertiseData != null && !expertiseData.isEmpty()) {
			for (Expertise expertiseVale : expertiseData) {
				IDVO tempData = new IDVO();
				tempData.setId(expertiseVale.getId());
				tempData.setName(expertiseVale.getAreaExpertise());
				data.add(tempData);
			}
		}
		return data;
	}

	@Override
	public List<IDVO> getSpecialization(IDVO name) {
		List<IDVO> data = new ArrayList<>();
		List<Specialization> specialization = specializationRepo.getSpecializationByName(name.getName());
		if (specialization != null && !specialization.isEmpty()) {
			for (Specialization specializationValue : specialization) {
				IDVO tempData = new IDVO();
				tempData.setId(specializationValue.getId());
				tempData.setName(specializationValue.getSpecialization());
				data.add(tempData);
			}
		}
		return data;
	}

	@Override
	public List<IDVO> getInstitution() {
		List<String> userList=userRepo.getInstitutionByName();
		Set<String> set=new TreeSet<>();
		for (String user : userList) {
			if(user!=null && !user.isEmpty()) {
			set.add(user);
			}
		}
		List<IDVO> list=new ArrayList<>();
		set.stream().forEach(i->{
				IDVO idvo=new IDVO();
				idvo.setName(i);
				list.add(idvo);
		});
		return list;
	}
}
