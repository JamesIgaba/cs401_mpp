package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	private Comment com;
	
			//create comment
			public Comment create(String commentUserId, String content, String postId) {
				return commentRepository.save(new Comment(commentUserId, content, postId));
			}
			public List<Comment> getCommentByPostId(String postId) {
				return commentRepository.findByPostId(postId);
			}
			public int countCommentByPostId(String postId) {
				return commentRepository.findByPostId(postId).size();
			}
			//Retrieve operation
			public Comment getComment(String commentId) {
				return commentRepository.findByCommentId(commentId);
			}
			
			public List<Comment> getAll(){
				return commentRepository.findAll();
			}
			
			//Delete comment
			public void delete(String commentId) {
				com = commentRepository.findByCommentId(commentId);
				commentRepository.delete(com);
			}
			
			public void deleteAll() {
				commentRepository.deleteAll();
			}

			//Update operation 
			public Comment update(String comment) { 
				if(this.com.getComment().equals(comment)) {
					com.setComment(comment);
				}
				return commentRepository.save(com); 
			}
}
