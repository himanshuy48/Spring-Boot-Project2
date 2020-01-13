package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptCoAuthorVO;
import com.digi.uniprr.model.ManuScriptCoAuthor;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.model.User;
import com.digi.uniprr.model.UserRole;
import com.digi.uniprr.repository.ManuScriptCoAuthorRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.repository.UserRoleRepo;
import com.digi.uniprr.service.ManuScrpitCoAuthorService;
import com.digi.uniprr.utils.SendMailUtils;

@Service
@Transactional
public class ManuScriptCoAuthorServiceImpl implements ManuScrpitCoAuthorService {

	@Autowired
	ManuScriptCoAuthorRepo manuScriptCoAuhor;

	@Autowired
	Environment env;

	@Autowired
	SendMailUtils mailUtils;

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserRoleRepo userRoleRepo;

	@Override
	public void createCoAuthor(ManuscriptCoAuthorVO manuscriptCoAuthorVO) {
		boolean authorRole = false;
		if (manuscriptCoAuthorVO.getId() != null) {
			User user = userRepo.getOne(manuscriptCoAuthorVO.getId());
			if (user != null) {
				if (user.getRole() != null && !user.getRole().isEmpty()) {
					for (Role role : user.getRole()) {
						if (role.getRoleId() == 4) {
							authorRole = true;
						}
					}
					if (!authorRole) {
						UserRole userRole = new UserRole();
						userRole.setUser(user.getId());
						userRole.setRole(4);
						userRoleRepo.save(userRole);
					}
				} else {
					UserRole userRole = new UserRole();
					userRole.setUser(user.getId());
					userRole.setRole(4);
					userRoleRepo.save(userRole);
				}

				ManuScriptCoAuthor manuScriptCoAuthor = new ManuScriptCoAuthor();
				manuScriptCoAuthor.setCoAuthorId(manuscriptCoAuthorVO.getId());
				manuScriptCoAuthor.setCoAuthorManuscriptId(manuscriptCoAuthorVO.getManuscriptId());
				manuScriptCoAuthor.setAuthorOrder(manuscriptCoAuthorVO.getOrder());
				manuScriptCoAuthor.setCorrespondingAuthor(manuscriptCoAuthorVO.getCorrespondingAuthor());
				manuScriptCoAuthor.setCoAuthorStatus(1);
				manuScriptCoAuhor.save(manuScriptCoAuthor);
				sendMailForActivation(user.getEmail());

			}
		}

	}

	@Override
	public List<User> isExistByMail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public String sendMailForActivation(String userEmail) {
		String fromMailID = env.getProperty("spring.mail.username");
		String toMailID = userEmail;
		String mailSubject = "Nottification for Co-Author";
		String mailBody = activateUserMailTemplate(userEmail);
		mailUtils.sendEmail(fromMailID, toMailID, mailSubject, mailBody);
		String message = "Password reset URL send on mail successfully.";
		return message;
	}

	private String activateUserMailTemplate(String email) {
		StringBuilder builder = new StringBuilder();
		builder.append("Dear User, \n");
		builder.append("Now you are also a Co-Author \n");
		builder.append("\n ");
		builder.append("THANK YOU !!");
		return builder.toString();
	}

}
