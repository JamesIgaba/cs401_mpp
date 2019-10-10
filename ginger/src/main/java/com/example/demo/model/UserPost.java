package com.example.demo.model;
//model
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserPost {

	@Id
	String id;
	Date date;
	String content;
	Users user;
	String postingUserId;
	
	
	public UserPost(String content) {
		//this.id = getId();
		date = new Date();
		this.content = content;
		//this.postingUserId = user.getId();
	}

	public String getId() {
		return id;
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
	
	public String getPostingUserId() {
		return postingUserId;
	}

}
