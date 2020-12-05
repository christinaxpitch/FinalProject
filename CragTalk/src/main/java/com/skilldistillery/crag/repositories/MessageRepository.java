package com.skilldistillery.crag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
