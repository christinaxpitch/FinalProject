package com.skilldistillery.crag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findByFavoriteArea(String username);

}

