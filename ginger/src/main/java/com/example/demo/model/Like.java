package com.example.demo.model;

public class Like {
	boolean like;
	String commentUserId;
	String postId;
	
	public Like(String postId, boolean like) {
		this.postId = postId;
		this.like = like;
	}
	
	public String getCommentUserId() {
		return commentUserId;
	}
	
	public String getPostId() {
		return postId;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}
}
