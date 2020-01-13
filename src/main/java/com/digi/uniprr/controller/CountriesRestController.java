package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.model.Cities;
import com.digi.uniprr.model.Countries;
import com.digi.uniprr.model.States;
import com.digi.uniprr.service.CountriesService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/countries")
public class CountriesRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CountriesService countriesService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getCountriesDetails() {
		log.info("Inside countries getCountriesDetails");
		List<Countries> countriesList = countriesService.getCountriesList();
		obj.put("data",countriesList);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}

	@PostMapping("getStatesByCoutryId")
	public ResponseEntity<?> getStatesByCoutryId(@RequestBody IDVO countryId) {
		log.info("Inside countries getStatesByCoutryId");
		List<States> statesList=countriesService.getStatesByCoutryId(countryId.getId());
		obj.put("data",statesList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("getCityByStateId")
	public ResponseEntity<?> getCityByStateId(@RequestBody IDVO stateId) {
		log.info("Inside countries getStatesByCoutryId");
		List<Cities> cityList=countriesService.getCityByStateId(stateId.getId());
		obj.put("data",cityList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	
}
