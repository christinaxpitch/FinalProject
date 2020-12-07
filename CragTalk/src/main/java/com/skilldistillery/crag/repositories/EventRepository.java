package com.skilldistillery.crag.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.User;

public interface EventRepository extends JpaRepository<Event, Integer> {
	
	Event findByCreatedByAndId(User user, int eventid);
	
	List <Event> findByCreatedBy(User user);

}
