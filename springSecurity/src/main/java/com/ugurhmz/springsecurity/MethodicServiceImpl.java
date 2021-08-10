package com.ugurhmz.springsecurity;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class MethodicServiceImpl implements MethodicService {

	
	
	
	
	//@Secured("ROLE_ADMIN")
	@RolesAllowed("ROLE_ADMIN")
	public String getAdminValue() {
		return "I'm Admin";
	}

	
	
	@Secured("ROLE_USER")
	public String getUserValue() {
		return "I'M user" ;
	}
	
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public String getPreAuthorize() {
		
		return "Pre Authorize";
	}
	
	
}
