package com.skilldistillery.crag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.crag.entities.Gear;

public interface GearRepository extends JpaRepository<Gear, Integer> {

}
