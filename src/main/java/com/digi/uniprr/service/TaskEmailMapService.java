package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.TaskEmailMap;

public interface TaskEmailMapService {

	List<TaskEmailMap> customiseMailTemplate(Integer id);
	
	public TaskEmailMap saveTaskEmailMap(TaskEmailMap taskEmailMap);
	
	public void deleteTaskEmailMap(Integer id);

}
