package com.ugurhmz.springcomplex.business.dto;

import java.util.List;

public class DepartmentSummaryDto {

	
	private List<DepartmentDetailDto> departmentDetailList;

	
	public List<DepartmentDetailDto> getDepartmentDetailList() {
		return departmentDetailList;
	}

	public void setDepartmentDetailList(List<DepartmentDetailDto> departmentDetailList) {
		this.departmentDetailList = departmentDetailList;
	}
}
