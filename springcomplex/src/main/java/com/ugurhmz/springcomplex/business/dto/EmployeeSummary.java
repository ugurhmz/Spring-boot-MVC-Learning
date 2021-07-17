package com.ugurhmz.springcomplex.business.dto;

import java.util.List;

public class EmployeeSummary {

	private int employeeCount;
	private String 	departmentName;
	private List<EmployeeDetail> employeeDetailList;

	
	
	
	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public List<EmployeeDetail> getEmployeeDetailList() {
		return employeeDetailList;
	}

	public void setEmployeeDetailList(List<EmployeeDetail> employeeDetailList) {
		this.employeeDetailList = employeeDetailList;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
