package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserPost;
import com.example.demo.service.UserPostService;
// controls operations.
@RestController
public class UserPostController {
	@Autowired
	private UserPostService userPostService;
	
	@RequestMapping("/createPost")
	public String create(@RequestParam String content) {
		UserPost userpost = userPostService.create(content);
		return "userpost created";
	}
	
	@RequestMapping("/getAllPosts")
	public List<UserPost> getAll(){
		return userPostService.getAll();
	}
	
	@RequestMapping("/updatePost")
	public String update(@RequestParam String content) {
		UserPost userPost = userPostService.update(content);
		return userPost.toString();
	}
	
	@RequestMapping("/deletePost")
	public String delete(@RequestParam String content) {
		userPostService.delete(content);
		return "Deleted ";
	}
	
	
	  @RequestMapping("/deleteAllPosts") 
	  public String deleteAll() {
	  userPostService.deleteAll(); 
	  return "Deleted all records!";
	  }
	 
}
