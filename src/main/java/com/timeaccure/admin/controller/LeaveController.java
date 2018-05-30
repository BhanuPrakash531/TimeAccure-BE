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

import com.timeaccure.admin.model.Leave;
import com.timeaccure.admin.repository.LeaveRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class LeaveController {


	@Autowired
	LeaveRepository repository;

	@GetMapping(value = "/leaves", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Leave> getAll() {
		List<Leave> list = new ArrayList<>();
		Iterable<Leave> leave = repository.findAll();

		leave.forEach(list::add);
		return list;
	}

	@GetMapping(value = "/leave/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Leave findByCustomerId(@PathVariable long id) {
		Leave leave = (Leave) repository.findById(id).get(0);
		return leave;
	}
	
	@PostMapping(value = "/leave")
	public Leave postCustomer(@RequestBody Leave leave) {
		repository.save(leave);
		return leave;
	}
	
	@PutMapping(value = "/leave")
	public Leave putCustomer(@RequestBody Leave leave) {
		repository.save(leave);
		return leave;
	}

	@DeleteMapping(value = "/leave/{id}")
	public void deleteCustomer(@PathVariable long id) {
		repository.delete(id);
	}

}
