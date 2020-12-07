//package com.skilldistillery.crag.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.skilldistillery.crag.entities.Location;
//import com.skilldistillery.crag.entities.User;
//import com.skilldistillery.crag.repositories.LocationRepository;
//import com.skilldistillery.crag.repositories.UserRepository;
//
//@Service
//public class LocationServiceImpl implements LocationService {
//	
//	@Autowired
//	private LocationRepository locationRepo;
//	
//	@Autowired
//	private UserRepository userRepo;
//
//	@Override
//	public List<Location> index(String username) {
//		if(userRepo.findByUsername(username) == null) {
//			return null;
//		}
//		return locationRepo.findByUsers_Username(username);
//	}
//
//	@Override
//	public Location show(String username, int locationId) {
//		if(userRepo.findByUsername(username) == null) {
//			return null;
//		}
//		Optional<Location> locationOpt = locationRepo.findById(locationId);
//		Location location = null;
//		if(locationOpt.isPresent()) {
//			location = locationOpt.get();
//		}
//		return location;
//	}
//
//	@Override
//	public Location create(String username, Location location) {
//		User user = userRepo.findByUsername(username);
//		if(user != null) {
//			location.addUser(user);
//			locationRepo.saveAndFlush(location);
//		}
//		return location;
//	}
//
//	@Override
//	public Location update(String username, int locationId, Location location) {
//		Location managedLocation = locationRepo.findByUsers_UsernameAndId(username, locationId);
//		if(managedLocation != null) {
//			managedLocation.setStreetAddress(location.getStreetAddress());
//			managedLocation.setCity(location.getCity());
//			managedLocation.setState(location.getState());
//			managedLocation.setZip(location.getZip());
//		}
//		locationRepo.saveAndFlush(managedLocation);
//		return managedLocation;
//	}
//
//	@Override
//	public boolean destroy(String username, int locationId) {
//		boolean deleted = false;
////		Location locationToUpdate = locationRepo.findByUser_UsernameAndId(username, locationId);
////		locationToUpdate.setEnabled(false);
////		if(locationToUpdate.getEnabled() == false) {
////			return true;
////		}
////		else {
////		return false;
////		}
//		
//		if (userRepo.findByUsername(username) == null || locationRepo.findById(locationId) == null) {
//			return deleted;
//		}
//		Optional<Location> locationOpt = locationRepo.findById(locationId);
//		Location location = null;
//		if(locationOpt.isPresent()) {
//			location = locationOpt.get();
//			locationRepo.delete(location);
//			deleted = true;
//		}
//		return deleted;
//	}
//
//}
