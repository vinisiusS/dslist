package com.vsouto.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsouto.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
}
