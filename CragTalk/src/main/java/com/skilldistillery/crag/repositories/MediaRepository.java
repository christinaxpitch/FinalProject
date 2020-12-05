package com.skilldistillery.crag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Media;

public interface MediaRepository extends JpaRepository<Media, Integer> {

}
