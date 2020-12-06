package com.skilldistillery.crag.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
	
	Event findByUser_UsernameAndId(String username, int id);
	Set<Event> findByUser_Username(String username);

}
