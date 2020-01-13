
package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.ManuscriptTypeJournalVO;
import com.digi.uniprr.VO.SignUpAuthorVo;
import com.digi.uniprr.model.Author;
import com.digi.uniprr.model.Institution;
import com.digi.uniprr.model.ManuscriptTypeJournal;

public interface AuthorService {

	List<Author> getAuthorDetails();

	List<Author> getAuthorListById(Integer authorId);

	void createAuthor(Author author);

	void deleteAuthorById(Integer id);

	boolean isExistById(Integer id);

	String signUpAuthor(SignUpAuthorVo signUpAuthorVo);

	Boolean checkUnactiveUser(String email, String token, String checkUserStatus);

	void activateUser(String email, String clearToken, String userStatus);
	
}
