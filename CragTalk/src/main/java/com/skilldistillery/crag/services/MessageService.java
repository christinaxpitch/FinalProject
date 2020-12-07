package com.skilldistillery.crag.services;

import java.util.Set;

import com.skilldistillery.crag.entities.Message;

public interface MessageService {
	
	 public Set<Message> index(String username, int messageId);

	    public Message show(String username, int id);

	    public Message create(String username, Message message, int receiverUserId);

	    public Message update(String username, int id, Message message);

	    public boolean destroy(String username, int id);

}
