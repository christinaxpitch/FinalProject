package com.skilldistillery.crag.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.User;

@SpringBootTest
class ClimbingAreaTest {
	
	@Autowired
	private ClimbingAreaRepository climbingAreaRepo;

	@Test
	void test() {
		List<ClimbingArea> areas = climbingAreaRepo.findByUsers_Username("shakawithme");
		assertNotNull(areas);
		assertEquals("Gregory Canyon", areas.get(0).getName());
		
		
	}
	
	@Test
	void test2() {
		ClimbingArea area = climbingAreaRepo.findByName("Gregory Canyon");
		assertNotNull(area);
		assertEquals(1, area.getId());
		
		
	}
//	@Test
//	void test2() {
//		String climbingArea = "Gregory Canyon";
//		List<User> users = climbingAreaRepo.findByFavoriteAreaList(climbingArea);
//		assertNotNull(users);
//		assertEquals("Timothy", users.get(0).getFirstName());
//	}
	

}
