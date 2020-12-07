package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	
	
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
	public List<User> findByClimbType(String username, ClimbType climbType) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return userRepo.findByClimbType(climbType);
	}

	@Override
	public List<User> findByAvailability(String username, String availability) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return userRepo.findByAvailablity(availability);
	}

	@Override
	public List<User> listOfFavoriteUsers(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return userRepo.findBymyListOfFavoriteUsers(username);
	}

	@Override
	public List<Gear> findUsersGearList(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		
		return userRepo.findGearListByUsername(username);
	}

	@Override
	public List<ClimbingArea> findUsersFavoriteClimbingAreas(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		
		return userRepo.findFavoriteAreaListByUsername(username);
	}

	@Override
	public List<Event> findEventsAttendedByUser(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		
		return userRepo.findAttendedEventsByUsername(username);
	}

	@Override
	public List<Event> findEventsCreatedByUser(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		
		return userRepo.findCreatedEventsByUsername(username);
	}

}
