package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class Comment {
	@Id
	String commentId;
	String comment;
	String commentUserId;
	String postId;
	
	public Comment(String commentUserId, String comment, String postId) {
		this.commentUserId = commentUserId;
		this.comment = comment;
		this.postId =postId;
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
