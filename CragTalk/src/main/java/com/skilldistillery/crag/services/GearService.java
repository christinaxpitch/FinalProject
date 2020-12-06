package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.Gear;

public interface GearService {

	public List<Gear> index(String username);

    public Gear show(String username, int tid);

    public Gear create(String username, Gear gear);

    public Gear update(String username, int tid, Gear gear);

    public boolean destroy(String username, int tid);
	
	
}
