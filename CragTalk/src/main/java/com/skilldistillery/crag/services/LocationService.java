package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.Location;

public interface LocationService {
	
    public List<Location> index(String username);

    public Location show(String username, int locationId);

    public Location create(String username, Location location);

    public Location update(String username, int locationId, Location location);

    public boolean destroy(String username, int locationId);

}
