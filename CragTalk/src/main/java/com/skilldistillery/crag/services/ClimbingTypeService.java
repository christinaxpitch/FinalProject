package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.ClimbType;

public interface ClimbingTypeService {
	
    public ClimbType show(String username, int id);
    
    public ClimbType showByName(String username, String name);
    
    public List<ClimbType> ListOfAll(String username);

}
