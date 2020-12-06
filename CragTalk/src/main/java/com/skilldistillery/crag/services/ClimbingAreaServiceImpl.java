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
		
	public List<ClimbingArea> favoritedIndex(String username) {
		if (userRepo.findFavoriteAreaListByUsername(username)==null) {
			return null;
		}
		return climbingAreaRepo.findByFavoriteArea_Username(username);
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
		climbingArea.addUser(user);
		return climbingAreaRepo.saveAndFlush(climbingArea);
	};
	

	@Override
	public ClimbingArea update(String username, int tid, ClimbingArea climbingArea) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Optional<ClimbingArea> climbingAreaOpt = climbingAreaRepo.findById(tid);
		ClimbingArea managedClimbingArea = null;
		if (climbingAreaOpt.isPresent()) {
			managedClimbingArea = climbingAreaOpt.get();

			managedClimbingArea.setDescription(climbingArea.getDescription());
			managedClimbingArea.setImgUrl(climbingArea.getImgUrl());
			managedClimbingArea.setLocation(climbingArea.getLocation());
			managedClimbingArea.setName(climbingArea.getName());
			managedClimbingArea.setUsers(climbingArea.getUsers());
			}
		climbingAreaRepo.saveAndFlush(managedClimbingArea);
		return managedClimbingArea;
	}
	

	@Override
	public boolean destroy(String username, int caid) {
		if (userRepo.findByUsername(username) == null) {
			return false;
		}
		Optional<ClimbingArea> climbingAreaOpt =climbingAreaRepo.findById(caid);
		ClimbingArea managedClimbingArea = null;
		if (climbingAreaOpt.isPresent()) {
			managedClimbingArea = climbingAreaOpt.get();
			climbingAreaRepo.deleteById(managedClimbingArea.getId());
		}

		return true;
	}

}
