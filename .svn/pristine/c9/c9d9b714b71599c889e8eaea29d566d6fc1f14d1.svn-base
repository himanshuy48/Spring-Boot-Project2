package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.EditorAvailability;
import com.digi.uniprr.model.MeAvailability;

public interface MeAvailabilityRepo extends JpaRepository<MeAvailability, Integer>{
	
	@Query("Select ma from MeAvailability ma where ma.meId=:id AND ma.isActive=1")
	List<MeAvailability> getManagingEditorAvailabilityById(Integer id);
	
	@Modifying
	@Query("Update MeAvailability ma set ma.isActive=0 where ma.id=:id")
	void deleteManagingEditorAvailabilityById(Integer id);
}
