package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Like;
public interface LikeRepository extends MongoRepository<Like, String>{
	
	public Like findByLikeId(String likeId);

}
