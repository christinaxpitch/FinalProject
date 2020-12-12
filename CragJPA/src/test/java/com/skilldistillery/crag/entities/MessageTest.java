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

class MessageTest {

	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Message message;
	
	
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
		message = em.find(Message.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		message = null;
	}

	
	@Test
	void test() {
		assertNotNull(message);
		assertEquals(null, message.getCreatedAt());
		assertEquals(2, message.getReceiver().getId());
		assertEquals(1, message.getSender().getId());
		assertEquals("Hi Christina! I just wanted to let you know that I saw we are interested in climbing in the same areas and also have Sunday's free to outdoor climb. Let me know if you would be interested in meeting up - I am pretty good at crimps and know a few good routes we can get you up to practice! PS: My dog is super cute, lol!!!", message.getMessageBody());
	}

	

}
