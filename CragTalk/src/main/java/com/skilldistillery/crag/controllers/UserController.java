package com.skilldistillery.crag.controllers;

import java.security.Principal;
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
	
//	private String username = "shakawithme";

//	Principal principal

	@GetMapping("user")
	public List<User> listAllUsers(HttpServletResponse res, Principal principal) {
		List<User> users = svc.listAllUsers(principal.getName());
//		List <User> users = svc.listAllUsers(principal);
		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	@GetMapping("user/{userId}")
	public User getUserById(@PathVariable Integer userId, HttpServletResponse res, Principal principal) {
//		User User = svc.show(principal.getName(), uid);
		User user = svc.show(principal.getName(), userId);
		if (user == null) {
			res.setStatus(404);
		}
		return user;
	}

//	
	@PutMapping("user/{userId}")
	public User updateUser(HttpServletResponse res, @RequestBody User user, Principal principal) {
		try {
//			user = svc.update(principal.getName(), user);
			user = svc.update(principal.getName(), user);
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
	public void destroy(HttpServletResponse res, @PathVariable Integer userId, Principal principal) {
//		if (svc.destroy(principal.getName(), userId)) {
//			res.setStatus(204);
//		}
		if (svc.destroy(principal.getName(), userId)) {
			res.setStatus(204);
		}

		else {
			res.setStatus(404);
		}
	}

	@GetMapping("user/location/{cityName}")
	public List<User> listUsersByLocation(HttpServletResponse res, @PathVariable String cityName, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<User> users = svc.findUsersByLocation(principal.getName(), cityName);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	
	
	
	@GetMapping("user/climbtype/{climbType}")
	public List<User> listUsersByClimbType(HttpServletResponse res, @PathVariable String climbType, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		ClimbType type = climbRepo.findByName(climbType);
		
		List<User> users = svc.findByClimbType(principal.getName(), type);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	
	
	@GetMapping("user/available/{availability}")
	public List<User> listUsersByAvailability(HttpServletResponse res, @PathVariable String availability, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<User> users = svc.findByAvailability(principal.getName(), availability);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}
	
	
	
	

	@GetMapping("user/favoriteusers")
	public List<User> listOfFavoriteUsersByUser(HttpServletResponse res, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<User> users = svc.listOfFavoriteUsers(principal.getName());

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
	public List<User> listUsersByFavoriteClimbingArea(HttpServletResponse res, @PathVariable String climbingArea, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		
		List<User> users = svc.findUsersByFavoriteClimbingAreas(principal.getName(), climbingArea);

		if (users == null) {
			res.setStatus(404);
		}
		return users;
	}

	
	
	
//	Going into another controller
	@GetMapping("user/favoriteareas")
	public List<ClimbingArea> listofUsersFavoriteClimbingAreas(HttpServletResponse res, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<ClimbingArea> areas = svc.usersListOfClimbingAreas(principal.getName());

		if (areas == null) {
			res.setStatus(404);
		}
		return areas;
	}

	
	
	
	@GetMapping("user/attendedevents")
	public List<Event> findEventsAttendedByUser(HttpServletResponse res, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName());
		List<Event> events = svc.findEventsAttendedByUser(principal.getName());

		if (events == null) {
			res.setStatus(404);
		}
		return events;
	}

	@GetMapping("user/createdevents")
	public List<Event> listCreatedEventsForUser(HttpServletResponse res, Principal principal) {
//			List <User> users = svc.findUsersByLocation(principal.getName(), cityName);
		List<Event> events = svc.findEventsCreatedByUser(principal.getName());

		if (events == null) {
			res.setStatus(404);
		}
		return events;
	}

	@GetMapping("user/messages")
	public List<Message> listOfUsersMessages(HttpServletResponse res, Principal principal) {
//			List <Message> messages = svc.findUsersByLocation(principal.getName(), cityName);
		List<Message> messages = svc.usersMessages(principal.getName());
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
	@PutMapping("user/{profileId}/{isFavorited}")
	public boolean updateUsersFavoriteUsersList(HttpServletResponse res,
			@PathVariable int profileId, @PathVariable boolean isFavorited, Principal principal) {
		
		
		boolean modifiedList = false;
		
		try {
			if (isFavorited) {
				modifiedList = svc.addUserToFavorites(principal.getName(), profileId);
			}
			else {
				modifiedList = svc.removeUserFromFavorites(principal.getName(), profileId);
			}
//			if ( == null) {
//				res.setStatus(404);
//			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return modifiedList;
	}

//	
//	
//	
//	

//	areaAdded = svc.addClimbingAreaToFavorites(principal.getName(), user);
//	need to make sure api mapping is correct
	@PutMapping("user/area/{areaId}/{isFavorited}")
	public boolean updateUsersFavoriteAreasList(HttpServletResponse res, @PathVariable int areaId, @PathVariable boolean isFavorited, Principal principal) {
		
	boolean modifiedList = false;
		
		try {
			if (isFavorited) {
				modifiedList = svc.addClimbingAreaToFavorites(principal.getName(), areaId);
			}
			else {
				modifiedList = svc.removeClimbingAreaFromFavorites(principal.getName(), areaId);
			}
//			if ( == null) {
//				res.setStatus(404);
//			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return modifiedList;
	}

}
