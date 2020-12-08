package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.Message;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.ClimbingAreaRepository;
import com.skilldistillery.crag.repositories.UserRepository;

@Service
//@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ClimbingAreaRepository areaRepo;
	
	
	
	@Override
	public List<User> listAllUsers(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return userRepo.findAll();
	}

	@Override
	public User show(String username, int uid) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Optional<User> userOpt = userRepo.findById(uid);
		User user = null;
		if (userOpt.isPresent()) {
			user = userOpt.get();
		}
		
		return user;
	}

	

	@Override
	public User update(String username, User user) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Optional<User> userOpt = userRepo.findById(user.getId());
		User updatedUser = userOpt.get();
		
		if (user.getAvailability() != null) {
			updatedUser.setAvailability(user.getAvailability());
		}
		if (user.getBirthdate() != null) {
			updatedUser.setBirthdate(user.getBirthdate());
		}
		
			
		if (user.getClimbTypes() != null) {
			updatedUser.setClimbTypes(user.getClimbTypes());
		}
		if (user.getFavoriteAreaList() != null) {
			updatedUser.setFavoriteAreaList(user.getFavoriteAreaList());
		}
		
			
		
		if (user.getFavoriteBeer() != null) {
			updatedUser.setFavoriteBeer(user.getFavoriteBeer());
		}
		if (user.getFirstName() != null) {
			updatedUser.setFirstName(user.getFirstName());
		}
		if (user.getLastName() != null) {
			updatedUser.setLastName(user.getLastName());
		}
		if (user.getGearList() != null) {
			updatedUser.setGearList(user.getGearList());
		}
		if (user.getGoals() != null) {
			updatedUser.setGoals(user.getGoals());
		}
		if (user.getOtherHobbies() != null) {
			updatedUser.setOtherHobbies(user.getOtherHobbies());
		}
		if (user.getProfilePic() != null) {
			updatedUser.setProfilePic(user.getProfilePic());
		}
		if (user.getMyListOfFavoriteUsers() != null) {
			updatedUser.setMyListOfFavoriteUsers(user.getMyListOfFavoriteUsers());
		}
		if (user != null) {
			updatedUser.setProfilePic(user.getProfilePic());
		}
		if (user.getProfilePic() != null) {
			updatedUser.setProfilePic(user.getProfilePic());
		}
		if (user.getProfilePic() != null) {
			updatedUser.setProfilePic(user.getProfilePic());
		}
		
		
		
		updatedUser.setLocation(user.getLocation());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setClimbingSince(user.getClimbingSince());
		updatedUser.setAvailability(user.getAvailability());
		updatedUser.setPassword(user.getPassword());
		
		return updatedUser;
	}

	@Override
	public boolean destroy(String username, int uid) {
		boolean deleted = false;
		if (userRepo.findByUsername(username) == null) {
			return deleted;
		}
		Optional<User> todoOpt = userRepo.findById(uid);
		User user = null;
		if(todoOpt.isPresent()) {
			user = todoOpt.get();
			userRepo.delete(user);
			deleted = true;
		}
		
		return deleted;
	}

	@Override
	public List<User> findByClimbType(String username, ClimbType type) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return userRepo.findByClimbTypes(type);
	}

	@Override
	public List<User> findByAvailability(String username, String availability) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
	
		return userRepo.findByAvailability(availability);
	}

	@Override
	public List<User> listOfFavoriteUsers(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User user = userRepo.findByUsername(username);
		return user.getMyListOfFavoriteUsers();
	}
	
	

	@Override
	public List<User> findUsersByFavoriteClimbingAreas(String username, String climbingArea) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		ClimbingArea area = areaRepo.findByName(climbingArea);
		return userRepo.findByFavoriteAreaList(area);
	}

	@Override
	public List<Event> findEventsAttendedByUser(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User user = userRepo.findByUsername(username);
		return user.getAttendedEvents();
	}

	@Override
	public List<Event> findEventsCreatedByUser(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User user = userRepo.findByUsername(username);
		return user.getCreatedEvents();
		
	}

	@Override
	public List<User> findUsersByLocation(String username, String cityName) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		
		return userRepo.findByLocation_City(cityName);
	}

	@Override
	public List<Message> usersMessages(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User user = userRepo.findByUsername(username);
		return user.getMyListOfReceivedMessages();
	}

	@Override
	public List<ClimbingArea> usersListOfClimbingAreas(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User user = userRepo.findByUsername(username);
		
		
		return user.getFavoriteAreaList();
	}

	
	
//	I think we need to also pass in a boolean from the front end. 
//	If false - then remove the user from the current users favorites list 
//	If true, then add the user to the current users favorites list?
	@Override
	public boolean addUserToFavorites(String username, int addedId) {
		boolean addedFave = false;
		
		if (userRepo.findByUsername(username) == null) {
			return addedFave;
		}
		
		User userAddingFave = userRepo.findByUsername(username);
		Optional <User> userOpt = userRepo.findById(addedId);
		User userBeingFaved = userOpt.get();
		
//		LOGIC: if the user has toggled off the favorites button, they are still sent to this method. 
//		in this method, the if statement below will check to see if that person 
		
		if (userAddingFave.getMyListOfFavoriteUsers().contains(userBeingFaved)) {
//			If they are already on the faves list then use the remove method passing in the person being removed
			userAddingFave.removeMyListOfFavoriteUsers(userBeingFaved);
			userRepo.saveAndFlush(userAddingFave);
			return addedFave;
		}
		else {
//			call add method from user to add another user to their favorites list
			userAddingFave.addMyListOfFavoriteUsers(userBeingFaved);
			userRepo.saveAndFlush(userAddingFave);
			return !addedFave;
		}
		
	}
	
	
	
	
	@Override
	public boolean addClimbingAreaToFavorites(String username, int addedId) {
		boolean addedFave = false;
		
		if (userRepo.findByUsername(username) == null) {
			return addedFave;
		}
		User userAddingFave = userRepo.findByUsername(username);
		Optional <ClimbingArea> areaOpt = areaRepo.findById(addedId);
		ClimbingArea area = areaOpt.get();
		List <ClimbingArea> areaFavoritesList = userAddingFave.getFavoriteAreaList();
		areaFavoritesList.add(area);
		userAddingFave.setFavoriteAreaList(areaFavoritesList);
		
		if (userAddingFave.getFavoriteAreaList().contains(area)) {
			return !addedFave;
		}
		return addedFave;
	}

	
	
	
	
}
