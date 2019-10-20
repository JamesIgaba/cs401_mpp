package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Event {
	
	@Id
	String id;
	String name;
	LocalDate dateOfEvent;
	String description;
	String userEmailId;
	List<String> attendees;
	
	public Event(String name, String userEmailId) {
		this.name = name;
		this.userEmailId = userEmailId;
		attendees = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDateOfEvent() {
		return dateOfEvent;
	}
	
	public void setDateOfEvent(LocalDate dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUserEmailId() {
		return userEmailId;
	}
	
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	
	public List<String> getAttendees() {
		return attendees;
	}
	
	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}
	
	public String getId() {
		return id;
	}
	
}
