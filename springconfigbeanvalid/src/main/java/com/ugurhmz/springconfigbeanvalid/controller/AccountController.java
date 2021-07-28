package com.ugurhmz.springconfigbeanvalid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ugurhmz.springconfigbeanvalid.message.Account;


@Controller
public class AccountController {
	

	
	// GET ACCOUNT
	@GetMapping("/account/edit")
	public String getEditAccount(Model model) 
	{
		Account account  = new Account(0,"",0.0);
		model.addAttribute("message","Account");
		model.addAttribute("account",account);
		
		return "/ledger/AccountEdit";
	}
	
	
	
	
	// POST ACCOUNT
	@PostMapping(path= {"/account/edit/{id}", "/account/edit"})
	public String postEditAccount(Model model,Account account, BindingResult result) {
		
		if(result.hasErrors()) {
			result.addError(new ObjectError("account","There is error for account!!"));
			return "/ledger/AccountEdit";
		}
		
		
		model.addAttribute("message","Successfully saved");
		model.addAttribute("account",account);
		
		return "/ledger/AccountEdit";	
	}
	
	
	
	
	
}
