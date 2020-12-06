package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.ClimbingAreaRepository;
import com.skilldistillery.crag.repositories.UserRepository;

@Service
public class ClimbingAreaServiceImpl implements ClimbingAreaService {

	@Autowired
	private ClimbingAreaRepository climbingAreaRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<ClimbingArea> index(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		return climbingAreaRepo.findByUser_Username(username);
	}
		

	@Override
	public ClimbingArea show(String username, int caid) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Optional<ClimbingArea> managedClimbingArea = climbingAreaRepo.findById(caid);
		return managedClimbingArea.get();
	}

	@Override
	public ClimbingArea create(String username, ClimbingArea climbingArea) {
		User user=userRepo.findByUsername(username);
		if ( user == null) {
			return null;
		}
		climbingArea.setUser(user);
		return climbingAreaRepo.saveAndFlush(climbingArea);
	};
	

	@Override
	public ClimbingArea update(String username, int tid, ClimbingArea climbingArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(String username, int caid) {
		// TODO Auto-generated method stub
		return false;
	}

}
