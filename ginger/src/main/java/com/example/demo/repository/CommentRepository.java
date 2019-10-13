package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{
	
	public Comment findByCommentId(String commentId);

}
