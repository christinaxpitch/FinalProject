package com.skilldistillery.crag.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
//	Message findBySenderIdAndReceiverId_UsernameAndId(String username, int messageId);
//	Set<Message> findBy_Username(String username);

}
