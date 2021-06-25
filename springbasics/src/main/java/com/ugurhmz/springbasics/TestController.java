package com.ugurhmz.springbasics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class TestController {

	@GetMapping("/mytest")
	@ResponseBody
	public String getTest() {
		return "Hello World!.... I'came here ";
	}
	
}
