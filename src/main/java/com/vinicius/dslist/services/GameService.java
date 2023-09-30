package com.vinicius.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.dslist.dto.GameMinDTO;
import com.vinicius.dslist.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	 public List<GameMinDTO> findAll(){
		 var result = gameRepository.findAll();
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	 }
}
