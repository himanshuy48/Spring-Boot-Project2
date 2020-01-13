package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.UserJournalVO;
import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.UserJournalRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.UserJournalService;
import com.digi.uniprr.utils.UserTransformationalUtils;

@Service
@Transactional
public class UserJournalServiceImpl implements UserJournalService {

	@Autowired
	UserJournalRepo userJournalRepo;

	@Autowired
	UserRepo userRepo;

	@Override
	public List<UserVO> getListById(UserJournalVO userJournalVO) {
		List<UserJournalVO> uVO = new ArrayList<UserJournalVO>();
		List<UserVO> voList = new ArrayList<UserVO>();
		if (userJournalVO.getJournalId() == null || userJournalVO.getJournalId() == -1) {

			for (Integer mStatus : userJournalVO.getRoleID()) {

				List<User> userList = userRepo.getListByRoleId(mStatus);

				System.out.println("vasvklhasvbajsv " + userList.toString());
				for (User user : userList)
					voList.add(UserTransformationalUtils.mapUserModelToUserVO(user));

			}

		}

		else if (userJournalVO.getJournalId() > 0) {
			for (Integer roleID : userJournalVO.getRoleID()) {
				List<User> userList = userRepo.getListByjournaId(userJournalVO.getJournalId(), roleID);
				for (User user : userList) {
					voList.add(UserTransformationalUtils.mapUserModelToUserVO(user));
				}
			}
			
		}
		
		//Hack if journal don't have Editor
		
		if(voList ==null || voList.isEmpty()) {
			List<User> userData = userRepo.findAll();
			if(userData!=null && !userData.isEmpty()) {
				for(User tempUser : userData) {
					if(tempUser.getRole()!=null && !tempUser.getRole().isEmpty()) {
						for(Role role : tempUser.getRole()) {
							if(role!=null && role.getRoleId() == 3) {
								voList.add(UserTransformationalUtils.mapUserModelToUserVO(tempUser));
							}
						}
					}
				}
			}
		}
		// Hack End
		return voList;
//		
	}
//	
}
