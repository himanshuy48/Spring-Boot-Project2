package com.digi.uniprr.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManuscriptCoAuthorVO;
import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.model.User;
import com.digi.uniprr.service.ManuScriptService;
import com.digi.uniprr.service.UserService;
import com.digi.uniprr.serviceImpl.ManuScriptCoAuthorServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/manuScriptCoAuthor")

public class ManuScriptCoAuthorRestController {

	@Autowired
	UserService userService;
	
	@Autowired
	ManuScriptService manuscriptService;

	@Autowired
	ManuScriptCoAuthorServiceImpl manuScriptCoAuthorService;

	JSONObject obj = new JSONObject();

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createCoAuthor(@RequestBody ManuscriptCoAuthorVO manuscriptCoAuthorVO) {
		try {
			if(manuscriptCoAuthorVO.getId() == null) {
				List<Integer> roleId = new ArrayList();
				roleId.add(4);
				UserVO userVO = new UserVO();
				userVO.setSalutation(manuscriptCoAuthorVO.getSalutation());
				userVO.setFirstName(manuscriptCoAuthorVO.getFirstName());
				userVO.setMiddleName(manuscriptCoAuthorVO.getMiddleName());
				userVO.setLastName(manuscriptCoAuthorVO.getLastName());
				userVO.setRoleId(roleId);
				userVO.setEmail(manuscriptCoAuthorVO.getEmail());
				User savedUser = userService.createUser(userVO);
				manuscriptCoAuthorVO.setId(savedUser.getId());
			}
			manuScriptCoAuthorService.createCoAuthor(manuscriptCoAuthorVO);
			obj.put("data", "CoAuthor created...");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deleteCoAuthor(@RequestBody IDVO vo) {
		JSONObject obj = new JSONObject();
		try {
			manuscriptService.deleteCoAuthor(vo.getId());
			obj.put("message", "Succsessfully updated");
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("message", "Error");
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

}
