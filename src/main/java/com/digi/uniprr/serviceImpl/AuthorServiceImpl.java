package com.digi.uniprr.serviceImpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptTypeJournalVO;
import com.digi.uniprr.VO.SignUpAuthorVo;
import com.digi.uniprr.model.Author;
import com.digi.uniprr.model.ManuscriptTypeJournal;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.AuthorRepo;
import com.digi.uniprr.repository.ManuscriptTypeJournalsRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.AuthorService;
import com.digi.uniprr.service.ForgotPassword;
import com.digi.uniprr.utils.ManuscriptTypeJournalTransformationUtils;
import com.digi.uniprr.utils.SendMailUtils;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	AuthorRepo authorRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	Environment env;

	@Autowired
	SendMailUtils mailUtils;
	
	@Autowired
	ManuscriptTypeJournalsRepo manuscriptTypeJournalsRepo;

	@Override
	public List<Author> getAuthorDetails() {
		return authorRepo.findAll();
	}

	@Override
	public List<Author> getAuthorListById(Integer authorId) {
		return authorRepo.getAuthorListById(authorId);
	}

	@Override
	public void createAuthor(Author author) {
		authorRepo.save(author);
	}

	@Override
	public void deleteAuthorById(Integer id) {
		authorRepo.deleteById(id);
	}

	@Override
	public boolean isExistById(Integer id) {
		boolean result=false;
		try {
			if(authorRepo.checkByUserId(id).isEmpty()) {
				result = true;
			}
		}catch(Exception e) {
			return result;
		}
		return result;
	}

	@Override
	public Boolean checkUnactiveUser(String email, String token, String checkUserStatus) {
		User user = null; //userRepo.checkUnactiveUser(email, token, checkUserStatus);
		Boolean status = false;
		if (user != null)
			status = true;

		return status;
	}

	@Override
	public void activateUser(String email, String clearToken, String userStatus) {
		//userRepo.activateUser(email, clearToken, userStatus);
	}

	@Override
	public String signUpAuthor(SignUpAuthorVo signUpAuthorVo) {
		try {
			User user = new User();
			Author author = new Author();
			author.setSalutation(signUpAuthorVo.getTitle());
			author.setFirstName(signUpAuthorVo.getFirstName());
			author.setLastName(signUpAuthorVo.getLastName());
			author.setAuthorEmail(signUpAuthorVo.getEmail());
			author.setInstitutionId(signUpAuthorVo.getInstitution());
			author.setOrcidid(signUpAuthorVo.getOrcid());
			authorRepo.save(author);

			String password = passwordEncoder.encode(signUpAuthorVo.getPassword());
			user.setSalutation(signUpAuthorVo.getTitle());
			user.setFirstName(signUpAuthorVo.getFirstName());
			user.setLastName(signUpAuthorVo.getLastName());
			user.setEmail(signUpAuthorVo.getEmail());
			user.setPassword(password);
			//user.setUserStatus("Locked");
			userRepo.save(user);

			String token = UUID.randomUUID().toString();
			sendMailForActivation(signUpAuthorVo.getEmail(), token);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String sendMailForActivation(String userEmail, String token) {

		userRepo.updateTokenByUser(userEmail, token);

		String fromMailID = env.getProperty("spring.mail.username");
		String toMailID = userEmail;
		String mailSubject = "Forgot Password";
		String mailBody = activateUserMailTemplate(userEmail, token);

		mailUtils.sendEmail(fromMailID, toMailID, mailSubject, mailBody);

		String message = "Password reset URL send on mail successfully.";

		return message;
	}

	private String activateUserMailTemplate(String email, String token) {

		StringBuilder builder = new StringBuilder();
		// String resetUrl = env.getProperty("ResetUrl");
		String resetUrl = "http://172.16.1.209:4200/signup/userverfication";
		String resetPasswordURL = resetUrl + "?token=" + token + "&email=" + email;

		builder.append("Dear User,");
		builder.append("Please activate your account " + resetPasswordURL);
		builder.append(" ");
		builder.append("THANK YOU !!");

		return builder.toString();
	}

	

}