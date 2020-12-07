package com.skilldistillery.crag.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findAll();
	
	User findByUsername(String username);
	
	User findByUsernameAndId(String username, int todoId);
	
	List <User> findByClimbTypes(ClimbType climbType);
	
	List <User> findByAvailablity(String availability);
	
	List <User> findBymyListOfFavoriteUsers_Username(String username);
	
//	this would find the users list of gear
	List<Gear> findByGearList_Username(String username);
	
//	find a users favorite climbing areas
	List<ClimbingArea> findByFavoriteAreaList_Username(String username);
	
	List<Event> findByCreatedEvents_Username(String username);
	
	List<Event> findByttendedEvents_Username(String username);
//	stretch goal, add the ability for a user to search the app by someones gearList
}


//findAttendedEventsByUsername