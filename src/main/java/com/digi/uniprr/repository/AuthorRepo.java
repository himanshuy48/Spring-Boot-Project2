package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

	@Query("select a from Author a where a.authorId=:authorId")
	List<Author> getAuthorListById(Integer authorId);

	@Query("select a from Author a where a.userId=:id")
	List<Author> checkByUserId(Integer id);

}