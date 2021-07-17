package com.ugurhmz.springcomplex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	
	@GetMapping("/test")
	@ResponseBody
	public String getTestIndex() {
		
		return "<h2 style='color:green'>This is test</h2>";
	}
}

