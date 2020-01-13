package com.digi.uniprr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.ManuScriptKeywords;
import com.digi.uniprr.service.ManuScriptKeywordsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuScriptKeywords")
public class ManuScriptKeywordsRestController 
{
	@Autowired
	ManuScriptKeywordsService manuScriptKeywordsService; 
	
   @RequestMapping(value="/getManuScriptKeywordsList" , method=RequestMethod.GET)
   public List<ManuScriptKeywords> getManuScriptKeywordsList()
   {
	   List<ManuScriptKeywords> manuScriptKeywordsList = manuScriptKeywordsService.getManuScriptKeywordsList();
	   return manuScriptKeywordsList;
   }
}
