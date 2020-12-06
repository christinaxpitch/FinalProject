package com.skilldistillery.crag.services;

import java.util.Set;

import com.skilldistillery.crag.entities.Event;
import com.skilldistillery.crag.entities.Message;

public interface EventService {

	public Set<Event> index(String username);

    public Event show(String username, int id);

    public Event create(String username, Event event);

    public Event update(String username, int id, Event event);

    public boolean destroy(String username, int id);
}
