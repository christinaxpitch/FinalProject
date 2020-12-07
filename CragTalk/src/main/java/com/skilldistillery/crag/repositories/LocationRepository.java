package com.skilldistillery.crag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	
//	Location findByUsers_Username(String userName);
	

}
