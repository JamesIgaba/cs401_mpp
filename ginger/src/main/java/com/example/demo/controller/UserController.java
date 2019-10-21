package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	//login
	@RequestMapping("/login")
	public Users login (String email, String password) {
		Users user = userService.loginService(email, password);
		if(user!=null)
			return user;
		return new Users(null, null, null, null,null,0,0,0);
	}
	
	//create user
	/*
	 * @RequestMapping("/create") public String create(@RequestBody Users user) {
	 * Users x = userService.create(user.getFirstName(), user.getLastName(),
	 * user.getEmail(), user.getPassword()); return x.getFullName() +
	 * "'s ccount created" ; }
	 */
	
//	@RequestMapping("/create")
//	public Users create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, 
//			@RequestParam String password, @RequestParam int year, @RequestParam int month, @RequestParam int day, 
//			String gender) {
//		Users x = userService.create(firstName, lastName, email, password, year, month, day, gender);
//		return x;
//	}
	@RequestMapping("/create")
	public Users create(@RequestBody Users user) {
		Users x = userService.create(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),user.getGender(),user.getYear()
				,user.getMonth(),user.getDay());
		return x;
	}
	//get user object by email
	@RequestMapping("/getByEmail")
	public Users getByEmail(String email) {
		Users user= userService.getByEmailService(email);
		if(user!=null)
			return user;
		return new Users(null, null, null, null,null,0,0,0);
	}
	
	//searching users by entering any string
	@RequestMapping("/search")
	public List<Users> getUserByLike(@RequestParam String name) {
		return userService.searchUsers(name);
	}
	
	//send friend request
	@RequestMapping("/sendFriendRequest")
	public Users sendFriendRequest(@RequestParam String userEmailId, @RequestParam String friendEmailId) {
		return userService.sendFriendRequestService(userEmailId, friendEmailId);
	}
	
	//accept friend request
	@RequestMapping("/addFriend")
	public Users addFriend(@RequestParam String userEmailId, @RequestParam String friendEmailId) {
		return userService.addFriend(userEmailId, friendEmailId);
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
	
	@RequestMapping("/getChart1")
	public Map<String, Integer> getChart1(){
		Map<String, Integer> interestsList = new HashMap<String, Integer>();
		interestsList.put("Reading",20);
		interestsList.put("PlayingSports",13);
		interestsList.put("Chess",18);
		return interestsList;
	}
	
	@RequestMapping("/getChart2")
	public Map<String, Integer> getChart2(){
		Map<String, Integer> interestsList = new HashMap<String, Integer>();
		interestsList.put("Male",400);
		interestsList.put("Female",300);
		return interestsList;
	}
}
