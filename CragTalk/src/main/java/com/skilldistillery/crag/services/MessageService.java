package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Set;

import com.skilldistillery.crag.entities.Message;

public interface MessageService {
	
	 public List<Message> index(String username, int messageId);

	    public Message show(String username, int id);

	    public Message create(String username, Message message, int receiverUserId);

	    public boolean destroy(String username, int id);

}
