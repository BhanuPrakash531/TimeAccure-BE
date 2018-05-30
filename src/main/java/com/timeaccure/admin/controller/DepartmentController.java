package com.timeaccure.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timeaccure.admin.model.Department;
import com.timeaccure.admin.repository.DepartmentRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository repository;

	@GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Department> getAll() {
		List<Department> list = new ArrayList<>();
		Iterable<Department> department = repository.findAll();

		department.forEach(list::add);
		return list;
	}

	@GetMapping(value = "/department/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Department findByCustomerId(@PathVariable long id) {
		Department department = (Department) repository.findById(id).get(0);
		return department;
	}

	@PostMapping(value = "/department")
	public Department postCustomer(@RequestBody Department department) {
		repository.save(department);
		return department;
	}

	@PutMapping(value = "/department")
	public Department putCustomer(@RequestBody Department department) {
		repository.save(department);
		return department;
	}

	@DeleteMapping(value = "/department/{id}")
	public void deleteCustomer(@PathVariable long id) {
		repository.delete(id);
	}

}
