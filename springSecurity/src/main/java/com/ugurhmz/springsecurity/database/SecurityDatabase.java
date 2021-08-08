package com.ugurhmz.springsecurity.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@EnableWebSecurity
public class SecurityDatabase extends WebSecurityConfigurerAdapter {

	
	
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
		.logout()
			.logoutSuccessUrl("/logout")
			.invalidateHttpSession(true)
			.permitAll();
	}
	
	
	@Autowired
	public void configrueGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.userDetailsService(userDetailService())
			.passwordEncoder(passwordEncoder());
	}
	
	
	@Bean 
	public UserDetailsService userDetailService() {
		return new UserDetailsServiceImpl();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
}














