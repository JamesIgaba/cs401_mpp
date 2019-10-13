package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserPost;
@Repository
public interface UserPostRepository extends MongoRepository<UserPost, String>{

	public UserPost findByContent(String content);
	public UserPost findByPostId(String postId);
}
