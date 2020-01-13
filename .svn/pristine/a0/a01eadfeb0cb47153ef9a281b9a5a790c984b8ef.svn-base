package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ReviewerSuggested;
import com.digi.uniprr.model.User;

public interface ReviewerSuggestedRepo extends JpaRepository<ReviewerSuggested, Integer> {
	 
	@Query("SELECT u from User u where u.email=:email")
	User findByEmail(String email);

	@Query("SELECT u from ReviewerSuggested u where u.email=:email")
	ReviewerSuggested findByEmailId(String email);


}
