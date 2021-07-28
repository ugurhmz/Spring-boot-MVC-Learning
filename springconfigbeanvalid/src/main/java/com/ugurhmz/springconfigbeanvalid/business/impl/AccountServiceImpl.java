package com.ugurhmz.springconfigbeanvalid.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springconfigbeanvalid.business.dto.AccountDto;
import com.ugurhmz.springconfigbeanvalid.business.service.AccountService;
import com.ugurhmz.springconfigbeanvalid.data.entity.Account;
import com.ugurhmz.springconfigbeanvalid.data.repository.AccountRepository;




@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private AccountRepository accountRepository;
	
	
	// CREATE
	@Override
	public void create(AccountDto accountDetail) {
		
		Account account = new Account();
		convertToEntity(accountDetail, account);
		accountRepository.save(account);
		
		
		
		
		
	}

	
	// UPDATE
	@Override
	public void update(AccountDto accountDetail) {
		Account account =  new Account();
				
		convertToEntity(accountDetail,account);
		accountRepository.save(account);
	}

	
	// FIND BY ID
	@Override
	public AccountDto findById(Long accountId) {
		
		AccountDto accountDetail=null;
		
		if(accountId != null) {
			Optional<Account> account = accountRepository.findById(accountId);		
			if(account.isPresent()) {
				accountDetail = convertToDto(account.get());
				return accountDetail;
			}	
		}
		
		if(accountDetail == null) {
			accountDetail = new AccountDto();
			accountDetail.setAccountName("");
		}
		
		return accountDetail;
		
		
		
		
	}

	
	// Convert To Entity
		private void convertToEntity(AccountDto accountDto, Account account) {
			
			account.setAccountId(accountDto.getAccountId());
			account.setAccountName(accountDto.getAccountName());
			account.setTotalBalance(accountDto.getTotalBalance());
			
		}
	
		
	// conver to Dto
	private AccountDto convertToDto(Account account) {
		AccountDto accountDetail = new AccountDto();
		accountDetail.setAccountId(account.getAccountId());
		accountDetail.setAccountName(account.getAccountName());
		accountDetail.setTotalBalance(account.getTotalBalance());
		
		
		return accountDetail;
	}
	
}







