package com.ugurhmz.springbasics.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ValidatingController {

	
	@GetMapping("/validating/employeeForm")
	public String getEmployee(Model model) {
		Employee employee = new Employee(0,"",0.0);
		model.addAttribute("employee",employee);
		
		return "editing/employeeForm";
	}
	
	
	@PostMapping("/validating/employeeForm")
	public String postEmployee(Model model, Employee employee, BindingResult result) {
		model.addAttribute("employee",employee);
		if(result.hasErrors()) {
			System.out.println("Saklanıyor "+
					employee.getEmployeeId()+" "+
					employee.getEmployeeName()+" "+
					employee.getMonthlySalary());	
			return "editing/employeeForm";
		}
		
		if(employee.getEmployeeName().length() < 3) {
			result.addError(new ObjectError("employeeName","Employee alanında hata var!" ));
			result.addError(new FieldError("employee", "employeeName", "Employee Name en az 3 karakterli olmalı!"));
			
			return "editing/employeeForm";
		}
		
		
		
		
		//HATA yoksa şu page'yi göster.
		model.addAttribute("mymessage","işlem başarılı...");
		return "editing/employeeSuccess";
		
		
	}
	
	
	
	
}
