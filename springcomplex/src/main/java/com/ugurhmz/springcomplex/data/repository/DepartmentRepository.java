package com.ugurhmz.springcomplex.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ugurhmz.springcomplex.data.entity.Department;




public interface DepartmentRepository  extends CrudRepository<Department, Long>{

}
