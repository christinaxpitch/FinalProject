package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.EventRepository;
import com.skilldistillery.crag.repositories.UserRepository;


@Service
public class EventServiceImpl implements EventService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EventRepository eventRepo;
	
	@Override
	public List<Event> index() {
//		if (userRepo.findByUsername(username) == null) {
//			return null;
//		}
		return eventRepo.findAll();
	}

	@Override
	public Event show(String username, int eventId) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Event event = null;
		Optional<Event> eventOpt = eventRepo.findById(eventId);
		if (eventOpt.isPresent()) {
			event = eventOpt.get();
		}
		return event;
	}

	@Override
	public Event create(String username, Event event) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User user = userRepo.findByUsername(username);
		if (user != null) {
			event.setCreatedBy(user);
			eventRepo.saveAndFlush(event);			
		}
		return event;
	}

	@Override
	public Event update(String username, Event event) {
		if (userRepo.findByUsername(username) == null || event == null) {
			return null;
		}
		if(event.getCreatedBy().getUsername() == username){
		Optional<Event> eventOpt = eventRepo.findById(event.getId());
		Event managedEvent = eventOpt.get();
		if(managedEvent != null) {

			managedEvent.setClimbingAreaId(event.getClimbingAreaId());
			managedEvent.setCreatedBy(event.getCreatedBy());
			managedEvent.setDescription(event.getDescription());
			managedEvent.setImaUrl(event.getImaUrl());
			managedEvent.setEventName(event.getEventName());
			managedEvent.setCreatedAt(event.getCreatedAt());
			managedEvent.setEventDate(event.getEventDate());
			System.out.println("**********");
			System.out.println(managedEvent);
			System.out.println("**********");
			eventRepo.saveAndFlush(managedEvent);
		}
		return managedEvent;
		}
		return event;
	}

	@Override
	public boolean destroy(String username, int id) {
		boolean deleted = false;
		if (userRepo.findByUsername(username) == null) {
			return deleted;
		}
		Optional <Event> eventOpt = eventRepo.findById(id);
		Event event = null;
		if (eventOpt.isPresent()) {
			event = eventOpt.get();
			eventRepo.delete(event);
			deleted = true;
		}
		return deleted;
	}

}
