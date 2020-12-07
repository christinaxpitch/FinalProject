//package com.skilldistillery.crag.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.skilldistillery.crag.entities.Location;
//
//public interface LocationRepository extends JpaRepository<Location, Integer> {
//	
//	List<Location> findByUsers_Username(String username);
//	Location findByUsers_UsernameAndId(String username, int locationId);
//
//}
