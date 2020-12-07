package com.skilldistillery.crag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.entities.User;

public interface GearRepository extends JpaRepository<Gear, Integer> {
	
	
	List <Gear> findByUser(User user);
	
	Gear findByName(String gearName);
	
}
