package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.Event;

public interface EventService {

	public List<Event> index();

    public Event show(String username, int id);

    public Event create(String username, Event event);

    public Event update(String username, int id, Event event);

    public boolean destroy(String username, int id);
}
