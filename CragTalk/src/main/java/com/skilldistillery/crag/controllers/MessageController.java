package com.skilldistillery.crag.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.crag.entities.Message;
import com.skilldistillery.crag.services.MessageService;
import com.skilldistillery.crag.services.UserService;

@CrossOrigin({ "*", "http://localhost:4210" })
@RequestMapping("api")
@RestController
public class MessageController {
	
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private MessageService messageService;
	
//	private String username = "shakawithme";
	
//	View All Messages 
//	@GetMapping(path = "/{uid}/messages")
//	public List<Message> getAllMessages(@RequestBody List<Message> messages, HttpServletResponse res, Principal principal,
//			@PathVariable Integer uid) {
//		if (messages == null) {
//			res.setStatus(400);
//		}
//		messages = messageService.show(principal.getName(), uid);
//		return messages;
//	}
	

//	Remove a message
	@DeleteMapping(path = "user/messages/{mid}")
	public void destroy(@PathVariable Integer mid, Principal principal) {
		messageService.destroy(principal.getName(), mid);
	}

	
	//add a message
	@PostMapping(path = "user/message/{receiverUserId}")
	public Message addMessage(@RequestBody Message message, @PathVariable Integer receiverUserId, Principal principal) {
	return messageService.create(principal.getName(), message, receiverUserId);
}
	
	
	
}

