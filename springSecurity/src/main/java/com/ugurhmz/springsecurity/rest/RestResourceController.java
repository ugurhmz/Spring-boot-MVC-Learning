package com.ugurhmz.springsecurity.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class RestResourceController {

	
	
	
	@GetMapping("/api/secure")
	@ResponseBody
	public String getApiSecureData() {
		
		return "{ \'ugur\' : \'hmz\'  }";
	}
	
	
}
