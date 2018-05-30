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

import com.timeaccure.admin.model.EmployeeType;
import com.timeaccure.admin.repository.EmployeeTypeRepository;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class EmployeeTypeController {
	@Autowired
	EmployeeTypeRepository repository;

	@GetMapping(value = "/employeeTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeType> getAll() {
		List<EmployeeType> list = new ArrayList<>();
		Iterable<EmployeeType> employeeType = repository.findAll();

		employeeType.forEach(list::add);
		return list;
	}

	@GetMapping(value = "/employeeType/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeType findByEmployeeTypeId(@PathVariable long id) {
		EmployeeType employeeType = (EmployeeType) repository.findById(id).get(0);
		return employeeType;
	}
	
	@PostMapping(value = "/employeeType")
	public EmployeeType postEmployeeType(@RequestBody EmployeeType employeeType) {
		repository.save(employeeType);
		return employeeType;
	}
	
	@PutMapping(value = "/employeeType")
	public EmployeeType putEmployeeType(@RequestBody EmployeeType employeeType) {
		repository.save(employeeType);
		return employeeType;
	}

	@DeleteMapping(value = "/employeeType/{id}")
	public void deleteEmployeeType(@PathVariable long id) {
		repository.delete(id);
	}
}
