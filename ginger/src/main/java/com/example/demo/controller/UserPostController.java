package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserPost;
import com.example.demo.service.UserPostService;

@RequestMapping("/post")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserPostController {
	@Autowired
	private UserPostService userPostService;
	
	@RequestMapping("/create")
	public UserPost create(@RequestBody UserPost usrPost) {
		UserPost userpost = userPostService.create(usrPost.getUserId(), usrPost.getContent());
		return userpost;
	}
	@RequestMapping("/get")
	public UserPost getPostById(@RequestParam String postId){
		return userPostService.getPost(postId);
	}
	
	@RequestMapping("/getAll")
	public List<UserPost> getAll(){
		return userPostService.getAll();
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody UserPost usrPost) {
		UserPost userPost = userPostService.update(usrPost.getContent());
		return userPost.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String postId) {
		userPostService.delete(postId);
		return "Deleted ";
	}
	
	
	  @RequestMapping("/deleteAll") 
	  public String deleteAll() {
	  userPostService.deleteAll(); 
	  return "Deleted all records!";
	  }
	 
}
