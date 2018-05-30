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

import com.timeaccure.admin.model.Company;
import com.timeaccure.admin.repository.CompanyRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CompanyController {

	@Autowired
	CompanyRepository repository;

	@GetMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> getAll() {
		List<Company> list = new ArrayList<>();
		Iterable<Company> company = repository.findAll();

		company.forEach(list::add);
		return list;
	}

	@GetMapping(value = "/company/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Company findByCompanyId(@PathVariable long id) {
		Company company = (Company) repository.findById(id).get(0);
		return company;
	}
	
	@PostMapping(value = "/company")
	public Company postCompany(@RequestBody Company company) {
		repository.save(company);
		return company;
	}
	
	@PutMapping(value = "/company/{id}")
	public Company putCompany(@PathVariable long id, @RequestBody Company company) {
		repository.save(company);
		return company;
	}

	@DeleteMapping(value = "/company/{id}")
	public void deleteCompany(@PathVariable long id) {
		repository.delete(id);
	}
}
