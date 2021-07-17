package com.ugurhmz.springcomplex.business.impl;


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
		employee.setEmployeeId(employee.getEmployeeId());
		
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
	public EmployeeDetailDto findById(long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			EmployeeDetailDto employeeDetail = convertToDto(employee.get());
			return employeeDetail;
		}	
		return null;	
	}
	

	//LIST DETAIL
	@Override
	public EmployeeSummaryDto listDetail() {
		
		return null;
	}

	
	//LIST BY DEPARTMENT
	@Override
	public EmployeeSummaryDto listByDepartment(long departmentId) {
		
		return null;
	}

	//COUNT BY DEPARTMENT
	@Override
	public int countByDepartment(long departmentId) {
		
		return 0;
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







