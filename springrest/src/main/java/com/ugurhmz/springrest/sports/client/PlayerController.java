package com.ugurhmz.springrest.sports.client;

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
		
		
		Player player = restTemplate.getForObject(url, Player.class);		
		return "Player Alındı : "+player.getPlayerName()+" "+player.getAverageScore();
		
		
	}
}
