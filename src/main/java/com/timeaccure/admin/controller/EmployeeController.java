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

import com.timeaccure.admin.model.Employee;
import com.timeaccure.admin.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAll() {
		List<Employee> list = new ArrayList<>();
		Iterable<Employee> employee = repository.findAll();

		employee.forEach(list::add);
		return list;
	}

	@GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee findByEmployeeId(@PathVariable long id) {
		Employee employee = (Employee) repository.findById(id).get(0);
		return employee;
	}
	
	@PostMapping(value = "/employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return employee;
	}
	
	@PutMapping(value = "/employee")
	public Employee putEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return employee;
	}

	@GetMapping(value = "/findempbylastname/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByLastName(@PathVariable String lastName) {
		List<Employee> employee = repository.findByLastName(lastName);
		return employee;
	}

	@DeleteMapping(value = "/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		repository.delete(id);
	}

	
}

