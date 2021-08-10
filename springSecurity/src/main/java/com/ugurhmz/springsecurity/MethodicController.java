package com.ugurhmz.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MethodicController {
	
	@Autowired
	private MethodicService methodicService;

	
	@GetMapping("/method/admin")
	@ResponseBody
	public String getMyAdmin() {
		
		return methodicService.getAdminValue();
	}
	
	
	@GetMapping("/method/user")
	@ResponseBody
	public String getUser() {
		
		return methodicService.getUserValue();
	}
	
	@GetMapping("/method/authorized")
	@ResponseBody
	public String getAuthorized() {
		
		return methodicService.getPreAuthorize();
	}
	
	
	
	
}
