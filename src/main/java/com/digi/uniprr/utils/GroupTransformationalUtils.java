package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.GroupVO;
import com.digi.uniprr.model.Groups;

public class GroupTransformationalUtils {

	public static Groups mapVOToModel(GroupVO groupVo) {
		Groups groups = new Groups();

		groups.setId(groupVo.getId());
		groups.setGroupName(groupVo.getGroupName());
		groups.setCreatedBy(groupVo.getCreatedBy());
		groups.setUpdatedBy(groupVo.getModifiedBy());

		return groups;
	}
	
	public static GroupVO mapGroupModelToGroupVO(Groups group) {
		GroupVO vo = new GroupVO();
        vo.setId(group.getId());
        vo.setGroupName(group.getGroupName());
        return vo;
	}
	
	public static List<Groups> mapGroupVOListToGroupModelList(List<GroupVO> voList) {
		List<Groups> groupList = new ArrayList<Groups>();
		for (GroupVO vo : voList)
			groupList.add(mapVOToModel(vo));
		
		return groupList;
	}
	
	public static List<GroupVO> mapGroupListToGroupVOList(List<Groups> groupList) {
		List<GroupVO> voList = new ArrayList<GroupVO>();
		for (Groups group : groupList)
			voList.add(mapGroupModelToGroupVO(group));
		
		return voList;
	}

}
