
package com.digi.uniprr.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.RoleVO;
import com.digi.uniprr.bean.GroupRoleBean;
import com.digi.uniprr.model.Groups;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.service.GroupRoleService;
import com.digi.uniprr.service.GroupService;
import com.digi.uniprr.service.RoleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/role")
public class RoleRestController {

	@Autowired
	RoleService roleService;

	@Autowired
	GroupRoleService groupRoleService;

	@Autowired
	GroupService groupService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> CreateRoleDetails(@RequestBody Role role) {
		if (roleService.isRoleExist(role.getRoleId())) {
			return new ResponseEntity<Object>("Already exist", HttpStatus.CONFLICT);
		}
		roleService.CreateRoleDetails(role);
		return new ResponseEntity<Object>("Created Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/listGroupByRoleId", method = RequestMethod.GET)
	public List<Groups> getGroupByRole(@RequestBody GroupRoleBean groupRoleBean) {

		List<Groups> list = new ArrayList<>();
		List<GroupRoleBean> groupRoleBeanList = groupRoleService.getGroupByRoleId(groupRoleBean.getRoleId());
		for (int i = 0; i < groupRoleBeanList.size(); i++) {
			list.add(groupService.getByRoleIdForGroup(groupRoleBeanList.get(i).getGroupId()));
		}
		return list;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Role> getRoleDetails() {
		List<Role> roleList = roleService.getRoleDetails();
		return roleList;
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public List<RoleVO> getRoleDetail() {
		List<RoleVO> arrayList = new ArrayList<>();
		List<Role> roleList = roleService.getRoleDetails();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		for (Role rl : roleList) {
			RoleVO vo = new RoleVO();
			vo.setCreatedBy(rl.getCreatedBy());
			vo.setCreatedOn(formatter.format(rl.getCreatedOn()));
			vo.setRoleName(rl.getRoleName());
			arrayList.add(vo);
		}
		return arrayList;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Object> updateRoleDetails(@RequestBody Role role) {
		if (roleService.isRoleExist(role.getRoleId())) {
			roleService.updateRoleDetails(role);
			return new ResponseEntity<Object>("Updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Already exist", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public List<Role> getRoleById(@RequestBody Role role) {
		List<Role> roleList = roleService.getRoleById(role);
		return roleList;
	}

}
