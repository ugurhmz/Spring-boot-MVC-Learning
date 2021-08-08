package com.ugurhmz.springsecurity.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;




@EnableWebSecurity
public class SecurityAuthorize  extends WebSecurityConfigurerAdapter{

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/","/home").permitAll()
			.antMatchers("/lowSecurity").hasRole("USER")
			.antMatchers("/highSecurity").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
			.and()
		.httpBasic();	
	}
	
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
				.withUser("myuser")
					.password("{noop}1994ugur")
					.roles("USER","ADMIN")
					.and()
				.withUser("ayse")
					.password("{noop}ayse123")
					.roles("USER")
					.and();
			
	}
	
}









