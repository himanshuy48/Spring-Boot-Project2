package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ReviewerFilterVO;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.model.User;

public interface UserService {

	public void addUser(User user);

	public Iterable<User> getUserDetail(User user);

	void updateUser(UserVO userVO);

	User getByUsername(String username);

	public User getByEmail(String email);

	public boolean isUserExist(User user);

	public List<User> getGroupByUserId(Integer id);

	public User createUser(UserVO userVo);

	public List<UserVO> getUserDetails();

	public List<User> getUserListById(Integer id);

	public String deleteUserById(Integer id);

	public User getById(Integer id);
	
	public UserVO getUserById(Integer id);

	public UserVO getUserByEmailAndPassword(String email);

	public List<UserVO> getUserListByRoleId(List<Integer> roleId);

	public void assignUser(ManuscriptListVO manuscriptListVO);

	public void activateLockedUser(UserVO userVO);
	
	/*******Reviewer Filter********/
	public List<ReviewerVO> reviewerFilter(ReviewerFilterVO vo);
}
