package com.skilldistillery.crag.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.services.ClimbingAreaService;

@CrossOrigin({"*", "http://localhost:4210"})
@RequestMapping("api")
@RestController
public class ClimbingAreaController {
	
	@Autowired
	private ClimbingAreaService climbingAreaSvc;
	
	private String username = "shakawithme";
	
	@GetMapping("climbingAreas")
	public List<ClimbingArea> index(HttpServletResponse res){
		List<ClimbingArea> climbingAreas = climbingAreaSvc.index(username);
		if(climbingAreas == null) {
			res.setStatus(400);
		}
		return climbingAreas;
	}
	
	//View Favorite climbing locations
	@GetMapping(path="climbingAreas/favorites")
	public List<ClimbingArea> getFavoriteClimbingAreas(String username, HttpServletResponse res){
	List<ClimbingArea> areas = climbingAreaSvc.favoritedIndex(this.username);//change this.username to username when no longer manualy setting username
	if(areas == null) {
		res.setStatus(400);
	}
	return areas;
	}

}
