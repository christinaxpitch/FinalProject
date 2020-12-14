package com.skilldistillery.crag.controllers;

import java.security.Principal;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.services.AuthService;
import com.skilldistillery.crag.services.UserService;

@CrossOrigin({"*", "http://localhost:4210"})
@RestController
public class AuthController {
	
	@Autowired
	private AuthService authSvc;
	@Autowired
	private UserService userSvc;
	
	@PostMapping(path = "/register")
	public User register(@RequestBody User user, HttpServletResponse res, Principal principal) {
	    if (user == null) {
	        res.setStatus(400);
	    }
	    user = authSvc.register(user);

	    return user;
	}

	@GetMapping(path = "/authenticate")
	public User authenticate(Principal principal) {
	    User user = authSvc.getUser(principal.getName());
	    user.setLastLogin(LocalDateTime.now());
	    return user;
	}

}
