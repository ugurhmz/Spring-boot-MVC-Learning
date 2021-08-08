package com.ugurhmz.springsecurity.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;



public class UserDetailsServiceImpl implements UserDetailsService {

	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password="1994";
		String role="USER";
		return User
				.withUsername(username)
				.password(passwordEncoder.encode(password))
				.roles(role)
				.build();
	}
	


}
