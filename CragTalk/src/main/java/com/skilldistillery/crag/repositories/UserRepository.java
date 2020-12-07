package com.skilldistillery.crag.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;
public interface UserRepository extends JpaRepository<User, Integer> {

	
	User findByUsername(String username);
	
	List<User> findByFavoriteAreaList(ClimbingArea climbingarea);

	List <User> findByClimbTypes(ClimbType climbType);
	
	List <User> findByAvailability(String availability);
	
//	this would find the users list of gear
//	List<User> findByGearList(String gearName);
	
	List <User> findByLocation_City(String city);
	
}
