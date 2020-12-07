//package com.skilldistillery.crag.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.skilldistillery.crag.entities.Gear;
//import com.skilldistillery.crag.entities.User;
//import com.skilldistillery.crag.repositories.GearRepository;
//import com.skilldistillery.crag.repositories.UserRepository;
//
//@Service
//public class GearServiceImpl implements GearService {
//
//	@Autowired
//	private GearRepository gearRepo;
//	
//	@Autowired
//	private UserRepository userRepo;
//	
//	@Override
//	public List<Gear> index(String username) {
//		if (userRepo.findByUsername(username) == null) {
//			return null;
//		}
//		return gearRepo.findByUser_Username(username);
//		
//	}
//
//	@Override
//	public Gear show(String username, int gid) {
//		if (userRepo.findByUsername(username) == null) {
//			return null;
//		}
//		Optional<Gear> gearOpt = gearRepo.findById(gid);
//		Gear gear = null;
//		if (gearOpt.isPresent()) {
//			gear = gearOpt.get();
//		}
//		return gear;
//	}
//
//	@Override
//	public Gear create(String username, Gear gear) {
//		if (userRepo.findByUsername(username) == null) {
//			return null;
//		}
//		User user = userRepo.findByUsername(username);
//		gear.setUser(userRepo.findByUsername(username));
//		List<Gear> gearList = user.getGearList();
//		gearList.add(gear);
//		gearRepo.saveAndFlush(gear);
//		
//		return gear;
//	}
//
//	@Override
//	public Gear update(String username, int gid, Gear gear) {
//		if (userRepo.findByUsername(username) == null || gear == null || gearRepo.findById(gid) == null) {
//			return null;
//		}
//		Optional<Gear> gearOpt = gearRepo.findById(gid);
//		Gear updateGear = gearOpt.get();
//		
//		if (gear.getName() != null) {
//			updateGear.setName(gear.getName());
//		}
//		if (gear.getUser() != null) {
//			updateGear.setUser(gear.getUser());
//		}
//		
//		gearRepo.saveAndFlush(updateGear);
//		return updateGear;
//	}
//
//	@Override
//	public boolean destroy(String username, int gid) {
//		boolean deleted = false;
//		if (userRepo.findByUsername(username) == null || gearRepo.findById(gid) == null) {
//			return deleted;
//		}
//		Optional<Gear> gearOpt = gearRepo.findById(gid);
//		Gear gear = null;
//		if(gearOpt.isPresent()) {
//			gear = gearOpt.get();
//			gearRepo.delete(gear);
//			deleted = true;
//		}
//		
//		return deleted;
//	}
//
//}
