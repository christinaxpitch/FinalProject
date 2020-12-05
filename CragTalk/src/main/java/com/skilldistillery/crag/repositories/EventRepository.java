package com.skilldistillery.crag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
