package com.ugurhmz.springaop.module.sales.impl;

import org.springframework.stereotype.Service;

import com.ugurhmz.springaop.module.sales.SalesService;


@Service
public class SalesServiceImpl implements SalesService {

	@Override
	public String performSomething(String input) {
	
		return "Sales : "+input;
	}

}
