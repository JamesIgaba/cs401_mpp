package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
	//public Users findByFirstName(String firstName);
	public Users findByFirstNameOrLastName(String firstName, String lastName);
	
}
