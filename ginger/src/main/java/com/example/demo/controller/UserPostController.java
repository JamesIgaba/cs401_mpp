package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserPost;
import com.example.demo.service.UserPostService;

@RequestMapping("/post")
@RestController
public class UserPostController {
	@Autowired
	private UserPostService userPostService;
	
	@RequestMapping("/create")
	public UserPost create(@RequestParam String userId, @RequestParam String content) {
		UserPost userpost = userPostService.create(userId, content);
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
	public String update(@RequestParam String content) {
		UserPost userPost = userPostService.update(content);
		return userPost.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String content) {
		userPostService.delete(content);
		return "Deleted ";
	}
	
	
	  @RequestMapping("/deleteAll") 
	  public String deleteAll() {
	  userPostService.deleteAll(); 
	  return "Deleted all records!";
	  }
	 
}
