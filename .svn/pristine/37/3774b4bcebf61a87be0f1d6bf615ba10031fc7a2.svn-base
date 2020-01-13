package com.digi.uniprr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.digi.uniprr.VO.FunderDetailsVO;
import com.digi.uniprr.VO.ManuscriptFileVO;
import com.digi.uniprr.VO.ResubmissionManuscriptFileVo;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptFile;

public interface ManuScriptFileService 
{
    public String createManuScriptFile(ManuScriptFile manuScriptFile);
    
    public List<ManuScriptFile> getManuScriptFileDetails();
    
    public String updateManuScriptFileDetails(ManuScriptFile manuScriptFile);
    
    public String deleteManuScriptFileById(Integer id);
    
    public boolean isIdExist(Integer id);

	public List<ManuScriptFile> getFileDetailsById(ManuScriptFile manuScriptFile);

	public ManuScriptFile saveFile(ManuScriptFile manuScriptFile);
	
	public ManuScriptFile getListByManuscriptId(Integer id);

	public ManuScriptFile getManuScriptFile(ManuScriptFile manuscriptFile);
	
	public List<ManuscriptFileVO> getManuscriptByactive(Integer manuscriptId,Integer manuscriptVersion);
	
	public String deleteManuscriptFile(Integer manuscriptFileId);
	
	public String downloadFileByManuScriptFileID(Integer manuscriptFileId);
	
	public String updateManuscriptFileUpload(ResubmissionManuscriptFileVo resubmissionManuscriptFileVo,HttpServletRequest request);
	
	public List<FunderDetailsVO> getResearchFunders(FunderDetailsVO funderDetailsVO);
	
	public void saveManuscriptFunders(List<FunderDetailsVO> funderDetailsVO);
	
	public List<FunderDetailsVO> getManuscriptFunders(FunderDetailsVO funderDetailsVO);
	
	public ManuScript getManusManuScript(Integer id);
	
}
