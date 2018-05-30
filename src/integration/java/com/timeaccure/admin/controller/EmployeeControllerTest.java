package com.timeaccure.admin.controller;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;

import org.json.JSONException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeaccure.Application;
import com.timeaccure.admin.model.Address;
import com.timeaccure.admin.model.Company;
import com.timeaccure.admin.model.Department;
import com.timeaccure.admin.model.Employee;;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testPostEmployee() {

		Employee employee = createTestEmployee();
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/employee"), HttpMethod.POST, entity,
				String.class);
		String expected = "{\"id\":1,\"name\":\"Unisys\"}";
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(200 == response.getStatusCodeValue());
	
		
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByEmployeeId() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	/**
	 * @return
	 */
	private Employee createTestEmployee() {
		Employee employee = new Employee();
		employee.setAddress(Arrays.asList(createTestAddress()));
		employee.setCompany(createTestCompany());
		employee.setDateOfBirth(new Date());
		employee.setDateOfJoining(new Date());
		employee.setDepartment(createTestDepartment());
		employee.setEmailAddress("John.Carter@gmail.com");
		employee.setFirstName("John");employee.setLastName("Carter");
		employee.setGender("Male");employee.setUsername("JohnCarter");
		employee.setUsername(employee.getUsername());
		return employee;
	}

	/**
	 * 
	 */
	private Department createTestDepartment() {
		Department dept = new Department();
		dept.setName("Dev");dept.setCode("DEV");dept.setComments("Dev dept");
		dept.setEnabled(true);
		return dept;
	}

	/**
	 * @return
	 */
	private Address createTestAddress() {
		Address address = new Address();
		address.setAddress1("Street 1");
		address.setAddress2("Street 2");
		address.setAddress3("Street 3");
		address.setAddressType("Residence");
		address.setCity("Sydney");
		address.setCountry("Australia");
		address.setInstructions("Instructions 111");
		address.setStateProvince("SY");
		address.setPostalCode("123456");
		return address;
	}
	/**
	 * @return
	 */
	private Company createTestCompany() {
		Address address = createTestAddress();
		Company company = new Company();
		company.setId(1L);
		company.setName("Unisys");
		company.setAddressList(Arrays.asList(address));
		return company;
	}

}
