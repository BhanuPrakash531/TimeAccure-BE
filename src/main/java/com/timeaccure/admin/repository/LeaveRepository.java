package com.timeaccure.admin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.timeaccure.admin.model.Leave;

public interface LeaveRepository extends PagingAndSortingRepository<Leave, Long> {
	List<Leave> findById(long id);
}
