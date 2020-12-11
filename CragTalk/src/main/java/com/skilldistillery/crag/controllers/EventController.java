package com.skilldistillery.crag.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.services.EventService;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class EventController {
	
	@Autowired
	private EventService eventSvc;
	
	//show all events
	@GetMapping("event")
	public List<Event> showAllEvents(HttpServletResponse res, Principal principal){
		List<Event> events = eventSvc.index();
		if(events == null) {
			res.setStatus(400);
		}
		return events;
	}
	
	//show single event by id
	@GetMapping("event/{eventId}")
	public Event showEvent(HttpServletResponse res, Principal principal, @PathVariable int eventId) {
		Event event = eventSvc.show(principal.getName(), eventId);
		if(event == null) {
			res.setStatus(400);
		}
		return event;
	}
	
	//create an event
	@PostMapping("event")
	public Event createEvent(HttpServletResponse res, HttpServletRequest req, Principal principal, @RequestBody Event event) {
		try {
			event = eventSvc.create(principal.getName(), event);
			if(event == null) {
				res.setStatus(404);
			}
			else {
				StringBuffer url = req.getRequestURL();
				url.append("/").append(event.getId());
				res.setStatus(201);
				res.setHeader("Location", url.toString());
			}
		} catch (Exception e) {
			res.setStatus(400);
			event = null;
		}
		return event;
	}
	
	//update and event
	@PutMapping("event/{eventId}")
	public Event updateEvent(HttpServletResponse res, HttpServletRequest req, Principal principal, @RequestBody Event event) {
		try {
			event = eventSvc.update(principal.getName(), event);
			if(event == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			res.setStatus(400);
			event = null;
		}
		return event;
	}
	
	
	//delete event
	@DeleteMapping("event/{eventId}")
	public void destory(HttpServletResponse res, HttpServletRequest req, @PathVariable int eventId, Principal principal) {
		try {
			if(eventSvc.destroy(principal.getName(), eventId)) {
				res.setStatus(204);
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
	}

}
