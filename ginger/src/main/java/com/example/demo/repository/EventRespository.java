package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Event;

@Repository
public interface EventRespository extends MongoRepository<Event, String>{

	public List<Event> findByNameIgnoreCase(String name);
	
	public List<Event> findByUserEmailId(String userEmailId);
	
}
