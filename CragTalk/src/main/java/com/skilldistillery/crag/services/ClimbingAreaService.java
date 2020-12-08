package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.ClimbingArea;

public interface ClimbingAreaService {
	
	public List<ClimbingArea> index(String username);
    public ClimbingArea show(String username, int caid);
    public ClimbingArea create(String username, ClimbingArea climbingArea);
    public ClimbingArea update(String username, int tid, ClimbingArea climbingArea);
    public boolean destroy(String username, int caid);
    public List<ClimbingArea> favoritedIndex(String username);

}
