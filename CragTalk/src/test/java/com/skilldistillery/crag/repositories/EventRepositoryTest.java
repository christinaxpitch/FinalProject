package com.skilldistillery.crag.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.User;

@SpringBootTest
class EventRepositoryTest {
	
	@Autowired
	private EventRepository repo;
	
	@Autowired
	private UserRepository userRepo;

	@Test
	void test() {
		User user = userRepo.findByUsername("shakawithme");
		Event event = repo.findByCreatedByAndId(user, 1);
		assertNotNull(event);
		assertEquals("C3 (CCube) Crag, Chalk, & Chat", event.getEventName());
	
	}
	
	@Test
	void test2() {
		User user = userRepo.findByUsername("shakawithme");
		List <Event> events = repo.findByCreatedBy(user);
		assertNotNull(events);
		assertTrue(events.size() > 0);
	}

	

}
