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


class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	
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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	
	@Test
	void test() {
		assertNotNull(user);
		assertEquals("Timothy", user.getFirstName());
		assertEquals("Laughlin", user.getLastName());
		assertEquals("shakawithme", user.getUsername());
		
	}
	@Test
	void test2() {
		assertNotNull(user);
		assertTrue(user.getClimbTypes().size() > 0);
		assertEquals("sport", user.getClimbTypes().get(0).getName());

	}
	@Test
	void test3() {
		assertNotNull(user);
		assertTrue(user.getFavoriteAreaList().size() > 0);
		assertEquals("Gregory Canyon", user.getFavoriteAreaList().get(0).getName());

	}
	@Test
	void test4() {
		assertNotNull(user);
		assertTrue(user.getCreatedEvents().size() > 0);
		assertEquals("Crags and Brews", user.getCreatedEvents().get(0).getEventName());

	}

	@Test
	void test5() {
		assertNotNull(user);
		assertTrue(user.getAttendedEvents().size() > 0);
		assertEquals("Crags and Brews", user.getAttendedEvents().get(0).getEventName());

	}
	
	@Test
	void test6() {
		assertNotNull(user);
		assertTrue(user.getGearList().size() > 0);
		assertEquals("Grigri, 9.5mm Rope, chalk, helmet, 10 quickdraws, 120 cm sling, 5 locking carabiners, crash pad", user.getGearList().get(0).getName());

	}
	
	@Test
	void test7() {
		assertNotNull(user);
		assertTrue(user.getListOfUsersWhoHaveFavoritedMe().size() > 0);
		assertEquals("Christina", user.getListOfUsersWhoHaveFavoritedMe().get(0).getFirstName());

	}
	
	@Test
	void test8() {
		assertNotNull(user);
		assertTrue(user.getMyListOfFavoriteUsers().size() > 0);
		assertEquals("Christina", user.getMyListOfFavoriteUsers().get(0).getFirstName());
	}
	
	@Test
	void test9() {
		assertNotNull(user);
		assertTrue(user.getMediaList().size() > 0);
		assertEquals("https://i1.wp.com/lafabriquev"
				+ "erticale.com/wp-content/uploads/2019/09/crag-dog-acceptable-or-not-climbing.jpg?fit=720%2C338&ssl=1", user.getMediaList().get(0).getMediaUrl());
	}
	                             
	@Test
	void test10() {
		assertNotNull(user);
		assertTrue(user.getMyListOfSentMessages().size() > 0);
		assertEquals("Hi Christina! I just wanted to let you know that I saw we are interested in climbing in the same areas and also have Sunday's free to outdoor climb. Let me know if you would be interested in meeting up - I am pretty good at crimps and know a few good routes we can get you up to practice! PS: My dog is super cute, lol!!!", user.getMyListOfSentMessages().get(0).getMessageBody());
	}
	
	@Test
	void test11() {
		assertNotNull(user);
		assertTrue(user.getMyListOfReceivedMessages().size() > 0);
		assertEquals("Hi Timothy! Thanks for your message. I don't own any lead climbing gear, but I see that you do. Where are you trying to climb on your next day trip?", user.getMyListOfReceivedMessages().get(0).getMessageBody());
	}
	@Test
	void test12() {
		assertNotNull(user);
		
		assertEquals("Boulder", user.getLocation().getCity());
	}
	
	
}
