package com.ugurhmz.springThymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springThymeleaf.entity.Player;
import com.ugurhmz.springThymeleaf.repository.PlayerRepository;



@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepo;
	
	
	// LIST ALL PLAYERS
	public List<Player> listAllPlayers() {
		return (List<Player>) playerRepo.findAll();
	}
	
	
	
	// CREATE & UPDATE
	public Player save(Player player) {
		
		boolean isUpdatingPlayer = (player.getPlayerId() != null);
		
		
		if(isUpdatingPlayer) {
			Player playerExisting = playerRepo.findById(player.getPlayerId()).get();
		}
	
		return playerRepo.save(player);
		
	}
	
	
	
	
	
	
}
