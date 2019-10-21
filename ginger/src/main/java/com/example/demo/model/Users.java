package com.example.demo.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.LogMessage;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.DateOperators.DayOfMonth;
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
	int year;
	int month;
	int day;
	List<String> friends;
	List<String> friendRequests;
	List<String> hobbies;

	public Users(String firstName, String lastName, String email, String password, String gender,int year,int month,int day) {
		this.firstName = firstName;
		this.lastName = lastName;
		fullName = firstName + " " + lastName;
		this.email = email;
		this.password = password;
		//this.dateOfBirth = LocalDate.of(1999, getMonth(5), 3);
		//Period p = Period.between(this.dateOfBirth, LocalDate.now());
		//this.age = p.getYears();
		this.gender = gender;
		friends = new ArrayList<>();
		friendRequests = new ArrayList<>();
		hobbies = new ArrayList<String>();	
	}

	public int getYear() {
		return this.year;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
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
	public Month getMonth(int month) {
		switch (month) {
		case 1:
			return Month.JANUARY;
		case 2:
			return Month.FEBRUARY;
		case 3:
			return Month.MARCH;
		case 4:
			return Month.APRIL;
		case 5:
			return Month.MAY;
		case 6:
			return Month.JUNE;
		case 7:
			return Month.JULY;
		case 8:
			return Month.AUGUST;
		case 9:
			return Month.SEPTEMBER;
		case 10:
			return Month.OCTOBER;
		case 11:
			return Month.NOVEMBER;
		case 12:
			return Month.DECEMBER;
		default:
			return Month.JANUARY;
		}
	}
}
