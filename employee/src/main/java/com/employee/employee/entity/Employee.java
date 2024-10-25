package com.employee.employee.entity;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class Employee {

	    @Id
	    private String employeeId;

	    @NonNull
	    private String firstName;

	    @NonNull
	    private String lastName;

	    @Email
	    private String email;

	    @ElementCollection
	    private List<String> phoneNumbers;

	    @NonNull
	    private LocalDate doj;

	    @NonNull
	    private Double salary;

		public String getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}

		public LocalDate getDoj() {
			return doj;
		}

		public void setDoj(LocalDate doj) {
			this.doj = doj;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

	

}
