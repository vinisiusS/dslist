package com.vinicius.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinicius.dslist.dto.GameDTO;
import com.vinicius.dslist.dto.GameMinDTO;
import com.vinicius.dslist.entities.Game;
import com.vinicius.dslist.projections.GameMinProjection;
import com.vinicius.dslist.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	 public List<GameMinDTO> findAll(){
		 var result = gameRepository.findAll();
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	 }
	
	@Transactional(readOnly = true)
	 public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	 }
}
