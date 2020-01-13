package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer>{

	@Query("SELECT s from Subject s where s.isActive=1")
	List<Subject> getSubjectList();

	@Modifying
	@Query("UPDATE Subject s set s.isActive=0 where s.id=:id")
	void deleteSubject(Integer id);

}
