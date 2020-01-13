package com.digi.uniprr.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.MasterAttributesVO;
import com.digi.uniprr.model.MasterAttributes;
import com.digi.uniprr.service.MasterAttributesService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/masterchecklist")
public class MasterAttributesController {

	@Autowired
	private MasterAttributesService masterAttributesService;
	
	@RequestMapping(value = "/addMasterattributes", method = RequestMethod.POST)
	  public ResponseEntity<?> addMasterattributes(@RequestBody MasterAttributes masterAttributes) {
		JSONObject obj = new JSONObject();
		try{
			masterAttributesService.addmasterattributes(masterAttributes);
		   obj.put("Added", "Added Data Sucessfully.");
		   return new ResponseEntity<Object>(obj, HttpStatus.OK); 
		}
		catch(Exception e){
			System.out.println(e);
			obj.put("Addeded", "Does not exist table");
      	return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
		}
     }
	
	@RequestMapping(value = "/updateMasterattributes", method = RequestMethod.POST)
	public ResponseEntity<?> updateMasterattributes(@RequestBody MasterAttributesVO masterAttributesVO) {
		JSONObject obj = new JSONObject();
		try {
			if (masterAttributesService.isExist(masterAttributesVO.getCategory()))
				masterAttributesService.updatemasterAttributesDeatils(masterAttributesVO);
			obj.put("updated", "Updated Data Sucessfully.");
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		} catch (Exception e) {
			obj.put("updated", "Does not exist Table.");
			return new ResponseEntity<Object>(obj, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("list")
	public ResponseEntity<?> getCheckByRole(@RequestParam String category) {
		JSONObject obj = new JSONObject();
		List<MasterAttributes> checkList  = new ArrayList<>();
		try {
			if(masterAttributesService.isExist(category)) 
			  checkList = masterAttributesService.getCheckList(category);
			  obj.put("data", checkList);
			  return new ResponseEntity<>(obj, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
		}
	}
}
