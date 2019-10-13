package com.example.demo.model;

public class Comment {
	String comment;
	String commentUserId;
	String postId;
	
	public Comment(String postId, String comment) {
		this.postId = postId;
		this.comment = comment;
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
