package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;


public interface UserService {

	public List<User> listAllUsers(String username);

    public User show(String username, int uid);

    

    public User update(String username, User user);

    public boolean destroy(String username, int uid);
    
    public List<User> findByClimbType(String username, ClimbType climbType);
    
    public List<User> findByAvailability(String username, String availability);
    
    public List<User> listOfFavoriteUsers(String username);
    
//    public List<User> findUsersByGearList(String username, String gear);
    
    public List<User> findUsersByFavoriteClimbingAreas(String username, ClimbingArea climbingArea);
    
    public List<Event> findEventsAttendedByUser(String username);
    
    List<Event> findEventsCreatedByUser (String username);
	
	
}
