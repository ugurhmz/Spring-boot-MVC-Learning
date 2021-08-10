package com.ugurhmz.springThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class TemplateController {

	
	@GetMapping("/home")
	public String getIndex(Model model) {
		
		model.addAttribute("mymessage","There is a message from me");
		return "index";
	}
	
	
}
