package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Publishers;

public interface PublisherRepo extends JpaRepository<Publishers, Integer> {

	@Modifying
	@Query("delete from Publishers p where p.publisherId=:id")
	void deletePublisherById(Integer id);

}
