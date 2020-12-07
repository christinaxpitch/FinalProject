package com.skilldistillery.crag.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.crag.entities.Location;

@SpringBootTest
class LocationRepositoryTest {
	
	@Autowired
	private LocationRepository repo;

	
	@Test
	void test() {
		Optional<Location> location = repo.findById(1);
		assertNotNull(location);
		assertEquals("Boulder", location.get().getCity());
	}
	

}
