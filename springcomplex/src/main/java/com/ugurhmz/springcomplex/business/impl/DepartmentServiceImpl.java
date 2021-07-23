package com.ugurhmz.springcomplex.business.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugurhmz.springcomplex.business.dto.DepartmentDetailDto;
import com.ugurhmz.springcomplex.business.dto.DepartmentSummaryDto;
import com.ugurhmz.springcomplex.business.dto.EmployeeDetailDto;
import com.ugurhmz.springcomplex.business.service.DepartmentService;
import com.ugurhmz.springcomplex.data.entity.Department;
import com.ugurhmz.springcomplex.data.entity.Employee;
import com.ugurhmz.springcomplex.data.repository.DepartmentRepository;



@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	@Autowired
	private DepartmentRepository departmentRepository;

	
	
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
	
	
}
