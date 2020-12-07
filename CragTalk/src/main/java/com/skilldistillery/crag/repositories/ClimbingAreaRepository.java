package com.skilldistillery.crag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.ClimbingArea;

public interface ClimbingAreaRepository extends JpaRepository<ClimbingArea, Integer> {

List<ClimbingArea> findByUsers_Username(String username);

List<ClimbingArea> findFavoriteAreaListByUsers_Username(String username);

}
