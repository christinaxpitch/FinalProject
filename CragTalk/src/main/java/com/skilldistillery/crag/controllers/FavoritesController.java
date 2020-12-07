//package com.skilldistillery.crag.controllers;
//
//import java.security.Principal;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.skilldistillery.crag.entities.ClimbingArea;
//import com.skilldistillery.crag.entities.Location;
//import com.skilldistillery.crag.entities.User;
//import com.skilldistillery.crag.services.ClimbingAreaService;
//import com.skilldistillery.crag.services.UserService;
//
//@CrossOrigin({ "*", "http://localhost:4210" })
//@RestController
//public class FavoritesController {
//
//	private String username = "shakawithme";
//
//	@Autowired
//	private UserService userSvc;
//
//	@Autowired
//	private ClimbingAreaService CASvc;
//
////	View Favorite users
//	@GetMapping(path = "/favoriteUsers/{fid}")
//	public List<User> getFavoriteUsers(@RequestBody List<User> users, HttpServletResponse res, Principal principal,
//			@PathVariable Integer tid) {
//		if (users == null) {
//			res.setStatus(400);
//		}
//		users = userSvc.listOfFavoriteUsers(username);
//		return users;
//	}
//
////	View Favorite climbing locations
//@GetMapping(path="/favoriteLocations/{fid}")
//public List<ClimbingArea> getFavoriteAreas(@RequestBody List<ClimbingArea> areas, HttpServletResponse res, Principal principal, @PathVariable Integer tid) {
//	 if (areas == null) {
//	        res.setStatus(400);
//	    } areas = CASvc.
//	    return areas;
//	}
//
////	Remove favorite users
//	@DeleteMapping(path = "/favoriteUsers/{fid}")
//	public void destroy(Integer uid, String username) {
//		userSvc.destroy(username, uid);
//	}
//
////	Remove favorite climbing locations
//	@DeleteMapping(path = "/favoriteLocations/{fid}")
//	public void destroy(String username, Integer caid) {
//		CASvc.destroy(username, caid);
//	}
//
////	add favorite users
//	@PutMapping(path = "/favoriteUsers")
//	public User addFavoriteUser() {
//
//	}
//
////	add favorite climbing locations
//	@PutMapping(path = "/favoriteLocations")
//	public ClimbingArea addFavoriteLocation(String username, ClimbingArea climbingArea) {
//		return CASvc.create(username, climbingArea);
//	}
//
////	update favorite users
//
////	update favorite climbing locations
//
////	find users by favorite users
//
////	find users by favorite climbing area
//
//}
