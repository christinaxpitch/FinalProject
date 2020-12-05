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


class ClimbTypeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private ClimbType type;
	
	
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
		type = em.find(ClimbType.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		type = null;
	}

	
	@Test
	void test() {
		assertNotNull(type);
		assertEquals("sport", type.getName());
		assertEquals("Sport climbing is a form of rock climbing that may rely on permanent "
				+ "anchors fixed to the rock for protection, "
				+ "in which a rope that is "
				+ "attached to the climber is clipped into the anchors to arrest a fall, or "
				+ "that involves climbing short "
				+ "distances with a crash pad underneath as protection", type.getDescription());
		
	}

}
