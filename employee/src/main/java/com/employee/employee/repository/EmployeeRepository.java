package com.employee.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    boolean existsByEmployeeId(String employeeId);

	Optional<Employee> findByEmployeeId(String employeeId);
}
