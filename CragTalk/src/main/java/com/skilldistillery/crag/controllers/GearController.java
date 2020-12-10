package com.skilldistillery.crag.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.crag.entities.ClimbingArea;
import com.skilldistillery.crag.entities.Gear;
import com.skilldistillery.crag.services.GearService;

@CrossOrigin({"*", "http://localhost:4210"})
@RequestMapping("api")
@RestController
public class GearController {
	
	@Autowired
	private GearService svc;
	

	
	@PutMapping("gear/{gearId}")
	public Gear index(HttpServletResponse res, Principal principal, @PathVariable int gearId, @RequestBody Gear gear){
		try {
			gear = svc.update(principal.getName(), gearId, gear);
			if (gear == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return gear;
	
	}
}
