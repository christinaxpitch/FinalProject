package com.skilldistillery.crag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.entities.ClimbingArea;

public interface ClimbTypeRepositories extends JpaRepository<ClimbType, Integer> {

	ClimbType findByName(String name);
	
}
