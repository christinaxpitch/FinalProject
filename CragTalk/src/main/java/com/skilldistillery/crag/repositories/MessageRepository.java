package com.skilldistillery.crag.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
//	Message findBySenderIdAndReceiverId_UsernameAndId(String username, int messageId);
	
//	Set<Message> findByReceiverId_Username(String username);


//	List <Message> findByReceiverId(int receiverId);
//	List <Message> findBySenderId(int senderId);
//	
}
