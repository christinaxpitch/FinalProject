package com.skilldistillery.crag.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository repo;

	@Autowired
	private ClimbingAreaRepository climbRepo;

	@Autowired
	private ClimbTypeRepositories climbTypeRepo;
	
	@Autowired
	private GearRepository gearRepo;
	
	@Test
	@DisplayName("this is to test the find all users")
	void test() {
		List<User> users = repo.findAll();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}

//	List<User> findByFavoriteAreaList(ClimbingArea climbingarea);

	@Test
	@DisplayName("this is to see if we can find users by their favorite climbing area")
	void test2() {
		ClimbingArea ca = climbRepo.findByName("Gregory Canyon");
		List<User> users = repo.findByFavoriteAreaList(ca);
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}

//	List <User> findByClimbTypes(ClimbType climbType);
	@Test
	@DisplayName("this is to see if we can find users by climb type")
	void test3() {
		ClimbType ct = climbTypeRepo.findByName("Sport");
		List<User> users = repo.findByClimbTypes(ct);
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}

//	List <User> findByAvailablity(String availability);
	@Test
	@DisplayName("this is to see if we can find users by their availability")
	void test4() {
		String availability = "Sundays";
		List<User> users = repo.findByAvailability(availability);
		assertNotNull(users);
		assertTrue(users.size() > 0);
		assertEquals("Timothy", users.get(0).getFirstName());
	}



////	List<User> findByGearList(String gear);
//	@Test
//	@DisplayName("this is to see if we can find users by their gear")
//	void test5() {
////		Gear gear = gearRepo.findByName("Grigri, 9.5mm Rope, chalk, helmet, 10 quickdraws, 120 cm sling, "
////				+ "5 locking carabiners, crash pad");
//		
//		
//		String gearList = "Grigri, 9.5mm Rope, chalk, helmet, "
//				+ "10 quickdraws, 120 cm sling, "
//				+ "5 locking carabiners, crash pad";
//		assertNotNull(user);
//		assertTrue(user.size() > 0);
//		assertEquals(gearList, user.getGearList().get(0).getName());
//	}
}
