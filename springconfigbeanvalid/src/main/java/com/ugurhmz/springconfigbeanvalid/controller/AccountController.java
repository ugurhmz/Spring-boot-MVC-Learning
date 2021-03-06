package com.ugurhmz.springconfigbeanvalid.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ugurhmz.springconfigbeanvalid.business.dto.AccountDto;
import com.ugurhmz.springconfigbeanvalid.business.service.AccountService;



@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@Autowired
	private MessageSource messageSource;

	
	// GET EMPLOYEE
		@GetMapping(path= {"/account/edit", "/account/edit/{id}"})
		public String getEditEmployee(Model model, @PathVariable(name="id", required=false) Long accountId) 
		{
			AccountDto accountDto = accountService.findById(accountId);
			model.addAttribute("message",messageSource.getMessage("account.form.fill",null,null));
			model.addAttribute("account",accountDto);
			
			return "/ledger/AccountEdit";
		}
		
		
		
		
		// POST EMPLOYEE
		@PostMapping(path= {"/account/edit", "/account/edit/{id}"})
		public String postEditEmployee(Model model,@Valid  AccountDto accountDto, BindingResult result ) {	
			
			
			
			
			accountService.create(accountDto);
			model.addAttribute("message",messageSource.getMessage("account.form.saved",null,null));
			model.addAttribute("account",accountDto);
			return "/ledger/AccountEdit";
		}
	
	
}
