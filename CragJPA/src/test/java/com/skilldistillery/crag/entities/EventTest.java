package com.skilldistillery.crag.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Event event;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("CragPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		event = em.find(Event.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		event = null;
	}

	@Test
	void test() {
		assertNotNull(event);
		assertEquals("C3 (CCube) Crag, Chalk, & Chat", event.getEventName());
		assertEquals("Come join us on a group climb! We will meet up in the morning at North Table Mountain park (Golden Cliffs climbing area) and we plan to set up as many routes as we have attendees! Come hang out, meet some new friends, try a new route, and have some fun! We will meet up at the Golden Cliffs parking lot (the climbing access side) on the other side of the main entrance to North Table Mountain Park. See you soon!", event.getDescription());
		assertEquals(2021, event.getEventDate().getYear());
		assertEquals(1, event.getCreatedBy().getId());
	}

}
