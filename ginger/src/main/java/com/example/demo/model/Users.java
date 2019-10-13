package com.example.demo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	//location, gender, -hobbies and interests
	
	String firstName;
	String lastName;
	@Id
	String email;
	String password;
	String fullName;
	String gender;
	LocalDate dateOfBirth;
	int age;
	List<String> friends;
	List<String> friendRequests;
	List<String> hobbies;
	
	public Users(String firstName, String lastName, String email, String password,LocalDate dateOfBirth, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		fullName = firstName + " " + lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		Period p = Period.between(this.dateOfBirth, LocalDate.now());
		age = p.getYears();
		this.gender = gender;
		friends = new ArrayList<>();
		friendRequests = new ArrayList<>();
		hobbies = new ArrayList<String>();	
	}

	public Users() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
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
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public void addFriendToList(String emailId) {
		friends.add(emailId);
	}

	public String toString() {
		return fullName;
	}

}
