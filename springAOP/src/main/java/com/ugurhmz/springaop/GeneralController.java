package com.ugurhmz.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ugurhmz.springaop.module.sales.SalesService;


@Controller
public class GeneralController {
	
	@Autowired
	private SalesService salesService;
	
	
	@GetMapping("/aop/sales/{input}")
	@ResponseBody
	public String getSale(@PathVariable("input") String input) {
		
		String outPut = salesService.performSomething(input);
		
		return outPut;
	}
	
}