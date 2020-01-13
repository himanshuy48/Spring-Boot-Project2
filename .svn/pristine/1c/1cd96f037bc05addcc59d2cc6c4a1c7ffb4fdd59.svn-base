package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.ManuscriptCoAuthorVO;
import com.digi.uniprr.model.ManuScriptCoAuthor;

public class ManuscriptCoAuthorTransformationUtils {
	
	public static ManuscriptCoAuthorVO mapModelToVo(ManuScriptCoAuthor coAuthor) {
		
		ManuscriptCoAuthorVO vo = new ManuscriptCoAuthorVO();
		vo.setId(coAuthor.getId());
		vo.setFirstName(coAuthor.getUser().getFirstName());
		vo.setMiddleName(coAuthor.getUser().getMiddleName());
		vo.setLastName(coAuthor.getUser().getLastName());
		vo.setAddress(coAuthor.getUser().getAddress());
		vo.setAddressTwo(coAuthor.getUser().getAddressTwo());
		vo.setAddressThree(coAuthor.getUser().getAddressThree());
		vo.setEmail(coAuthor.getUser().getEmail());
		vo.setInstitution(coAuthor.getUser().getInstitute());
		vo.setSalutation(coAuthor.getUser().getSalutation());
		vo.setOrder(coAuthor.getAuthorOrder());
		
		return vo;
	}
	
	public static List<ManuscriptCoAuthorVO> mapModelListToVoList(List<ManuScriptCoAuthor> list) {
		List<ManuscriptCoAuthorVO> voList = new ArrayList<ManuscriptCoAuthorVO>();
		
		for (ManuScriptCoAuthor author : list)
			voList.add(mapModelToVo(author));
		
		return voList;
	}

}
