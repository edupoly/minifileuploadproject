package com.edupoly.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edupoly.practice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
