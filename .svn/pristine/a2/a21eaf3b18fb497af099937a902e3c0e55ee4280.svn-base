package com.digi.uniprr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.RuleMaster;
import com.digi.uniprr.service.RuleMasterService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/ruleMaster")
public class RuleMasterRestController 
{
	@Autowired
	RuleMasterService ruleMasterService;
	
      @RequestMapping(value="/getRuleMasterDetails" , method=RequestMethod.GET)
      public List<RuleMaster> getRuleMasterDetails()
      {
    	  List<RuleMaster> ruleList= ruleMasterService.getRuleMasterDetails();
    	  return ruleList;
      }
}
