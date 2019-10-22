package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepo;
	
	//create event
	public Event createEventService( String userEmailId, String name, String description, int day, int month, int year) {
		return eventRepo.save(new Event(userEmailId, name,description, LocalDate.of(year,month,day)));
	}
	
	//delete event
	public void delete(String eventId) {
		eventRepo.deleteById(eventId);
	}
	
	//update event
	public Event updateEvent(String eventId, String name, String description, int day, int month, int year) {
		Optional<Event> event = eventRepo.findById(eventId);
		if(event.isPresent()) {
			event.get().setName(name);
			event.get().setDescription(description);
			event.get().setDateOfEvent(LocalDate.of(year, month, day));
		}
		return eventRepo.save(event.get());
	}
	
	//search event by any string like name
	public List<Event> searchEventService(String name) {
		return eventRepo.findByNameIgnoreCase(name);
	}
	
	//search events created by a user
	public List<Event> searchEvents(String userEmailId){
		return eventRepo.findByUserEmailId(userEmailId);
	}

	public void addAttendeeService(String eventId, String userEmailId) {
		Optional<Event> event = eventRepo.findById(eventId);
		if(event.isPresent()) {
			event.get().addAttendees(userEmailId);
			eventRepo.save(event.get());
		}
	}
	
}