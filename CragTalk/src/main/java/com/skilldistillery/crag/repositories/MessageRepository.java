package com.skilldistillery.crag.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	Message findByUser_UsernameAndId(String username, int id);
	Set<Message> findByUser_Username(String username);

}
