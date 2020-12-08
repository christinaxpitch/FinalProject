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
import com.skilldistillery.crag.entities.Message;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.ClimbTypeRepositories;
import com.skilldistillery.crag.services.UserService;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class UserController {

	@Autowired
	private UserService svc;

	@Autowired
	private ClimbTypeRepositories climbRepo;
	
	private String username = "shakawithme";

//	Principal principal

	@GetMapping("user")
	public List<User> listAllUsers(HttpServletResponse res) {
		List<User> users = svc.listAllUsers(username);
//		List <User> users = svc.listAllUsers(principal);
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	@GetMapping("user/{userId}")
	public User getUserById(@PathVariable Integer userId, HttpServletResponse res) {
//		User User = svc.show(principal.getName(), uid);
		User user = svc.show(username, userId);
		if (user == null) {
			res.setStatus(404);
		}
		return user;
	}

//	
	@PutMapping("user/{userId}")
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

	
//	Hold of on testing? should 
	@DeleteMapping("user/{userId}")
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

	@GetMapping("user/location/{cityName}")
	public List<User> listUsersByLocation(HttpServletResponse res, @PathVariable String cityName) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<User> users = svc.findUsersByLocation(username, cityName);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	
	
	
	@GetMapping("user/climbtype/{climbType}")
	public List<User> listUsersByClimbType(HttpServletResponse res, @PathVariable String climbType) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		ClimbType type = climbRepo.findByName(climbType);
		
		List<User> users = svc.findByClimbType(username, type);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	
	
	@GetMapping("user/available/{availability}")
	public List<User> listUsersByAvailability(HttpServletResponse res, @PathVariable String availability) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<User> users = svc.findByAvailability(username, availability);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
	
	
	
	

	@GetMapping("user/favoriteusers")
	public List<User> listOfFavoriteUsersByUser(HttpServletResponse res) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<User> users = svc.listOfFavoriteUsers(username);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
//	
//	
//	
//	
//	
//	
//	
//	
//	THIS WILL GO IN THE CLIMBING AREA CONTROLLER

	@GetMapping("user/climbingareausers/{climbingArea}")
	public List<User> listUsersByFavoriteClimbingArea(HttpServletResponse res, @PathVariable String climbingArea) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		
		List<User> users = svc.findUsersByFavoriteClimbingAreas(username, climbingArea);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	
	
	
//	Going into another controller
//	@GetMapping("user/favoriteareas")
//	public List<ClimbingArea> listofUsersFavoriteClimbingAreas(HttpServletResponse res) {
////			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
//		List<ClimbingArea> areas = svc.usersListOfClimbingAreas(username);
//
//		if (areas == null) {
//			res.setStatus(404);
//		}
//		return areas;
//	}

	
	
	
	@GetMapping("user/attendedevents")
	public List<Event> findEventsAttendedByUser(HttpServletResponse res) {
//			List <User> users = svc.findUsersByLocation(principal.getName());
		List<Event> events = svc.findEventsAttendedByUser(username);

		if (events == null) {
			res.setStatus(404);
		}
		return events;
	}

	@GetMapping("user/createdevents")
	public List<Event> listCreatedEventsForUser(HttpServletResponse res) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<Event> events = svc.findEventsCreatedByUser(username);

		if (events == null) {
			res.setStatus(404);
		}
		return events;
	}

	@GetMapping("user/messages")
	public List<Message> listOfUsersMessages(HttpServletResponse res) {
//			List <Message> messages = svc.findUsersByLocation(principal.getName(), cityName);
		List<Message> messages = svc.usersMessages(username);
		if (messages == null) {
			res.setStatus(404);
		}
		return messages;
	}

//	
//	
//	
//	userAdded = svc.addUserToFavorites(principal.getName(), user);
//	addedId - is that the id of the one being favorited
	@PutMapping("user/profile/{addedId}")
	public boolean updateUsersFavoriteUsersList(HttpServletResponse res, @RequestBody User user,
			@PathVariable int addedId) {
		boolean userAdded = false;

		try {
			userAdded = svc.addUserToFavorites(username, addedId);
			if (userAdded == false) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return userAdded;
	}

//	
//	
//	
//	

//	areaAdded = svc.addClimbingAreaToFavorites(principal.getName(), user);
//	need to make sure api mapping is correct
	@PutMapping("user/area/{areaId}")
	public boolean updateUsersFavoriteAreasList(HttpServletResponse res, @RequestBody User user,
			@PathVariable int areaId) {
		boolean areaAdded = false;

		try {
			areaAdded = svc.addClimbingAreaToFavorites(username, areaId);
			if (user == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return areaAdded;
	}

}
