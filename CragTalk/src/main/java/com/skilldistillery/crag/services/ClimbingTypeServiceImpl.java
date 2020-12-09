package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.crag.entities.ClimbType;
import com.skilldistillery.crag.repositories.ClimbTypeRepositories;
import com.skilldistillery.crag.repositories.UserRepository;

@Service
public class ClimbingTypeServiceImpl implements ClimbingTypeService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ClimbTypeRepositories climbRepo;
	
	@Override
	public ClimbType show(String username, int id) {
		if (climbRepo.findById(id) == null) {
			return null;
		}
		Optional<ClimbType> typeOpt = climbRepo.findById(id);
		ClimbType climbType = null;
		if (typeOpt.isPresent()) {
			climbType = typeOpt.get();
		}
		return climbType;
		
	}

	@Override
	public ClimbType showByName(String username, String name) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
	
		return climbRepo.findByName(name);
	}

	@Override
	public List<ClimbType> ListOfAll(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return climbRepo.findAll();		
	}

}
