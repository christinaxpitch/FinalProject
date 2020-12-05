package com.skilldistillery.crag.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClibmingAreaTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private ClimbingArea ca;

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
		ca = em.find(ClimbingArea.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		ca = null;
	}

	@Test
	void test() {
		assertNotNull(ca);
		assertEquals("Gregory Canyon", ca.getName());
		assertEquals("https://cdn2.apstatic.com/photos/climb/111418381_medium_1494361874_topo.jpg", ca.getImgUrl());
	}

}
