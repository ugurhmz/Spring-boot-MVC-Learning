package com.ugurhmz.springcomplex.business.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springcomplex.business.dto.EmployeeDetail;
import com.ugurhmz.springcomplex.business.dto.EmployeeSummary;
import com.ugurhmz.springcomplex.business.service.EmployeeService;
import com.ugurhmz.springcomplex.data.entity.Department;
import com.ugurhmz.springcomplex.data.entity.Employee;
import com.ugurhmz.springcomplex.data.repository.DepartmentRepository;
import com.ugurhmz.springcomplex.data.repository.EmployeeRepository;




@Service
public class EmployeeServiceImpl implements EmployeeService  {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	// SAVE 
	@Override
	public void create(EmployeeDetail employeeDetail) {
		Employee employee = convertToEntity(employeeDetail);
		employeeRepository.save(employee);
		employee.setEmployeeId(employee.getEmployeeId());
		
	}
	
	// UPDATE
	@Override
	public void update(EmployeeDetail employeeDetail) {
		
		
	}

	// DELETE
	@Override
	public void delete(long employeeId) {
		
		
	}

	// FIND BY ID
	@Override
	public EmployeeDetail findById(long employeeId) {
		
		return null;
	}
	

	//LIST DETAIL
	@Override
	public EmployeeSummary listDetail() {
		
		return null;
	}

	
	//LIST BY DEPARTMENT
	@Override
	public EmployeeSummary listByDepartment(long departmentId) {
		
		return null;
	}

	//COUNT BY DEPARTMENT
	@Override
	public int countByDepartment(long departmentId) {
		
		return 0;
	}
	
	
	// convert to Entity 
	public Employee convertToEntity(EmployeeDetail employeeDetail) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDetail.getEmployeeId());
		employee.setEmployeeName(employeeDetail.getEmployeeName());
		employee.setMonthlySalary(employeeDetail.getMonthlySalary());
		
		if(employeeDetail.getDepartmentId() != 0) {
			Optional<Department> department = departmentRepository.findById(employeeDetail.getDepartmentId());   
			if(department.isPresent()) {
				employee.setDepartment(department.get());
			}
		}
		
		return employee;
	}

}







