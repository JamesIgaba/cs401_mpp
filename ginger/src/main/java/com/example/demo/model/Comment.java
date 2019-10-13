package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class Comment {
	@Id
	String commentId;
	String comment;
	String commentUserId;
	String postId;
	
	public Comment(String postId, String comment) {
		this.postId = postId;
		this.comment = comment;
	}
	
	public String getCommentId() {
		return commentId;
	}

	public String getCommentUserId() {
		return commentUserId;
	}
	
	public String getPostId() {
		return postId;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
