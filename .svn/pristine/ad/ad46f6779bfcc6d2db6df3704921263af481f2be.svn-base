package com.digi.uniprr.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String fromMailID, String toMailID, String mailSubject, String mailBody) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromMailID);
		msg.setTo(toMailID);
		msg.setSubject(mailSubject);
		msg.setText(mailBody);

		javaMailSender.send(msg);
	}
}
