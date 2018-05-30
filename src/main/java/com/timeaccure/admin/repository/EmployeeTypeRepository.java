package com.timeaccure.admin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.timeaccure.admin.model.EmployeeType;

public interface EmployeeTypeRepository extends PagingAndSortingRepository<EmployeeType, Long> {
	List<EmployeeType> findById(long id);
}