package com.ugurhmz.springsecurity.matcher;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AuthorizationController {

	
	
	@GetMapping("/lowSecurity")
	public String getLow(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		StringBuilder builder  = new StringBuilder();
		
		if(authentication != null) {
			for(GrantedAuthority authority : authentication.getAuthorities()) {
				builder.append(authority.getAuthority());
			}
		}
		
		model.addAttribute("userName",builder);
		return "lowSecurity/LowSecurityPage";
	}
	
	
	@GetMapping("/highSecurity")
	public String getHigh(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 	//VAR OLAN KULLANCYI VERİR
		StringBuilder builder  = new StringBuilder();
		
		if(authentication != null) {
			for(GrantedAuthority authority : authentication.getAuthorities()) {
				builder.append(authority.getAuthority()).append(" "); // KULLANICININ İÇİNDEN HANGİ YETKİLERİ VAR DIR BU GÖSTERİYOR
			}
		}
		
		model.addAttribute("userName",builder);
		return "highSecurity/HighSecurityPage";
	}
	
	
}
