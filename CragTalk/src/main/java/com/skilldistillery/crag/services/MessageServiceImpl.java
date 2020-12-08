package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.crag.entities.Message;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.MessageRepository;
import com.skilldistillery.crag.repositories.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MessageRepository messageRepo;

	@Override
	public List<Message> index(String username, int userId) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User receivedUser = userRepo.findByUsername(username);
		int receiverId = receivedUser.getId();
		return receivedUser.getMyListOfReceivedMessages();
	}

	@Override
	public Message show(String username, int messageId) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Optional <Message> messageOpt = messageRepo.findById(messageId);
		Message managedMessage = null;
		if (messageOpt.isPresent()) {
			managedMessage = messageOpt.get();
		}
		return managedMessage;
	}

	@Override
	public Message create(String username, Message message, int receiverUserId) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		
//		User user = userRepo.findByUsername(username);
//		Optional<User> receiverUserOpt = userRepo.findById(receiverUserId);
//		User receiverUser = null;
//		if (receiverUserOpt.isPresent()) {
//			message.setSenderId(user.getId());
//			receiverUser = receiverUserOpt.get();
//			user.addSentMessage(message);
//			messageRepo.saveAndFlush(message);
//			receiverUser.addReceivedMessage(message);
//			messageRepo.saveAndFlush(message);
			
//		}
		if (message != null) {
			messageRepo.saveAndFlush(message);
		}
		return message;
	}
	
//	attach sender ID to new message
//	get username . get id 


	@Override
	public boolean destroy(String username, int messageId) {
		boolean deleted = false;
		if (userRepo.findByUsername(username) == null) {
			return deleted;
		}
		Optional <Message> messageOpt = messageRepo.findById(messageId);
		Message managedMessage = null;
		if (messageOpt.isPresent()) {
			managedMessage = messageOpt.get();
			messageRepo.delete(managedMessage);
			return !deleted;
		}
		return deleted;

}
}
