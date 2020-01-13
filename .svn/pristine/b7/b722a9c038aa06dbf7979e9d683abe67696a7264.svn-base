package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.ManuScriptFile;

public interface ManuScriptFileRepo extends JpaRepository<ManuScriptFile, Integer> {

	@Query(value = "select * from manuscript_file where manuscript_file_id=:manuscriptFileId", nativeQuery = true)
	List<ManuScriptFile> getFileDetailsById(Integer manuscriptFileId);

	@Query(value="SELECT * from manuscript_file where manuscript_file_id=:id" , nativeQuery = true)
	ManuScriptFile getById(Integer id);

	@Query("select m from ManuScriptFile m where m.manuscriptFileId=:manuscriptFileId AND m.fileName=:fileName")
	ManuScriptFile getManuscriptFileDetilsById(Integer manuscriptFileId, String fileName);

	@Modifying
	@Query("update ManuScriptFile m set m.fileType=:fileType,m.legend=:legend,m.fileVersion=:fileVersion where m.manuscriptFileId=:manuscriptFileId")
	void submitManuscript(Integer manuscriptFileId, String fileType,Integer legend,Integer fileVersion);
	
	@Query("select mf from ManuScriptFile mf where mf.manuScriptId=:Id")
	List<ManuScriptFile> getManuscriptFileById(Integer Id);

	
	@Query("select m from ManuScriptFile m  where m.manuScriptId=:manuscriptId AND m.isActive=:active AND m.fileVersion=:manuscriptVersion ORDER BY m.manuscriptFileId DESC")
	List<ManuScriptFile> getManuscriptByactive(Integer manuscriptId,Integer manuscriptVersion, Integer active);
	
	@Query("select m from ManuScriptFile m where m.manuscriptFileId=:manuscriptFileId")
	ManuScriptFile downloadFileByManuScriptFileID(Integer manuscriptFileId);
	
	@Query("select m from ManuScriptFile m where m.manuScriptId=:manuScriptId AND m.fileType='MergedFile'")
	ManuScriptFile getManuScriptFileData(Integer manuScriptId);
	
	@Query("select m from ManuScriptFile m where m.manuScriptId=:manuScriptId AND m.fileType='Main Documents' AND m.isActive=:active")
	ManuScriptFile getManuScriptFile(Integer manuScriptId,Integer active);
	
	@Query("SELECT m FROM ManuScriptFile m where m.manuScriptId=:manuScriptId AND m.fileType='Copyright Form' AND m.isActive=:active")
	ManuScriptFile getCopyRightFile(Integer manuScriptId,Integer active);
	
	@Query("SELECT m FROM ManuScriptFile m WHERE m.manuScriptId=:manuScriptId AND m.fileType='Main Documents' AND m.isActive=:active ")
	ManuScriptFile getMainFinalDocument(Integer manuScriptId,Integer active );
	
	@Query("SELECT m FROM ManuScriptFile m where m.manuScriptId=:manuScriptId AND m.fileType='Main Documents' AND m.isActive=:active")
	ManuScriptFile getManuScriptDocumentFile(Integer manuScriptId,Integer active);
}
