package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	
	String firstName;
	String lastName;
	String fullName;
	int age;
	@Id
	String email;
	Date dateOfBirth;
	List<Users> friends;
	List<Users> friendRequests;
	
	public Users(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		friends = new ArrayList<>();
		friendRequests = new ArrayList<Users>();
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

	public List<Users> getFriends() {
		return friends;
	}
	
	public List<Users> getFriendRequests() {
		return friendRequests;
	}
	
	public void addFrienToList(Users u) {
		friends.add(u);
	}

	public String toString() {
		return firstName + " " + lastName;
	}

}
