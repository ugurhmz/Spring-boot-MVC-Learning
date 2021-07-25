package com.ugurhmz.springcomplex.business.service;

import com.ugurhmz.springcomplex.business.dto.DepartmentSummaryDto;
import com.ugurhmz.springcomplex.data.entity.Department;




public interface DepartmentService {

	public DepartmentSummaryDto list();
	
	public long generateDepartment(String departmentName);
	
	public void generateEmployees(Department department);
	
}
