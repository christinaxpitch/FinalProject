//package com.skilldistillery.crag.services;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.skilldistillery.crag.entities.Message;
//import com.skilldistillery.crag.entities.User;
//import com.skilldistillery.crag.repositories.MessageRepository;
//import com.skilldistillery.crag.repositories.UserRepository;
//
//@Service
//public class MessageServiceImpl implements MessageService {
//	
//	@Autowired
//	private UserRepository userRepo;
//	
//	@Autowired
//	private MessageRepository messageRepo;
//
//	@Override
//	public Set<Message> index(String username, int userId) {
//		if (userRepo.findByUsername(username) == null) {
//			return null;
//		}
////		Set <Message> messages = null;
//		
//		return messageRepo.findBySenderIdAndReceiverId_UsernameAndId(username);
//	}
//
//	@Override
//	public Message show(String username, int id) {
//		return messageRepo.findByUsers_UsernameAndId(username, id);
//	}
//
//	@Override
//	public Message create(String username, Message message) {
//		User user = userRepo.findByUsername(username);
//		if (user != null) {
////			user.addUser(user);
//			messageRepo.saveAndFlush(message);
//			
//		}
//		return message;
//	}
//
//	@Override
//	public Message update(String username, int id, Message message) {
//		Message managedMessage = messageRepo.findByUsers_UsernameAndId(username, id);
//		if(managedMessage != null) {
//			managedMessage.setMessageBody(message.getMessageBody());
//		}
//		
//		return managedMessage;
//	}
//
//	@Override
//	public boolean destroy(String username, int id) {
//		boolean deleted = false;
//		Message message = messageRepo.findByUsers_UsernameAndId(username, id);
//		if (message != null) {
//			messageRepo.delete(message);
//			deleted = true;
//		}
//		return deleted;
//
//}
//}