package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Reviewer;

public interface ReviewerRepo extends JpaRepository<Reviewer, Integer> {

	@Query("SELECT r FROM Reviewer r WHERE r.id=:id")
	List<Reviewer> getReviewerById(Integer id);

}
