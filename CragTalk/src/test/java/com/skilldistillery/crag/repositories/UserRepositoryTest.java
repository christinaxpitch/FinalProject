//package com.skilldistillery.crag.repositories;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.skilldistillery.crag.entities.User;
//
//@SpringBootTest
//class UserRepositoryTest {
//
//	@Autowired
//	private UserRepository repo;
//	
//	@Test
//	@DisplayName("this is to test the find all users")
//	void test() {
//		List<User> users = repo.findAll();
//		assertNotNull(users);
//		assertTrue(users.size() > 0);
//	}
//	
//	@Test
//	@DisplayName("this is to test find by username")
//	void test2() {
//		
//	}
//}
