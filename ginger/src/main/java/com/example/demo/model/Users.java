package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	//location, gender, -hobbies and interests
	
	@Id
	String email;
	String password;
	String firstName;
	String lastName;
	String fullName;
	String gender;
	int age;
	Date dateOfBirth;
	List<String> friends;
	List<String> friendRequests;
	
	public Users(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		friends = new ArrayList<>();
		friendRequests = new ArrayList<>();
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setFullName() {
		fullName = firstName + " " + lastName;
	}

	public List<String> getFriends() {
		return friends;
	}
	
	public List<String> getFriendRequests() {
		return friendRequests;
	}
	
	public void addFriendRequest(String emailId) {
		friendRequests.add(emailId);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addFriendToList(String emailId) {
		friends.add(emailId);
	}

	public String toString() {
		return firstName + " " + lastName;
	}

}
