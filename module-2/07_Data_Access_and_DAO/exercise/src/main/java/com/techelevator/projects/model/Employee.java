package com.techelevator.projects.model;

import java.time.LocalDate;

public class Employee {
	private int employeeId;
	private int departmentId;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private LocalDate hireDate;

	public Employee() {}

	public Employee(int employeeId, int departmentId, String firstName, String lastName,
					LocalDate birthDate, LocalDate hireDate) {
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	}

	public int getId() {
		return employeeId;
	}
	public void setId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}
}
