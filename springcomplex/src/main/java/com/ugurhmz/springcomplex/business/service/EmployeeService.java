package com.ugurhmz.springcomplex.business.service;

import com.ugurhmz.springcomplex.business.dto.EmployeeDetailDto;
import com.ugurhmz.springcomplex.business.dto.EmployeeSummaryDto;




public interface EmployeeService {

	
	public void create(EmployeeDetailDto employeeDetail);
	public void update(EmployeeDetailDto employeeDetail);
	public void delete(long employeeId);
	
	public EmployeeDetailDto findById(long employeeId);
	public EmployeeSummaryDto listDetail();
	public EmployeeSummaryDto listByDepartment(long departmentId); 
	
	public int countByDepartment(long departmentId);
	
}
