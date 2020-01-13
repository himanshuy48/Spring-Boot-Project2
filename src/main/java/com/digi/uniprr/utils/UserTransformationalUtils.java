package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.model.Journal;
import com.digi.uniprr.model.User;

public class UserTransformationalUtils {
	
	public static User mapVOToModel(UserVO userVo) {
		
		User user = new User();
		
		user.setAccountExpired(userVo.getAccountExpired());
		user.setAccountLocked(userVo.getAccountLocked());
		user.setAddress(userVo.getAddress());
		user.setAddressThree(userVo.getAddressThree());
		user.setAddressTwo(userVo.getAddressTwo());
		user.setAreaOfInterest(userVo.getAreaOfInterest());
		user.setCity(userVo.getCity());
		user.setCountryId(userVo.getCountryId());
		user.setDepartment(userVo.getDepartment());
		user.setDesignation(userVo.getDesignation());
		user.setEmail(userVo.getEmail());
		user.setEmailCC(userVo.getEmailCC());
		user.setEmailNotification(userVo.getEmailNotification());
		user.setExperience(userVo.getExperience());
		user.setExpertise(userVo.getExpertise());
		user.setFaxNumber(userVo.getFaxNumber());
		user.setFirstName(userVo.getFirstName());
		user.setId(userVo.getId());
		user.setInstitute(userVo.getInstitute());
		user.setIsActive(userVo.getIsActive());
		user.setLastName(userVo.getLastName());
		user.setMiddleName(userVo.getMiddleName());
		user.setMobileNumber(userVo.getMobileNumber());
		user.setNotificationFlag(userVo.getNotificationFlag());
		user.setOrcidId(userVo.getOrcidId());
		user.setPassword(userVo.getPassword());
		user.setPhoneNumber(userVo.getPhoneNumber());
		user.setPostalCode(userVo.getPostalCode());
		user.setPublicationName(userVo.getPublicationName());
		user.setSalutation(userVo.getSalutation());
		user.setSecondaryEmail(userVo.getSecondaryEmail());
		user.setSecondaryEmailCC(userVo.getSecondaryEmailCC());
		user.setSmsNotification(userVo.getSmsNotification());
		user.setSpecialization(userVo.getSpecialization());
		user.setState(userVo.getState());
		user.setToken(userVo.getToken());
		user.setUsername(userVo.getUsername());
		user.setUserType(userVo.getUserType());
		
		return user;
	}
	
	public static UserVO mapUserModelToUserVO(User user) {
		UserVO userVO = new UserVO();
		
		userVO.setId(user.getId());
		userVO.setOrcidId(user.getOrcidId());
		userVO.setUsername(user.getUsername());
		//userVO.setPassword(user.getPassword());
		userVO.setEmail(user.getEmail());
		userVO.setEmailCC(user.getEmailCC());
		userVO.setSecondaryEmail(user.getSecondaryEmail());
		userVO.setSecondaryEmailCC(user.getSecondaryEmailCC());
		userVO.setSalutation(user.getSalutation());
		userVO.setFirstName(user.getFirstName());
		userVO.setMiddleName(user.getMiddleName());
		userVO.setLastName(user.getLastName());
		userVO.setUserType(user.getUserType());
		userVO.setInstitute(user.getInstitute());
		userVO.setState(user.getState());
		userVO.setAddress(user.getAddress());
		userVO.setAddressTwo(user.getAddressTwo());
		userVO.setAddressThree(user.getAddressThree());
		userVO.setDepartment(user.getDepartment());
		userVO.setMobileNumber(user.getMobileNumber());
		userVO.setPhoneNumber(user.getPhoneNumber());
		userVO.setFaxNumber(user.getFaxNumber());
		userVO.setIsActive(user.getIsActive());
		userVO.setCountryId(user.getCountryId());
		userVO.setCity(user.getCity());
		userVO.setPostalCode(user.getPostalCode());
		userVO.setAreaOfInterest(user.getAreaOfInterest());
		userVO.setNotificationFlag(user.getNotificationFlag());
		userVO.setPublicationName(user.getPublicationName());
		userVO.setAccountExpired(user.getAccountExpired());
		userVO.setAccountLocked(user.getAccountLocked());
		userVO.setDesignation(user.getDesignation());
		userVO.setSpecialization(user.getSpecialization());
		userVO.setExperience(user.getExperience());
		userVO.setExpertise(user.getExpertise());
		userVO.setEmailNotification(user.getEmailNotification());
		userVO.setSmsNotification(user.getSmsNotification());
		userVO.setRole(RoleTransformationalUtils.mapRoleListToVOList(user.getRole()));
		userVO.setGroup(GroupTransformationalUtils.mapGroupListToGroupVOList(user.getGroup()));
		userVO.setJournalVO(JournalListTransformationUtils.mapModelListToVoList(user.getJournal()));
		
		return userVO;
	}
	
	public static List<User> mapUserVOListToUserList(List<UserVO> voList) {
		List<User> userList = new ArrayList<User>();
		for (UserVO userVO : voList) 
			userList.add(mapVOToModel(userVO));
		
		return userList;
	}
	
	public static List<UserVO> mapUserListToUserVOList(List<User> userList) {
		List<UserVO> voList = new ArrayList<UserVO>();
		for (User user : userList)
			voList.add(mapUserModelToUserVO(user));
		
		return voList;
	}

}
