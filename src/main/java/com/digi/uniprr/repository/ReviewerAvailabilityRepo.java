package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ReviewerAvailability;



public interface ReviewerAvailabilityRepo extends JpaRepository<ReviewerAvailability, Integer>{

	@Query("select rva from ReviewerAvailability rva where rva.reviewerId=:id AND rva.isActive=1")
	List<ReviewerAvailability> getReviewerAvailabilityById(Integer id);
	
	@Modifying
	@Query("update ReviewerAvailability rva set rva.isActive=0 where rva.ra_id=:id")
	void deleteReviewerAvailabilityById(Integer id);

	@Query("SELECT rva from ReviewerAvailability rva where rva.isActive=1")
	List<ReviewerAvailability> getAllReviewerAvailability();
}
