package com.digi.uniprr.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.EditorVO;
import com.digi.uniprr.VO.GroupVO;
import com.digi.uniprr.VO.ManagingEditorVO;
import com.digi.uniprr.model.Groups;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.service.GroupService;
import com.digi.uniprr.service.RoleService;
import com.digi.uniprr.service.UserService;
import com.digi.uniprr.utils.CustomErrorType;
import com.digi.uniprr.utils.RoleUtil;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping(value = "/group")
public class GroupRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GroupService groupService;

	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Groups> getGroupDetail() {
		log.info("Inside GroupRestController getGroupDetail");
		List<GroupVO> arrayList = new ArrayList<>();
		List<Groups> groupList = groupService.getGroupDetail();

		for (Groups gr : groupList) {
			GroupVO groups = new GroupVO();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			groups.setId(gr.getId());
			groups.setGroupName(gr.getGroupName());
			groups.setStatus(gr.getStatus());
			groups.setCreatedBy(gr.getCreatedBy());
			if (gr.getCreatedOn() != null)
				groups.setCreatedAt(formatter.format(gr.getCreatedOn()));

			if (gr.getUpdatedOn() != null)
				groups.setModifiedAt(formatter.format(gr.getUpdatedOn()));
			groups.setModifiedBy(gr.getUpdatedBy());
			arrayList.add(groups);
		}

		return groupList;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createGroup(@RequestBody Groups group) {
		log.info("Inside GroupRestController createGroup");
		if (groupService.isGroupExist(group)) {
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Group with name " + group.getGroupName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		groupService.saveGroup(group);
		return new ResponseEntity<>("Created Successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody Groups group) {
		log.info("Inside GroupRestController updateUser");
		if (!(groupService.isGroupExist(group))) {
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to Update Group. A Group with id " + group.getId() + " does not exist."),
					HttpStatus.CONFLICT);
		}

		groupService.updateGroup(group);

		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Groups> deleteGroup(@RequestBody Groups group) {
		log.info("Inside GroupRestController deleteGroup");
		if (groupService.getGroupsById(group.getId())) {

			groupService.deleteGroupById(group.getId());
			return new ResponseEntity<Groups>(HttpStatus.ACCEPTED);
		}

		return new ResponseEntity(new CustomErrorType("Unable to Delete Groups" + group.getId() + " does not exist."),
				HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/listById", method = RequestMethod.POST)
	public ResponseEntity<?> getGroupById(@RequestParam Integer id, CustomErrorType customErrorType) {
		log.info("Inside GroupRestController getGroupById");
		if (groupService.isExist(id)) {
			List<Groups> groupList = groupService.getgroupsById(id);
			return new ResponseEntity(groupList, HttpStatus.OK);
		}
		return new ResponseEntity<>(new CustomErrorType("Id does not exist"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/editorList", method = RequestMethod.GET)
	public ResponseEntity getEditorDetail() {
		log.info("Inside GroupRestController getEditorDetail");
		List<Role> roleList = roleService.getRoleDetails();
		List<EditorVO> vos = new ArrayList<EditorVO>();

		for (int i = 0; i < roleList.size(); i++) {

			if (roleList.get(i).getRoleName().equalsIgnoreCase(RoleUtil.Editor)) {
				Integer roleid = roleList.get(i).getRoleId();
				List<Groups> group = groupService.getGroupDetailsByRoleId(roleid);

				for (int j = 0; j < group.size(); j++) {

					EditorVO vo = new EditorVO();
					vo.setId(group.get(j).getId());
					vo.setName(group.get(j).getGroupName());
					vos.add(vo);
				}
			}

		}
		return new ResponseEntity(vos, HttpStatus.OK);

	}

	@RequestMapping(value = "/managingEditorList", method = RequestMethod.GET)
	public ResponseEntity getCopyEditorDetail(Role role) {
		log.info("Inside GroupRestController getCopyEditorDetail");
		List<Role> roleList = roleService.getRoleDetails();
		List<ManagingEditorVO> vos = new ArrayList<ManagingEditorVO>();

		for (int i = 0; i < roleList.size(); i++) {

			if (roleList.get(i).getRoleName().equalsIgnoreCase(RoleUtil.ManagingEditor)) {
				Integer roleid = roleList.get(i).getRoleId();
				List<Groups> group = groupService.getGroupDetailsByRoleId(roleid);
				for (int j = 0; j < group.size(); j++) {
					ManagingEditorVO vo = new ManagingEditorVO();
					vo.setEditorId(group.get(j).getId());
					vo.setGroupName(group.get(j).getGroupName());
					vos.add(vo);
				}
			}

		}
		return new ResponseEntity(vos, HttpStatus.OK);

	}

}