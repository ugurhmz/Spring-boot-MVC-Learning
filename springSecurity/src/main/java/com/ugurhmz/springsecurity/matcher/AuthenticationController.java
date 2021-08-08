package com.ugurhmz.springsecurity.matcher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

	
	
	@GetMapping("/login")
	public String getLogin(@RequestParam(name="error", required=false) String error, Model model) {
		
		if(error != null) {
			model.addAttribute("message","Identity information is wrong!!");
		}
		
		return "custom/LoginPage";
	}
	
}
