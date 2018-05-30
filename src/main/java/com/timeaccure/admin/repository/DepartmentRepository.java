package com.timeaccure.admin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.timeaccure.admin.model.Department;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
	List<Department> findById(long id);
}