package com.ugurhmz.springrest.sports.service;



import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//XML 
	@GetMapping(value="/sports/xplayers", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Player> getPlayersXMl(){
		List<Player> players = new ArrayList<>();
		
		players.add(new Player(0,"Samet Engin",15.34));
		players.add(new Player(0,"Samet Engin",12.46));
		players.add(new Player(0,"Samet Engin",17.67));
		
		return players;
	}
	
	
	
	
	
	@PostMapping("/sports/playerpost")
	public Player postPlayer(@RequestBody Player player) {
		System.out.println(player.getPlayerId()+" "+
				player.getPlayerName()+" "+
				player.getAverageScore());
		
		player.setPlayerId(803);
		return player;	
	}
	
	
	
	@PutMapping("/sports/player")
	public boolean putPlayer(@RequestBody Player player) {
		
		System.out.println("Güncelleniyor : "+player.getPlayerId()+" "+
				player.getPlayerName()+" "+
				player.getAverageScore());		
		
		return true;
	}
	
	
	@DeleteMapping("/sports/player/{id}")
	public void deletePlayer(@PathVariable("id") long playerId) {
		
		System.out.println("Siliniyor : "+playerId);
	}
	
	
}

















