package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ForgotPassword;
import com.digi.uniprr.utils.SendMailUtils;


@Service
@Transactional
public class ForgotPasswordImpl implements ForgotPassword {

	@Autowired
	SendMailUtils mailUtils;

	@Autowired
	UserRepo userRepo;

	@Autowired
	Environment env;

	@Override
	public String sendMailForPassword(String userEmail, String token) {

		userRepo.updateTokenByUser(userEmail,token);
		
		String fromMailID = env.getProperty("spring.mail.username");
		String toMailID = userEmail;
		String mailSubject = "Forgot Password";
		String mailBody = ForgotPasswaordMailTemplate(token);

		mailUtils.sendEmail(fromMailID, toMailID, mailSubject, mailBody);

		String message = "Password reset URL send on mail successfully.";

		return message;
	}

	private String ForgotPasswaordMailTemplate(String token) {

		StringBuilder builder = new StringBuilder();
		String resetUrl="http://172.16.1.209:4200/resetpassword";
		String resetPasswordURL = resetUrl + "?token=" +token;

		builder.append("Dear User, ");
		builder.append("Please use this link to reset your password : " + resetPasswordURL );
		builder.append(" ");
		builder.append("THANK YOU !! ");

		return builder.toString();
	}

	@Override
	public List<User> findUserDetailsByToken(String token) {
		return userRepo.findUserDetailsByToken(token);
	}

	@Override
	public void saveUpdatedPassword(String token, String password) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		userRepo.updateUserPassword(encodedPassword, token);
		userRepo.deleteTokenByUser(token,"");
		
		
	}

}