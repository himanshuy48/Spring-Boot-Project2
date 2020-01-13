package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManscriptScore;

public interface ManscriptScoreRepo extends JpaRepository<ManscriptScore, Integer>{

	//@Query("select m from ManscriptScore m where m.manuScriptId=:manuScriptId")
	@Query(value="Select * from manscript_score where manu_script_id=:manuScriptId", nativeQuery = true)
	ManscriptScore getManscriptScoreData(Integer manuScriptId);
}
