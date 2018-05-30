package com.timeaccure.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee implements Serializable {
	public static final int STRING_LENGTH = 256;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company = new Company();

	@Column(length = STRING_LENGTH)
	private String firstName;

	@Column(length = STRING_LENGTH)
	private String lastName;

	@Column(length = STRING_LENGTH)
	private String username;

	@Column(length = STRING_LENGTH)
	private String password;

	@Column(length = STRING_LENGTH)
	private String employeeID;

	@Column(length = STRING_LENGTH)
	private String emailAddress;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;

	@Temporal(TemporalType.DATE)
	private Date dateOfEnding;

	@Column(length = STRING_LENGTH)
	private String gender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;
	// private EmployeeType group;
	/*
	 * private Project project;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfEnding() {
		return dateOfEnding;
	}

	public void setDateOfEnding(Date dateOfEnding) {
		this.dateOfEnding = dateOfEnding;
	}
	/*
	 * public EmployeeType getGroup() { return group; } public void
	 * setGroup(EmployeeType group) { this.group = group; } public Department
	 * getDepartment() { return department; } public void setDepartment(Department
	 * department) { this.department = department; } public Project getProject() {
	 * return project; } public void setProject(Project project) { this.project =
	 * project; }
	 */

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "employeeGen") protected int id;
	 */
	// @JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY/* , mappedBy = "employee" */)
	@JoinColumn(name = "employee_id")
	private List<Address> address = new ArrayList<>();

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	// @JoinColumn(name = "employee_id")
	private List<Leave> leaveArrayList = new ArrayList<>();

	public List<Leave> getLeaveArrayList() {
		return leaveArrayList;
	}

	public void setLeaveArrayList(List<Leave> leaveArrayList) {
		this.leaveArrayList = leaveArrayList;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_type_id", nullable = false)
	private EmployeeType employeeType = new EmployeeType();

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	
}
