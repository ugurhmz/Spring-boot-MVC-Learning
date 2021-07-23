package com.ugurhmz.springcomplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ugurhmz.springcomplex.business.dto.DepartmentSummaryDto;
import com.ugurhmz.springcomplex.business.dto.EmployeeDetailDto;
import com.ugurhmz.springcomplex.business.dto.EmployeeSummaryDto;
import com.ugurhmz.springcomplex.business.service.DepartmentService;
import com.ugurhmz.springcomplex.business.service.EmployeeService;




@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private DepartmentService departmentService;
	
	
	
	
	
	// GET EMPLOYEE
	@GetMapping(path= {"/employee/edit", "/employee/edit/{id}"})
	public String getEditEmployee(Model model, @PathVariable(name="id", required=false) Long employeeId) 
	{
		EmployeeDetailDto employeeDetailDto = employeeService.findById(employeeId);
		DepartmentSummaryDto departments = departmentService.list();
		
		
		model.addAttribute("employee",employeeDetailDto);
		model.addAttribute("departments",departments);
		
		return "empEdit";
	}
	
	
	
	
	// POST EMPLOYEE
	@PostMapping(path= {"/employee/edit", "/employee/edit/{id}"})
	public String postEditEmployee(Model model, EmployeeDetailDto employeeDetailDto, BindingResult result ) {	
		
		DepartmentSummaryDto departments = departmentService.list();
			
		model.addAttribute("employee",employeeDetailDto);
		model.addAttribute("departments",departments);
		
		
		if(result.hasErrors()) {
			result.addError(new ObjectError("employeeDetailDto", "Error!!"));
			return "empEdit";
		}
		
		employeeService.create(employeeDetailDto);
		model.addAttribute("message","Employee successfully added");
		model.addAttribute("emp",employeeDetailDto);
		return "empSuccess";
	}
	
	
	
	
	
	// GET EMPLOYEE LIST
	@GetMapping("/employee/list")
	public String getEmployeeList(Model model) {
		EmployeeSummaryDto employees = employeeService.listDetail();
		model.addAttribute("message","Employees");
		model.addAttribute("employees",employees);
		
		return "empList";
	}
	
	
	// DELETE EMPLOYEE
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable("id") Long employeeId) {
		employeeService.delete(employeeId);
		
		model.addAttribute("message","Employee deleted");
		EmployeeSummaryDto employees = employeeService.listDetail();
		model.addAttribute("employees",employees );
		
		return "empList";
	}
	
	
	
}
















