package com.ugurhmz.springsecurity.matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;




@EnableWebSecurity
public class SecurityMatcher  extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http 
			.authorizeRequests()
			.antMatchers("/","/home")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()		
		.formLogin()
			.and()
		.httpBasic();
	}
	
	
	@Autowired
	public void configrueGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
			.withUser("ugur")
			.password("12345")
			.roles("USER");
	}
	
	
	
	
	
}













