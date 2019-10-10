package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
		Users user = userService.create(firstName, lastName, email);
		return "user created";
	}
	
	@RequestMapping("/get")
	public Users getUser(@RequestParam String firstName) {
		return userService.getByFirstName(firstName);
	}
	
	@RequestMapping("/getAll")
	public List<Users> getAll(){
		return userService.getAll();
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
		Users user = userService.update(firstName, lastName, email);
		return user.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName) {
		userService.delete(firstName);
		return "Deleted " + firstName;
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records!"; 
	}
}
