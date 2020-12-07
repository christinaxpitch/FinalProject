package com.skilldistillery.crag.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.services.UserService;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class UserController {

	@Autowired
	private UserService svc;
	
	private String username = "shakawithme";
	
//	Principal principal
	
	@GetMapping("users")
	public List<User> listAllUsers(HttpServletResponse res) {
		List <User> users = svc.listAllUsers(username);
//		List <User> users = svc.listAllUsers(principal);
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
	
	@GetMapping("users/{userid}")
	public User getUserById(@PathVariable Integer userId, HttpServletResponse res) {
//		User User = svc.show(principal.getName(), uid);
		User user = svc.show(username, userId);
		if (user == null) {
			res.setStatus(404);
		}
		return user;
	}
	
	
//	
	@PutMapping("users/{userId}")
	public User updateUser(HttpServletResponse res, @RequestBody User user) {
		try {
//			user = svc.update(principal.getName(), user);
			user = svc.update(username, user);
			if (user == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return user;
	}
	
	@DeleteMapping("todos/{userId}")
	public void destroy(HttpServletResponse res, @PathVariable Integer userId) {
//		if (svc.destroy(principal.getName(), userId)) {
//			res.setStatus(204);
//		}
		if (svc.destroy(username, userId)) {
			res.setStatus(204);
		}
		
		else {
			res.setStatus(404);
		}
	}
	
	@GetMapping("users/location/{cityName}")
	public List<User> listUsersByLocation(HttpServletResponse res, @PathVariable String cityName) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
			List <User> users = svc.findUsersByLocation(username, cityName);
			
			if (users == null) {
				res.setStatus(404);
			}
		return users;
	}
	
	@GetMapping("users/climbtype/{climbType}")
	public List<User> listUsersByClimbType(HttpServletResponse res, @RequestBody ClimbType climbType) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List <User> users = svc.findByClimbType(username, climbType);
		
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
	
	@GetMapping("users/available/{availability}")
	public List<User> listUsersByAvailability(HttpServletResponse res, @PathVariable String availability) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List <User> users = svc.findByAvailability(username, availability);
		
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
	
	@GetMapping("users/favoritesList")
	public List<User> listOfFavoriteUsersByUser(HttpServletResponse res) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List <User> users = svc.listOfFavoriteUsers(username);
		
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
	
	
	@GetMapping("users/climbingareausers/{climbingArea}")
	public List<User> listUsersByFavoriteClimbingArea(HttpServletResponse res, @RequestBody ClimbingArea climbingArea) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List <User> users = svc.findUsersByFavoriteClimbingAreas(username, climbingArea);
		
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
	
	@GetMapping("users/attendedevents")
	public List<Event> findEventsAttendedByUser(HttpServletResponse res) {
//			List <User> users = svc.findUsersByLocation(principal.getName());
		List <Event> events = svc.findEventsAttendedByUser(username);
		
		if (events == null) {
			res.setStatus(404);
		}
		return events;
	}
	
	
	@GetMapping("users/createdevents")
	public List<Event> listCreatedEventsForUser(HttpServletResponse res) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List <Event> events = svc.findEventsCreatedByUser(username);
		
		if (events == null) {
			res.setStatus(404);
		}
		return events;
	}
	
}
