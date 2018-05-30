package com.timeaccure.admin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.timeaccure.admin.model.Company;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
	List<Company> findByName(String lastName);
	List<Company> findById(long id);
}
