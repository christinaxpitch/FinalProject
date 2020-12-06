package com.skilldistillery.crag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Media;

public interface MediaRepository extends JpaRepository<Media, Integer> {
	List<Media> findByUser_Username(String username);
	Media findByUser_UsernameAndId(String username, int mediaId);

}
