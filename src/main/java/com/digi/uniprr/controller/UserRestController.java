package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.CommonVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptEditor;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ManuScriptReviewerService;
import com.digi.uniprr.service.ManuScriptService;
import com.digi.uniprr.service.ManuscriptEditorService;
import com.digi.uniprr.service.RoleService;
import com.digi.uniprr.service.UserService;
import com.digi.uniprr.utils.CustomErrorType;
import com.google.gson.JsonObject;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	JSONObject obj = new JSONObject();

	@SuppressWarnings("null")
	@RequestMapping(value = "/loginAuthenticate", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
		boolean staus = false;
		JSONObject obj = new JSONObject();
		try {
			UserVO userDetails = userService.getUserByEmailAndPassword(email);
			if (userDetails != null) {
				staus = BCrypt.checkpw(password, userDetails.getPassword());
				if (staus) {
					userDetails.setPassword("");
					obj.put("data", userDetails);
					return new ResponseEntity<>(obj, HttpStatus.OK);
				} else {
					obj.put("data", "Wrong password");
					return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
				}
			} else {
				obj.put("data", "User not found");
				return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserVO userVO) {
		JSONObject obj = new JSONObject();
		try {
			User isExist = userService.getByEmail(userVO.getEmail());
			if (isExist != null) {
				obj.put("data", "User already exist.");
				return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
			}
			userService.createUser(userVO);
		} catch (Exception e) {
			obj.put("data", "Something went wrong.");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
		obj.put("data", "User successfully created.");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/activateAccount", method = RequestMethod.POST)
	public ResponseEntity<?> activateLockedAccount(@RequestBody UserVO userVO) {
		JSONObject obj = new JSONObject();
		if (userVO.getPassword() != null && userVO.getToken() != null) {
			userService.activateLockedUser(userVO);
			obj.put("data", "Password reset successfully.");
		} else {
			obj.put("data", "Data not matched.");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody UserVO userVO) {
		JSONObject obj = new JSONObject(); 
		userService.updateUser(userVO);
		obj.put("message", "Data Sucessfully Updated");
		return new ResponseEntity<> (obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getUserList() {
		JSONObject obj = new JSONObject();
		List<UserVO> userList = userService.getUserDetails();
		if (userList != null) {
			obj.put("data", userList);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Data not found");
		return new ResponseEntity<>(obj, HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<?> getUserById(@RequestBody IDVO vo) {
		UserVO userVo = userService.getUserById(vo.getId());
		return new ResponseEntity<>(userVo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deleteUser(@RequestBody IDVO id) {
		userService.deleteUserById(id.getId());
		obj.put("message", "deleted successfully");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUserByRoles", method = RequestMethod.POST)
	public List<UserVO> getUsersByRoles(@RequestBody CommonVO vo) {
		List<UserVO> voList = userService.getUserListByRoleId(vo.getRoleId());
		return voList;
	}

	@RequestMapping(value = "/assignUser", method = RequestMethod.POST)
	public ResponseEntity<?> assignUser(@RequestBody ManuscriptListVO manuscriptListVO) {
		userService.assignUser(manuscriptListVO);
		obj.put("data", "Assigned successfully");
		return new ResponseEntity<>(obj, HttpStatus.OK);

	}

	@RequestMapping(value = "/userDetailsByEmail", method = RequestMethod.POST)
	public ResponseEntity<?> getUserDetailsByEmail(@RequestBody User user) {
		try {
			User userDetails = userService.getByEmail(user.getEmail());
			if (userDetails != null) {
				userDetails.setPassword("");
				obj.put("data", userDetails);
			} else {
				obj.put("data", "");
			}
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
	}
}
