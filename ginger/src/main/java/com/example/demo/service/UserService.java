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
	
	//search
	public Users getByName(String firstName, String lastName) {
		return usersRepository.findByFirstNameOrLastName(firstName,lastName);
	}
	
	//update operation
	public Users update(Users user){
		Users x = usersRepository.findByFirstNameOrLastName(user.getFirstName(), user.getFirstName());
		x.setFirstName(user.getFirstName());
		x.setLastName(user.getLastName());
		return usersRepository.save(x);
	}
	
	public void addFriend(String name, String friend) {
		Users nameObj = usersRepository.findByFirstNameOrLastName(name, name);
		Users friendObj = usersRepository.findByFirstNameOrLastName(friend, friend);
		nameObj.addFrienToList(friendObj);
		usersRepository.save(nameObj);
	}
	
//	public Users friendAdd(String name, String friendName) {
//		Users user = usersRepository.findByFirstNameOrLastName(name, name);
//		Users friend = usersRepository.findByFirstNameOrLastName(friendName, friendName);
//		user.addFrienToList(friend);
//		return user;
//	}
	
	//Delete operation
	public void deleteAll() {
		usersRepository.deleteAll();
	}
	
	public void delete(String name) {
		Users user = usersRepository.findByFirstNameOrLastName(name, name);
		usersRepository.delete(user);
	}

	public List<Users> getFriendsList(String name) {
		Users x = usersRepository.findByFirstNameOrLastName(name, name);
		return x.getFriends();
	}

}
