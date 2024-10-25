package com.employee.employee.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.entity.Employee;
import com.employee.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	public Employee saveEmployee(Employee employee) {
		
		  if (employeeRepo.existsByEmployeeId(employee.getEmployeeId())) {
	            throw new IllegalArgumentException("Employee ID must be unique.");
	        }
	        return employeeRepo.save(employee);
	}

	public Map<String, Object> calculateTax(String employeeId) {
		System.out.println("::::::" + employeeId);
        Employee employee = employeeRepo.findById(employeeId)
            .orElseThrow(() -> new NoSuchElementException("Employee not found"));

  
        double yearlySalary = employee.getSalary() * monthsSinceJoining(employee.getDoj());

        double taxAmount = calculateTaxAmount(yearlySalary);
        double cessAmount = yearlySalary > 2500000 ? (yearlySalary - 2500000) * 0.02 : 0;

        Map<String, Object> response = new HashMap<>();
        response.put("employeeId", employee.getEmployeeId());
        response.put("firstName", employee.getFirstName());
        response.put("lastName", employee.getLastName());
        response.put("yearlySalary", yearlySalary);
        response.put("taxAmount", taxAmount);
        response.put("cessAmount", cessAmount);
        return response;
    }

    private double calculateTaxAmount(double yearlySalary) {
        if (yearlySalary <= 250000) return 0;
        else if (yearlySalary <= 500000) return (yearlySalary - 250000) * 0.05;
        else if (yearlySalary <= 1000000) return 250000 * 0.05 + (yearlySalary - 500000) * 0.1;
        else return 250000 * 0.05 + 500000 * 0.1 + (yearlySalary - 1000000) * 0.2;
    }

    private int monthsSinceJoining(LocalDate doj) {
        return 12;
    }


}
