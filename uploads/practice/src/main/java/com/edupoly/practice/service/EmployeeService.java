package com.edupoly.practice.service;

import com.edupoly.practice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {




    List<EmployeeDto> getAllEmployees();


    void createEmployee(EmployeeDto employee);

    void deleteEmployeeById(Long id);
}
