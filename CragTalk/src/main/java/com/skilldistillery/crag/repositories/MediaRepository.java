package com.skilldistillery.crag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Media;
import com.skilldistillery.crag.entities.User;

public interface MediaRepository extends JpaRepository<Media, Integer> {
	List<Media> findByUser(User user);
	Media findUser_idByUsernameAndId(String username, int mediaId);
}
