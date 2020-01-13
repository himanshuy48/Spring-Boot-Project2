package com.digi.uniprr.service;
import java.util.List;

import com.digi.uniprr.model.User;


public interface ForgotPassword {
	
	public String sendMailForPassword(String userEmail, String token);
	
	public List<User> findUserDetailsByToken(String token);
	
	public void saveUpdatedPassword(String token, String password);
	
}
