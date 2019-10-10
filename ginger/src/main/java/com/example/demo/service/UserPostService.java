package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserPost;
import com.example.demo.repository.UserPostRepository;

@Service
public class UserPostService {

	@Autowired
	private UserPostRepository userPostRepository;
	private UserPost up;
	
		//create user_post
		public UserPost create(String content) {
			return userPostRepository.save(new UserPost(content));
		}

		//Retrieve operation
		public List<UserPost> getAll(){
			return userPostRepository.findAll();
		}
		
		//Delete post
		public void delete(String content) {
			UserPost userPost = userPostRepository.findByContent(content);
				userPostRepository.delete(userPost);
		}
		
		public void deleteAll() {
			userPostRepository.deleteAll();
		}

	  //Update operation 
		public UserPost update(String content) { 
			if(this.up.getContent().equals(content)) {
				up.setContent(content);
			}
			return userPostRepository.save(up); 
		}
}
