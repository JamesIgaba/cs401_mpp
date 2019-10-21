package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
	
	public Users findByFirstNameOrLastNameOrFullName(String firstName, String lastName, String fullName);
	
	public Users findByEmail(String email);
	
	public List<Users> findByFullNameLikeIgnoreCase(String name);
	
}
