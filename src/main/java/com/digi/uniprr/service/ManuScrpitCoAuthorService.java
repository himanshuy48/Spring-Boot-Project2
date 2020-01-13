package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.ManuscriptCoAuthorVO;
import com.digi.uniprr.model.User;

public interface ManuScrpitCoAuthorService {
	
//	boolean isExistById(Integer id);
	
	void createCoAuthor(ManuscriptCoAuthorVO manuscriptCoAuthorVO);
	
	List<User> isExistByMail(String email);

}
