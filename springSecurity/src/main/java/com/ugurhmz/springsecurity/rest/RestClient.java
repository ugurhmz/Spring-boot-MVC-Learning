package com.ugurhmz.springsecurity.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;




@Controller
public class RestClient {
	
	
	
	@GetMapping("/client/secure")
	@ResponseBody
	public String clientSecure() {
		
		String url="http://localhost:8080/api/secure";
		String userName = "ugur";
		String password="merhaba";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(userName, password);	
		
		HttpEntity<String> entity = new HttpEntity<String>("Gövde",headers);
		ResponseEntity<String> response = restTemplate
				.exchange(url, HttpMethod.GET,entity, String.class);
		
		return "Send header : " +response.getBody();
	}
	
	
}








