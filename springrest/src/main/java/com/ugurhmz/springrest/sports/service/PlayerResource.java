package com.ugurhmz.springrest.sports.service;



import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ugurhmz.springrest.sports.data.Player;


@RestController
public class PlayerResource {

	
	
	//@GetMapping(value="/sports/player", produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/sports/player/{id}")
	public Player getPlayer(@PathVariable("id") long playerId) {
		
		Player player = new Player(playerId, "Selen Düz", 12.45);
		
		return player;			
	}
	
	
	@GetMapping("/sports/players")
	public List<Player> getPlayerList(){
		List<Player> playerList =new  ArrayList<>();
		playerList.add(new Player(100,"Yıldız Uçak",10.34));
		playerList.add(new Player(101,"Selami Şahin",8.32));
		playerList.add(new Player(102,"Ayşe Duman",12.34));
		playerList.add(new Player(103,"Selim Yıldız",11.34));
		
		return playerList;
	}
	
	
	@PostMapping("/sports/playerpost")
	public Player postPlayer(@RequestBody Player player) {
		System.out.println(player.getPlayerId()+" "+
				player.getPlayerName()+" "+
				player.getAverageScore());
		
		player.setPlayerId(803);
		return player;	
	}
	
	
	
}

















