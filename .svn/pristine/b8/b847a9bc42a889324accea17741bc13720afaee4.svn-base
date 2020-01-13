package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.Publishers;
import com.digi.uniprr.repository.PublisherRepo;
import com.digi.uniprr.service.PublisherService;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService 
{

	@Autowired
	PublisherRepo publisherRepo;
	
	@Override
	public String createPublisher(Publishers publishers) {
		publisherRepo.save(publishers);
		return null;
	}

	@Override
	public boolean isIdExist(Integer id) {
		
		return publisherRepo.existsById(id);
	}

	@Override
	public List<Publishers> getPublishersList() {
		
		return publisherRepo.findAll();
	}

	@Override
	public String updatePublisherDetails(Publishers publishers) 
	{
		publisherRepo.save(publishers);
		return "Updated";
	}

	@Override
	public String deleteById(Integer id) 
	{
		publisherRepo.deletePublisherById(id);
		return "Deleted successfully";
	}

}
