package com.ugurhmz.springsecurity.matcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

	
	// LOGIN
	@GetMapping("/login")
	public String getLogin(@RequestParam(name="error", required=false) String error, Model model) {
		
		if(error != null) {
			model.addAttribute("message","Identity information is wrong!!");
		}
		
		return "custom/LoginPage";
	}
	
	
	
	// LOGOUT
	@GetMapping("/logout")
	//@ResponseBody
	public String getLogout(HttpServletRequest request,HttpServletResponse response ) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		
		//return  authentication;	
		return "custom/LogoutPage";
	}
	
	
	
	// CURRENT USER
	@GetMapping("/current")
	@ResponseBody
	public String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null) {
			return authentication.getName();
		}
		
		
		return "Not logged in  <a href='/login'>Login</a>";
	}
	
	
}











