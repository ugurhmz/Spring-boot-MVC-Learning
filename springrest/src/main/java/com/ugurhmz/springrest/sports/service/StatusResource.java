package com.ugurhmz.springrest.sports.service;

import java.nio.charset.Charset;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ugurhmz.springrest.sports.data.Player;



@RestController
public class StatusResource {

	
	
	@GetMapping("/status/ok/{id}")
	public ResponseEntity<?> getOK(@PathVariable(name="id") long playerId) {
			Player player = new Player(playerId,"Seda Yıldız",16.5);			
			
			//return new ResponseEntity<>(player,HttpStatus.OK);
			
			//return ResponseEntity
						//.status(HttpStatus.OK)
						//.body(player);
			
			//return ResponseEntity
						//.ok()
						//.body(player);
			
			return ResponseEntity.ok(player);
			
	}
	
	@GetMapping("/status/notfound/{id}")
	public ResponseEntity<?> getNotFound(@PathVariable(name="id") long playerId) {
		Player player = new Player(playerId,"Selen uçak",15.4);
		
		if(playerId == 0) {
			//return ResponseEntity
						//.status(HttpStatus.NOT_FOUND)
						//.body("Kullanıcı Bulunamadı");
			
			return ResponseEntity
					.notFound()
					.build();
			
		}
		
		return ResponseEntity.ok(player);	
	}
	
	
	@GetMapping("/status/type/{id}")
	public ResponseEntity<?> getType(@PathVariable(name="id") long playerId) {
		Player player = new Player(playerId,"Selim ay",12.3);
		
		
		return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(new MediaType("application","json",Charset.forName("UTF-8")))
					.body(player);
		
	}
	
}

















