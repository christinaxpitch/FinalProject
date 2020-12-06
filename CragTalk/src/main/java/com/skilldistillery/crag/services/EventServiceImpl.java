package com.skilldistillery.crag.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.EventRepository;
import com.skilldistillery.crag.repositories.UserRepository;

public class EventServiceImpl implements EventService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EventRepository eventRepo;
	
	@Override
	public Set<Event> index(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return eventRepo.findByUser_Username(username);
	}

	@Override
	public Event show(String username, int id) {
		return eventRepo.findByUser_UsernameAndId(username, id);
	}

	@Override
	public Event create(String username, Event event) {
		User user = userRepo.findByUsername(username);
		if (user != null) {
//			user.addUser(user);
			eventRepo.saveAndFlush(event);			
		}
		return event;
	}

	@Override
	public Event update(String username, int id, Event event) {
		Event managedEvent = eventRepo.findByUser_UsernameAndId(username, id);
		if(managedEvent != null) {
			managedEvent.setClimbingAreaId(event.getClimbingAreaId());
			managedEvent.setCreatedBy(event.getCreatedBy());
			managedEvent.setDescription(event.getDescription());
			managedEvent.setImaUrl(event.getImaUrl());
			managedEvent.setEventName(event.getEventName());
			managedEvent.setCreatedAt(event.getCreatedAt());
			managedEvent.setEventDate(event.getEventDate());
		}
		
		return managedEvent;
	}

	@Override
	public boolean destroy(String username, int id) {
		boolean deleted = false;
		Event event = eventRepo.findByUser_UsernameAndId(username, id);
		if (event != null) {
			eventRepo.delete(event);
			deleted = true;
		}
		return deleted;
	}

}
