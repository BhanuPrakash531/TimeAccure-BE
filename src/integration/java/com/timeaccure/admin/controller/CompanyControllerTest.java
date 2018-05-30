package com.timeaccure.admin.controller;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testCreateCompany() {
		Company company = createTestCompany();
		HttpEntity<Company> entity = new HttpEntity<Company>(company, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/company"), HttpMethod.POST, entity,
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
	}

	@Test
	public void testRetrieveAllCompanies() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/companies"), HttpMethod.GET, entity,
				String.class);
		String expected = "[{\"id\":1,\"name\":\"Unisys\"}]";
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testRetrieveCompanyById() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/company/1"), HttpMethod.GET, entity,
				String.class);
		String expected = "{\"id\":1,\"name\":\"Unisys\"}";
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateCompany() {
		Company company = createTestCompany();
		company.setName("Unisys Update");
		HttpEntity<Company> entity = new HttpEntity<Company>(company, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/company/1"), HttpMethod.PUT, entity,
				String.class);
		String expected = "{\"id\":1,\"name\":\"Unisys Update\"}";
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(200 == response.getStatusCodeValue());
	}
	
	@Test
	public void testUpdateDeleteCompanyById() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/company/1"), HttpMethod.DELETE, entity,
				String.class);
		String expected = null;
		/*try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		assertNull(response.getBody());
		assertTrue(200 == response.getStatusCodeValue());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	/**
	 * @return
	 */
	private Company createTestCompany() {
		Company company = new Company();
		company.setId(1L);
		company.setName("Unisys");
		company.setAddressList(Arrays.asList(createTestAddress()));
		return company;
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

}
