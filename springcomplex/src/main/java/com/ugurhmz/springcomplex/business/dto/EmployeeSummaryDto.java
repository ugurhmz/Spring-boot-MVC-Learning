package com.ugurhmz.springcomplex.business.dto;

import java.util.List;

public class EmployeeSummaryDto {

	private int employeeCount;
	private long departmentId;
	private String 	departmentName;
 
	private List<EmployeeDetailDto> employeeDetailList;

	
	
	// GETTER & SETTER
	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public List<EmployeeDetailDto> getEmployeeDetailList() {
		return employeeDetailList;
	}

	public void setEmployeeDetailList(List<EmployeeDetailDto> employeeDetailList) {
		this.employeeDetailList = employeeDetailList;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
