package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Message;
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
    
    public List<User> findUsersByFavoriteClimbingAreas(String username, String climbingArea);
    
    public List<Event> findEventsAttendedByUser(String username);
    
    List<Event> findEventsCreatedByUser (String username);
    
    List <User> findUsersByLocation(String username, String cityName);
    
    List <Message> usersMessages(String username);
    
    List <ClimbingArea> usersListOfClimbingAreas(String username);
    
//    public boolean addUserToFavorites(String username, int addedId);
    
    public boolean addUserToFavorites(String username, int profileId);
    
    public boolean removeUserFromFavorites(String username, int profileId);
    
    public boolean addClimbingAreaToFavorites(String username, int areaAddedId);
	
    public boolean removeClimbingAreaFromFavorites(String username, int areaId);
}
