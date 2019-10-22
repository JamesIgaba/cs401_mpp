package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping("/create")
	public Event create(@RequestParam String userEmailId, @RequestParam String name, @RequestParam String description, 
			@RequestParam int year, @RequestParam int month, @RequestParam int day) {
		return eventService.createEventService(userEmailId, name, description, day, month, year);
	}
	
	@RequestMapping("/update")
	public Event updateEvent(@RequestParam String eventId, @RequestParam String name,
			@RequestParam String description, @RequestParam int day, @RequestParam int month, @RequestParam int year) {
		return eventService.updateEvent(eventId, name, description, day, month, year);
	}
	
	@RequestMapping("/delete")
	public void deleteEvent(String eventId) {
		eventService.delete(eventId);
	}
	
	@RequestMapping("/searchByUser")
	public List<Event> searchUserEvents(String userEmailId){
		return eventService.searchEvents(userEmailId);
	}
	
	@RequestMapping("/search")
	public List<Event> searchEvent(String name){
		return eventService.searchEventService(name);
	}
	
	@RequestMapping("/addAttendee")
	public void addAttendee(String eventId, String userEmailId) {
		eventService.addAttendeeService(eventId, userEmailId);
	}
	
}
