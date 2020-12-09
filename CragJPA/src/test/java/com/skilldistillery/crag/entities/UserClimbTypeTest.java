package com.skilldistillery.crag.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserClimbTypeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserClimbType type;
	
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
		UserClimbTypeId userClimbTypeId = new UserClimbTypeId();
		userClimbTypeId.setUserId(1);
		userClimbTypeId.setClimbTypeId(1);
		
		
		type = em.find(UserClimbType.class, userClimbTypeId);
		
		
	}

	@Test
	void test() {
		assertNotNull(type);
		assertEquals("5.11a" , type.getRecentGrade());
		assertTrue(type.isLeadClimb());
	}

}
