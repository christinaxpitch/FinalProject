package com.skilldistillery.crag.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;

@SpringBootTest
class GearRepositoryTest {
	
	@Autowired
	private GearRepository repo;

	@Autowired
	private UserRepository userRepo;
	
	@Test
	void test() {
		User user = userRepo.findByUsername("shakawithme");
		List <Gear> gear = repo.findByUser(user);
		assertNotNull(gear);
		assertEquals("Grigri, 9.5mm Rope, chalk, helmet, 10 quickdraws, "
				+ "120 cm sling, 5 locking carabiners, crash pad", gear.get(0).getName());
		
	}
	
//	@Test
//	void test2() {
//		Gear gear = repo.findByName("Grigri, 9.5mm Rope, chalk, helmet, 10 quickdraws, 120 cm sling, 5 locking carabiners, crash pad");
//		assertNotNull(gear);
//		assertEquals(1, gear.getId());
//		
//		
//	}
	

}
