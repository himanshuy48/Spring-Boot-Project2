package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.EditorAvailability;

public interface EditorAvailabilityRepo extends JpaRepository<EditorAvailability, Integer> {

	@Query("Select ea from EditorAvailability ea where ea.editorId=:id AND ea.isActive=1")
	List<EditorAvailability> getEditorAvailabilityById(Integer id);
	
	@Modifying
	@Query("Update EditorAvailability ea set ea.isActive=0 where ea.id=:id")
	void deleteReviewerAvailabilityById(Integer id);

}
