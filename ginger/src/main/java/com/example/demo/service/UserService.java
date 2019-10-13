package com.example.demo.service;

import java.time.LocalDate;
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
	public Users create(String firstName, String lastName, String email, 
			String password, int year, int month,int day, String gender) throws NullPointerException{
		if(!usersRepository.findById(email).isPresent())
			return usersRepository.save(new Users(firstName, lastName, email, password, LocalDate.of(year, month, day), gender));
		else
			throw new NullPointerException("Email entered has been registered before.");
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
		Users x = usersRepository.findByEmail(user.getEmail());
		x.setFirstName(user.getFirstName());
		x.setLastName(user.getLastName());
		x.setGender(user.getGender());
		x.setHobbies(x.getHobbies());
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
		user.getFriendRequests().remove(friendEmailId);
		user.addFriendToList(friendEmailId);
		usersRepository.save(user);
	}
	
	//sending friend request
	public void sendFriendRequestService(String userEmailId , String friendEmailId) {
		Users friend = usersRepository.findByEmail(friendEmailId);
		friend.addFriendRequest(userEmailId);
		usersRepository.save(friend);
	}
	
	//Delete operation
	public void deleteAll() {
		usersRepository.deleteAll();
	}
	
	public void delete(String userEmailId) {
		Users user = usersRepository.findByEmail(userEmailId);
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
	
	//serching users with 'like'
	public List<Users> searchUsers(String name){
		return usersRepository.findByFullNameLikeIgnoreCase(name);
	}
	
	//decline friend request service
	public void declineFriendService(String userEmailId, String friendEmailId) {
		Users x = usersRepository.findByEmail(userEmailId);
		x.getFriendRequests().remove(friendEmailId);
		usersRepository.save(x);
	}

	public List<Users> getFriendRequestList(String userEmailId) {
		Users user = usersRepository.findByEmail(userEmailId);
		List <Users> friendRequests = new ArrayList<Users>();
		for(String x : user.getFriendRequests()) {
			friendRequests.add(usersRepository.findByEmail(x));
		}
		return friendRequests;
	}

}
