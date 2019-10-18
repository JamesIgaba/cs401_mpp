package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//login here
	@RequestMapping("/login")
	public Users login (String email, String password) {
		return userService.loginService(email, password);
	}
	
	//create user
	/*
	 * @RequestMapping("/create") public String create(@RequestBody Users user) {
	 * Users x = userService.create(user.getFirstName(), user.getLastName(),
	 * user.getEmail(), user.getPassword()); return x.getFullName() +
	 * "'s ccount created" ; }
	 */
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, 
			@RequestParam String password, @RequestParam int year, @RequestParam int month, @RequestParam int day, 
			String gender) {
		Users x = userService.create(firstName, lastName, email, password, year, month, day, gender);
		return x.getFullName() + "'s ccount created" ;
	}
	
	//get user object by email
	@RequestMapping("/getByEmail")
	public Users getByEmail(String email) {
		return userService.getByEmailService(email);
	}
	
	//searching users by entering any string
	@RequestMapping("/search")
	public List<Users> getUserByLike(@RequestParam String name) {
		return userService.searchUsers(name);
	}
	
	//send friend request
	@RequestMapping("/sendFriendRequest")
	public void sendFriendRequest(@RequestParam String userEmailId, @RequestParam String friendEmailId) {
		userService.sendFriendRequestService(userEmailId, friendEmailId);
	}
	
	//accept friend request
	@RequestMapping("/addFriend")
	public void addFriend(@RequestParam String userEmailId, @RequestParam String friendEmailId) {
		userService.addFriend(userEmailId, friendEmailId);
	}
	
	//reject friend request
	@RequestMapping("/declineFriend")
	public void declineFriend(@RequestParam String userEmailId, @RequestParam String friendEmailId) {
		userService.declineFriendService(userEmailId, friendEmailId);
	}
	
	//list friends
	@RequestMapping("/listFriends")
	public List<Users> listFriends(String userEmailId){
		return userService.getFriendsList(userEmailId);
	}
	
	//list friend requests
	@RequestMapping("/listFriendRequests")
	public List<Users> listFriendRequests(String userEmailId){
		return userService.getFriendRequestList(userEmailId);
	}
	
	@RequestMapping("/getAll")
	public List<Users> getAll(){
		return userService.getAll();
	}
	
	@RequestMapping("/update")
	//String firstName, @RequestParam String lastName, @RequestParam String email
	public String update(@RequestParam Users user) {
		userService.update(user);
		return user.toString() + " updated";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String userEmailId) {
		userService.delete(userEmailId);
		return "Deleted " + userEmailId;
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records!"; 
	}
}
