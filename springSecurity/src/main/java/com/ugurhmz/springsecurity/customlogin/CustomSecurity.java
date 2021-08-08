package com.ugurhmz.springsecurity.customlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class CustomSecurity extends WebSecurityConfigurerAdapter {

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http 
			.authorizeRequests()
			.antMatchers("/","/home").permitAll()
			.antMatchers("/login").permitAll()
			.anyRequest()
			.authenticated()
			.and()		
		.formLogin()
			.loginPage("/login")	//	/login başarılı olursa alttaki /welcome git
			.defaultSuccessUrl("/welcome")
			.and()
		.httpBasic();
	}
	
	
	@Autowired
	public void configrueGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
			.withUser("hello")
			.password("{noop}1994ugur")
			.roles("USER");
	}
	
}
