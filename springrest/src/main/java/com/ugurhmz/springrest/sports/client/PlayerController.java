package com.ugurhmz.springrest.sports.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ugurhmz.springrest.sports.data.Player;



@Controller
public class PlayerController {

	
	@GetMapping("/client/sports/{id}")
	@ResponseBody
	public String getPlayer(@PathVariable("id") long playerId) {
		
		String url = "http://localhost:8080/sports/player/"+playerId;
		RestTemplate restTemplate = new RestTemplate();
		
		//String json = restTemplate.getForObject(url, String.class);
		//System.out.println(json);
		
		
		//Player player = restTemplate.getForObject(url, Player.class);	
		
		ResponseEntity<Player> response =  restTemplate.exchange(
				url, HttpMethod.GET, HttpEntity.EMPTY, Player.class);
		
		Player player= response.getBody();
		return "Player Alındı : "+player.getPlayerName()+" "+player.getAverageScore();
			
	}
	
	@GetMapping("/clients/players")
	@ResponseBody
	public String getPlayers() {
		String url = "http://localhost:8080/sports/players";
		RestTemplate restTemplate = new RestTemplate();		
		ResponseEntity<List<Player>> response =  restTemplate.exchange(
				url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<Player>>() {
				});
		
		List<Player> playerList = response.getBody(); 	
		
		for(Player player : playerList ) {
				System.out.println(player.getPlayerId()+" "+
		player.getPlayerName()+" "+
		player.getAverageScore());
		}
		
	
		return "playerList : "+playerList.size();
	}
}












