package com.employee.employee.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.entity.Employee;
import com.employee.employee.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeesService;
	
	
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		
		System.out.println("Hello");
		try {
		
			Employee savedEmployee = employeesService.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
    @GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<?> getTaxDeductions(@PathVariable String employeeId) {
        try {
            Map<String, Object> taxDetails = employeesService.calculateTax(employeeId);
            return ResponseEntity.ok(taxDetails);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
