package com.ugurhmz.springbasics.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ShowController {

	@GetMapping("/showpage")
	public String getShowPage() {
		
		return "ShowPage";
	}
	
	
	
	@GetMapping("/pages/mypage")
	public String myPage() {
		return "pages/mypage";
	}
	
	
}
