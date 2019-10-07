package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	//create user
	public Users create(String firstName, String lastName, String email) {
		return usersRepository.save(new Users(firstName, lastName, email));
	}
	
	//retrieve operation
	public List<Users> getAll(){
		return usersRepository.findAll();
	}
	
	public Users getByFirstName(String firstName) {
		return usersRepository.findByFirstName(firstName);
	}
	
	//update operation
	public Users update(String firstName, String lastName, String email) {
		Users user = usersRepository.findByFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		return usersRepository.save(user);
	}
	
	//Delete operation
	public void deleteAll() {
		usersRepository.deleteAll();
	}
	
	public void delete(String firstName) {
		Users user = usersRepository.findByFirstName(firstName);
		usersRepository.delete(user);
	}

}
