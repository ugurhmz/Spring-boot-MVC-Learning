package com.ugurhmz.springcomplex.business.impl;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springcomplex.business.dto.EmployeeDetailDto;
import com.ugurhmz.springcomplex.business.dto.EmployeeSummaryDto;
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
	public void create(EmployeeDetailDto employeeDetail) {
		Employee employee = convertToEntity(employeeDetail);
		employeeRepository.save(employee);
		employeeDetail.setEmployeeId(employee.getEmployeeId());
		
	}
		
	
	
	// UPDATE
	@Override
	public void update(EmployeeDetailDto employeeDetail) {
		
		Employee employee = convertToEntity(employeeDetail);
		employeeRepository.save(employee);
	}
	
	

	// DELETE
	@Override
	public void delete(long employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

	
	
	// FIND BY ID
	@Override
	public EmployeeDetailDto findById(Long employeeId) {
		
		EmployeeDetailDto employeeDetail=null;
		
		if(employeeId != null) {
			Optional<Employee> employee = employeeRepository.findById(employeeId);		
			if(employee.isPresent()) {
				 employeeDetail = convertToDto(employee.get());
				return employeeDetail;
			}	
		}
		
		if(employeeDetail == null) {
			employeeDetail = new EmployeeDetailDto();
			employeeDetail.setEmployeeName("");
		}
		
		return employeeDetail;
	
	}
	
	

	//FIND ALL
	@Override
	public EmployeeSummaryDto listDetail() {
		EmployeeSummaryDto employeeSummaryDto = new EmployeeSummaryDto();
		employeeSummaryDto.setEmployeeDetailList(new ArrayList<>());
		
		for(Employee emp : employeeRepository.findAll() ) {
			EmployeeDetailDto employeeDetailDto = convertToDto(emp);
			employeeSummaryDto.getEmployeeDetailList().add(employeeDetailDto);
		}
		
		return employeeSummaryDto;
	}

	
	
	
	
	//LIST BY DEPARTMENT
	@Override
	public EmployeeSummaryDto listByDepartment(long departmentId) {
		EmployeeSummaryDto employeeSummaryDto = new EmployeeSummaryDto();
		
		Optional<Department> department = departmentRepository.findById(departmentId);
		
		if(department.isPresent()) {
			employeeSummaryDto.setDepartmentId(department.get().getDepartmentId());
			employeeSummaryDto.setDepartmentName(department.get().getDepartmentName());
		}
		
		employeeSummaryDto.setEmployeeDetailList(new ArrayList<>());
		
		
		for(Employee emp : employeeRepository.findByDepartment(departmentId)) {
			EmployeeDetailDto employeeDetailDto = convertToDto(emp);
			employeeSummaryDto.getEmployeeDetailList().add(employeeDetailDto);
			
		}
		
		return employeeSummaryDto;		
	}

	
	
	
	
	//COUNT BY DEPARTMENT
	@Override
	public int countByDepartment(long departmentId) {
		return employeeRepository.countByDepartment(departmentId);
	}
	
	

	
	// convert to Entity 
	private Employee convertToEntity(EmployeeDetailDto employeeDetail) {
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
	
	
	// conver to Dto
	private EmployeeDetailDto convertToDto(Employee employee) {
		EmployeeDetailDto employeeDetail = new EmployeeDetailDto();
		employeeDetail.setEmployeeId(employee.getEmployeeId());
		employeeDetail.setEmployeeName(employee.getEmployeeName());
		employeeDetail.setMonthlySalary(employee.getMonthlySalary());
		
		
		if(employee.getDepartment() != null) {
			employeeDetail.setDepartmentId(employee.getEmployeeId());
			employeeDetail.setDepartmentName(employee.getDepartment().getDepartmentName());
		
		}
		
		
		return employeeDetail;
	}
}







