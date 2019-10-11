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
	public Users create(String firstName, String lastName, String email, String password) {
		return usersRepository.save(new Users(firstName, lastName, email, password));
	}
	
	//login
	public Users loginService(String email,String password) {
		Users x = usersRepository.findByEmail(email);
		if(x.getPassword().equals(password))
			return x;
		return null;
	}
	
	//retrieve operation
	public List<Users> getAll(){
		return usersRepository.findAll();
	}
	
	//search
	public Users getByName(String firstName, String lastName, String fullName) {
		return usersRepository.findByFirstNameOrLastNameOrFullName(firstName,lastName,fullName);
	}
	
	//update operation
	public Users update(Users user){
		Users x = usersRepository.findByFirstNameOrLastNameOrFullName(user.getFirstName(), user.getFirstName(), user.getFullName());
		x.setFirstName(user.getFirstName());
		x.setLastName(user.getLastName());
		return usersRepository.save(x);
	}
	
	//add friend service passing by names
	/*
	 * public void addFriend(String name, String friend) { Users nameObj =
	 * usersRepository.findByFirstNameOrLastNameOrFullName(name, name,name); Users
	 * friendObj = usersRepository.findByFirstNameOrLastNameOrFullName(friend,
	 * friend, friend); nameObj.addFrienToList(friendObj);
	 * usersRepository.save(nameObj); }
	 */
	
	//add friend passing objects
	public void addFriend(String userEmailId , String friendEmailId) {
		Users user = usersRepository.findByEmail(userEmailId);
		user.addFriendToList(friendEmailId);
		usersRepository.save(user);
	}
	
	//sending friend request
	public void sendFriendRequestService(String userEmailId , String friendEmailId) {
		Users user = usersRepository.findByEmail(userEmailId);
		user.addFriendRequest(friendEmailId);
		usersRepository.save(user);
	}
	
	//Delete operation
	public void deleteAll() {
		usersRepository.deleteAll();
	}
	
	public void delete(String name) {
		Users user = usersRepository.findByFirstNameOrLastNameOrFullName(name, name,name);
		usersRepository.delete(user);
	}

	public List<Users> getFriendsList(String userEmailId) {
		Users user = usersRepository.findByEmail(userEmailId);
		List <Users> friends = new ArrayList<Users>();
		for(String x : user.getFriends()) {
			friends.add(usersRepository.findByEmail(x));
		}
		return friends;
	}

	//find by email service
	public Users getByEmailService(String email) {
		return usersRepository.findByEmail(email);
	}

}
