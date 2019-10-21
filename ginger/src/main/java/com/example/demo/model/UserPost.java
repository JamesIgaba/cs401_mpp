package com.example.demo.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserPost {

	@Id
	String postId;
	String userId;
	String content;
	Users user;
	LocalDate date;
	
	public UserPost(String userId, String content) {
		this.date = LocalDate.now();
		this.content = content;
		this.userId = userId;
	}

	public String getpostId() {
		return postId;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
