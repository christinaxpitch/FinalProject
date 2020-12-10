package com.skilldistillery.crag.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.crag.entities.Media;
import com.skilldistillery.crag.services.MediaService;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class MediaController {

	@Autowired
	private MediaService mediaService;
	
	@GetMapping("media")
	public List<Media> index(HttpServletResponse res, Principal principal) {
		List<Media> media = mediaService.index();
		try {
			if (media == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
		return media;
	}
}
