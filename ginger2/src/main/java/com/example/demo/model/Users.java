package com.example.demo.model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {

	//String id;
	String firstName;
	String lastName;
	@Id
	String email;
	int age;
	Date dateOfBirth;
	private ArrayList<UserPost> postList = new ArrayList<>();
	
	public Users(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}

	public String getId() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String toString() {
		return firstName + " " + lastName + " :" + email;
	}
	
	public void addPost(UserPost post) {
		postList.add(post);
	}
	

}
