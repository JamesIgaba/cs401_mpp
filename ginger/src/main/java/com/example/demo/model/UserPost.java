package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserPost {

	@Id
	String postId;
	String UserId;
	String content;
	Users user;
	Date date;
	
	
	public UserPost(String content) {
		this.date = new Date();
		this.content = content;
		this.UserId = new Users().getEmail();
	}

	public String getId() {
		return postId;
	}

	public Date getDate() {
		return date;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUserId() {
		return UserId;
	}

}
