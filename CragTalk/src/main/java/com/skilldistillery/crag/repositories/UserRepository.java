package com.skilldistillery.crag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAllUsers();
	
	User findByUsername(String username);
	
	
	User findByUser_UsernameAndId(String username, int todoId);
	
	List <User> findByClimbType(ClimbType climbType);
	
	List <User> findByAvailablity(String availability);
	
	List <User> findBymyListOfFavoriteUsers(String username);
	
//	this would find the users list of gear
	List<Gear> findGearListByUsername(String username);
	
//	find a users favorite climbing areas
	List<ClimbingArea> findFavoriteAreaListByUsername(String username);
	
	List<Event> findCreatedEventsByUsername(String username);
	
	List<Event> findAttendedEventsByUSername(String username);
	
	
//	stretch goal, add the ability for a user to search the app by someones gearList
	
}

