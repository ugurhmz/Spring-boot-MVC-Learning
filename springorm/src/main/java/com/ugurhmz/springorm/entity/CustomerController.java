package com.ugurhmz.springorm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@GetMapping("/customer/persist")
	@ResponseBody
	public String persistCustomer() {
		
		Customer customer = new Customer(0,"Gamze Yılmaz",124124124);
		customerRepository.save(customer);
		
		return "Eklenen : "+customer.getCustomerId()+" - "+customer.getCustomerName();
		
	}
	
}
