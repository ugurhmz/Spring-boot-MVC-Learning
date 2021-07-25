package com.ugurhmz.springcomplex.business.impl;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ugurhmz.springcomplex.business.dto.DepartmentDetailDto;
import com.ugurhmz.springcomplex.business.dto.DepartmentSummaryDto;
import com.ugurhmz.springcomplex.business.dto.EmployeeDetailDto;
import com.ugurhmz.springcomplex.business.service.DepartmentService;
import com.ugurhmz.springcomplex.data.entity.Department;
import com.ugurhmz.springcomplex.data.entity.Employee;
import com.ugurhmz.springcomplex.data.repository.DepartmentRepository;
import com.ugurhmz.springcomplex.data.repository.EmployeeRepository;



@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public DepartmentSummaryDto list() {
		DepartmentSummaryDto departmentSummaryDto = new DepartmentSummaryDto();
		departmentSummaryDto.setDepartmentDetailList(new ArrayList<>());
		
		for(Department department : departmentRepository.findAll() ) {
			DepartmentDetailDto departmentDetailDto = convertToDto(department);
			departmentSummaryDto.getDepartmentDetailList().add(departmentDetailDto);
		}
		
		return departmentSummaryDto;
		
	}
	
	
	// conver to Dto
	private DepartmentDetailDto convertToDto(Department department) {
		DepartmentDetailDto departmentDetailDto = new DepartmentDetailDto();
		departmentDetailDto.setDepartmentId(department.getDepartmentId());
		departmentDetailDto.setDepartmentName(department.getDepartmentName());
		
		return departmentDetailDto;
	}

	
	
	
	// GENERATE DEPARTMENT
	
	@Override
	@Transactional
	public long generateDepartment(String departmentName) {
		 
		Department department = new Department();
		department.setDepartmentName(departmentName);
		departmentRepository.save(department);
		
		generateEmployees(department);
		
		return department.getDepartmentId();
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void generateEmployees(Department department) {
		 
	
		
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Employee 1");
		employee1.setMonthlySalary(5700.2);
		employee1.setDepartment(department);
		
		employeeRepository.save(employee1);
		
		
		Employee employee2 = new Employee();
		employee2.setEmployeeName("Employee 2");
		employee2.setMonthlySalary(6500.2);
		employee2.setDepartment(department);
		
		employeeRepository.save(employee2);
		
		
		if(true) {
			throw new RuntimeException("Crash!!");
		}
		
		
		Employee employee3 = new Employee();
		employee3.setEmployeeName("Employee 3");
		employee3.setMonthlySalary(7500.2);
		employee3.setDepartment(department);
		
		employeeRepository.save(employee3);
		
		
	}
	
	
	
	
	
	
	
	
	
}
