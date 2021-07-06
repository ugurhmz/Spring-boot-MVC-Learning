package com.ugurhmz.springorm.entity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	// CREATE 
	@GetMapping("/customer/persist")
	@ResponseBody
	public String persistCustomer(
			@RequestParam(name = "name") String customerName,
			@RequestParam(name="debit") double totalCredit) 
	{
		
		Customer customer = new Customer(0,customerName,totalCredit);
		customerRepository.save(customer);
		
		return "Eklenen : "+customer.getCustomerId()+" - "+customer.getCustomerName();
		
	}
	
	
	// READ findById
	@GetMapping("customer/find/{id}")
	@ResponseBody
	public String findCustomer(
			@PathVariable(name = "id") long customerId) 
	{
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(optional.isPresent()) {
			Customer customer = optional.get();
				
			return "Customer "+customer.getCustomerId()+" - "+customer.getCustomerName()+
					" Total credit : "+customer.getTotalCredit()
			;
		} else {
			return "Customer Bulunamadı : "+customerId;
		}
		
	}
	
	// UPDATE 
	@GetMapping("customer/update/{id}")
	@ResponseBody
	public String updateCustomer(
			@PathVariable(name="id") long customerId,
			@RequestParam(name="name") String customerName,
			@RequestParam(name="credit") double totalCredit) 
	{
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(optional.isPresent()) {
			Customer customer = optional.get();
			customer.setCustomerName(customerName);
			customer.setTotalCredit(totalCredit);
			
			customerRepository.save(customer);
			
			return "Güncelleme başarılı : "+customer.getCustomerName()+" "+customer.getTotalCredit();		
		}
		
		else {
			return "Aranan ID: "+customerId+" bulunamadı!";
		}
	}
	
	
	
	// DELETE
	
	@GetMapping("customer/delete/{id}")
	@ResponseBody
	public String deleteCustomer(
			@PathVariable(name = "id") long customerId) 
	{
		Optional<Customer> optional = customerRepository.findById(customerId);
		
		if(optional.isPresent()) {
			customerRepository.deleteById(customerId);
			
			return optional.get().getCustomerName() + " başarıyla silindi.";
		}
		else {
			return "Aranan ID: "+customerId+" bulunamadı ve silinemedi!";
		}
		
	}
	
	
	
}

















