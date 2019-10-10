package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("users/create")
	public String create(@RequestParam String firstName,  @RequestParam String lastName, @RequestParam String email) {
		Users user = userService.create(firstName, lastName, email);
		return user.toString();
	}
	//just testing
	//search users by first or last name
	@RequestMapping("/users/search")
	public Users getUser(@RequestParam String name) {
		return userService.getByName(name, name);
	}
	
	//add friend
	@RequestMapping("/users/addFriend")
	public void addFriend(String name, String friend) {
		userService.addFriend(name, friend);
	}
	
	//list friends
	@RequestMapping("/users/listFriends")
	public List<Users> listFriends(String name){
		return userService.getFriendsList(name);
	}
	
	@RequestMapping("/users/getAll")
	public List<Users> getAll(){
		return userService.getAll();
	}
	
	@RequestMapping("/users/update")
	//String firstName, @RequestParam String lastName, @RequestParam String email
	public String update(@RequestParam Users user) {
		userService.update(user);
		return user.toString() + " updated";
	}
	
	@RequestMapping("/users/delete")
	public String delete(@RequestParam String name) {
		userService.delete(name);
		return "Deleted " + name;
	}
	
	@RequestMapping("/users/deleteAll")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records!"; 
	}
}
