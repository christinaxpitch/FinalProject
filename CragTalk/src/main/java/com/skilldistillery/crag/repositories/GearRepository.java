package com.skilldistillery.crag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Gear;

public interface GearRepository extends JpaRepository<Gear, Integer> {

	Gear findByUser_UsernameAndId(String username, int todoId);
	
	List<Gear> findByUser_Username(String username);
	
}
