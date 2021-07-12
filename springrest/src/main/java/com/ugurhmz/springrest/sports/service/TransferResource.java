package com.ugurhmz.springrest.sports.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TransferResource {

	
	@GetMapping("/transfer/header")
	public ResponseEntity<?> getHeader(
			@RequestHeader(value="input") String input){
		
		String output = "Input : "+input;
		return ResponseEntity
				.ok(output);
	}
	
	@GetMapping("/transfer/cookie")
	public ResponseEntity<?> getCookie(
			@CookieValue(value="input") String input)
	{
		String output  = "My Input : "+input;
		return ResponseEntity.ok(output);
		
	}
	
}







