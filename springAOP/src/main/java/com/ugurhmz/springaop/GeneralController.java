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
	
	
	@GetMapping("/aop/something/{input}")
	@ResponseBody
	public String getSomething(@PathVariable("input") String input) {
		
		String outPut = salesService.performSomething(input);
		return outPut;
	}
	
	
	@GetMapping("/aop/another/{input}")
	@ResponseBody
	public String  getAnother(@PathVariable("input") String input) {
		
		String outPut = salesService.performAnother(input);
		return outPut;
	}
	
	
	@GetMapping("/aop/handle/{input}")
	@ResponseBody
	public String  getHandle(@PathVariable("input") String input) {
		
		String outPut = salesService.handleSomething(input);
		return outPut;
	}
	
	
}






