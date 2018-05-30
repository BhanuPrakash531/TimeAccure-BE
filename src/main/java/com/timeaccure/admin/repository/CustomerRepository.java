package com.timeaccure.admin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.timeaccure.admin.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
	List<Customer> findById(long id);
}