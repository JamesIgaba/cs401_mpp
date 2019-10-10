package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{
	public Users findByFirstName(String firstName);
	
	
}
