package com.ugurhmz.springconfigbeanvalid.business.service;

import com.ugurhmz.springconfigbeanvalid.business.dto.AccountDto;

public interface AccountService {

	
	public void create(AccountDto accountDetail);
	public void update(AccountDto accountDetail);
	
	
	public AccountDto findById(Long accountId);
	
	
}
