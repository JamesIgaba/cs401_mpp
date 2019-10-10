package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository usersRepository;

	//create user
	public Users create(String firstName, String lastName, String email) {
		return usersRepository.save(new Users(firstName, lastName, email));
	}

	//Retrieve operation
	public List<Users> getAll(){
		return usersRepository.findAll();
	}

	public Users getByFirstName(String firstName) {
		return usersRepository.findByFirstName(firstName);
	}

	//Update operation
	public Users update(String firstname, String lastname, String email) {
		Users user = usersRepository.findByFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		return usersRepository.save(user);
	}

	//Delete operation
	public void deleteAll() {
		usersRepository.deleteAll();
	}

	public void delete(String firstname) {
		Users user = usersRepository.findByFirstName(firstname);
		usersRepository.delete(user);
	}
}
