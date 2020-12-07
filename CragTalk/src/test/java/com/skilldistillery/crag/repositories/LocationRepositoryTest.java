package com.skilldistillery.crag.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Location;
import com.skilldistillery.crag.entities.User;

@SpringBootTest
class LocationRepositoryTest {
	
	@Autowired
	private LocationRepository repo;

	
//	@Test
//	void test() {
//		Location location = repo.findByUsers_Username("shakawithme");
//		assertNotNull(location);
//		assertEquals("Boulder", location.getCity());
//	}
//	

}
