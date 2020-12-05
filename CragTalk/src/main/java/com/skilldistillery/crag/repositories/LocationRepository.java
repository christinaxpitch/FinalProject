package com.skilldistillery.crag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
