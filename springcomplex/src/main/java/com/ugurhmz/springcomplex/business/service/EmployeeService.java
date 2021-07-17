package com.ugurhmz.springcomplex.business.service;

import com.ugurhmz.springcomplex.business.dto.EmployeeDetail;
import com.ugurhmz.springcomplex.business.dto.EmployeeSummary;




public interface EmployeeService {

	
	public void create(EmployeeDetail employeeDetail);
	public void update(EmployeeDetail employeeDetail);
	public void delete(long employeeId);
	
	public EmployeeDetail findById(long employeeId);
	public EmployeeSummary listDetail();
	public EmployeeSummary listByDepartment(long departmentId); 
	
	public int countByDepartment(long departmentId);
	
}
