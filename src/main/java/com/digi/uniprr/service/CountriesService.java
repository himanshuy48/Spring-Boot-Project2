package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.Cities;
import com.digi.uniprr.model.Countries;
import com.digi.uniprr.model.States;

public interface CountriesService {

	List<Countries> getCountriesList();

    List<States> getStatesByCoutryId(Integer countryId);
    
    List<Cities> getCityByStateId(Integer stateId);
}
