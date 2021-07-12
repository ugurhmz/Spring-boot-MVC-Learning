package com.ugurhmz.springrest.sports.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ugurhmz.springrest.sports.data.Player;




@Controller
public class TransferController {

	
	@GetMapping("/client/header")
	@ResponseBody
	public String getHeader( ) {
		String url = "http://localhost:8080/transfer/header";
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("input","Ugur hmz");
		
		HttpEntity<String> entity = new HttpEntity<String>("Gövde",headers);
		ResponseEntity<String> response = restTemplate.exchange(
				url, HttpMethod.GET, entity, String.class);
		
		return "Başlık Gönderildi : "+response.getBody();
		
	}
	
	
	@GetMapping("/client/cookie")
	@ResponseBody
	public String getCookie( ) {
		String url = "http://localhost:8080/transfer/cookie";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.COOKIE, "input=Hmz");
		
		HttpEntity<String> entity = new HttpEntity<String>("Gövde",headers);
		ResponseEntity<String> response = restTemplate.exchange(
				url, HttpMethod.GET, entity, String.class);
		
		return "Cookie Gönderildi : "+response.getBody();
		
	}
	
	
}
