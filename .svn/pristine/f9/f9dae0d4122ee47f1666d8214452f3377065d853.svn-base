package com.digi.uniprr.serviceImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digi.uniprr.model.Cities;
import com.digi.uniprr.model.Countries;
import com.digi.uniprr.model.States;
import com.digi.uniprr.repository.CitiesRepo;
import com.digi.uniprr.repository.CountriesRepo;
import com.digi.uniprr.repository.StatesRepo;
import com.digi.uniprr.service.CountriesService;

@Service
@Transactional
public class CountriesServiceImpl implements CountriesService {

	@Autowired
	CountriesRepo countriesRepo;
	
	@Autowired
	StatesRepo statesRepo;
	
	@Autowired
	CitiesRepo citiesRepo;

	@Override
	public List<Countries> getCountriesList() {
		return countriesRepo.findAll();
	}
	
	@Override
	public List<States> getStatesByCoutryId(Integer countryId) {
		return statesRepo.getStatesByCoutryId(countryId);
	}

	@Override
	public List<Cities> getCityByStateId(Integer stateId) {
		return citiesRepo.getCityByStateId(stateId);
	}

}
