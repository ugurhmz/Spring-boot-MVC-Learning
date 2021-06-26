package com.ugurhmz.springbasics.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MessageController {

	
	@GetMapping("/models/message")
	public String getMyMessage(Model model) {
		model.addAttribute("message","This is my message....");
		return "models/messagePage";
	}
	
}
