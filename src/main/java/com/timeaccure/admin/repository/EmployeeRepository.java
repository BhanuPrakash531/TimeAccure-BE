package com.timeaccure.admin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.timeaccure.admin.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	List<Employee> findByLastName(String lastName);
	List<Employee> findById(long id);
	
}
