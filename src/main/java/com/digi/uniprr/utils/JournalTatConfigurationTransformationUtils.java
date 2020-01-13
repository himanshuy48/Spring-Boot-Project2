package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.JournalTatConfigurationVO;
import com.digi.uniprr.model.JournalTatConfiguration;

public class JournalTatConfigurationTransformationUtils {
	
	public static JournalTatConfigurationVO mapModelToVO(JournalTatConfiguration jat) {
		JournalTatConfigurationVO vo = new JournalTatConfigurationVO();
		vo.setId(jat.getBufferedTime());
		vo.setJournalId(jat.getJournalId());
		if (jat.getStatusMaster() != null)
			vo.setStatus(jat.getStatusMaster().getStatusDesc());
		
		vo.setStatusId(jat.getStatusId());
		vo.setTurnAroundTime(jat.getTurnAroundTime());
		vo.setBufferedTime(jat.getBufferedTime());
		vo.setRequiredAlert(jat.getRequiredAlert());
		return vo;
	}
	
	public static JournalTatConfiguration mapVOToModel(JournalTatConfigurationVO vo) {
		JournalTatConfiguration jat = new JournalTatConfiguration();
		jat.setId(vo.getId());
		jat.setJournalId(vo.getJournalId());
		jat.setStatusId(vo.getStatusId());
		jat.setTurnAroundTime(vo.getTurnAroundTime());
		jat.setBufferedTime(vo.getBufferedTime());
		jat.setRequiredAlert(vo.getRequiredAlert());
		return jat;
	}
	
	public static List<JournalTatConfigurationVO> mapModelListToVOList(List<JournalTatConfiguration> jatList) {
		List<JournalTatConfigurationVO> voList = new ArrayList<JournalTatConfigurationVO>();
		for (JournalTatConfiguration jat : jatList) 
			voList.add(mapModelToVO(jat));
			
		return voList;
	}
	
	public static List<JournalTatConfiguration> mapVoListToModelList(List<JournalTatConfigurationVO> voList) {
		List<JournalTatConfiguration> jatList = new ArrayList<JournalTatConfiguration>();
		for (JournalTatConfigurationVO vo : voList) 
			jatList.add(mapVOToModel(vo));
		
		return jatList;
	}

}
