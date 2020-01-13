package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.TaskEmailMap;
import com.digi.uniprr.repository.TaskEmailMapRepo;
import com.digi.uniprr.service.TaskEmailMapService;

@Service
@Transactional
public class TaskEmailMapServiceImpl implements TaskEmailMapService 
{
	@Autowired
	private TaskEmailMapRepo taskEmailMapRepo;

	@Override
	public List<TaskEmailMap> customiseMailTemplate(Integer id) {
		return taskEmailMapRepo.customiseMailTemplate(id);
	}

	@Override
	public TaskEmailMap saveTaskEmailMap(TaskEmailMap taskEmailMap) {
		return taskEmailMapRepo.save(taskEmailMap);
	}

	@Override
	public void deleteTaskEmailMap(Integer id) {
		taskEmailMapRepo.deleteById(id);
	
	}

}
