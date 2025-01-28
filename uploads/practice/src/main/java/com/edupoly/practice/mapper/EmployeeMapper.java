package com.edupoly.practice.mapper;

import com.edupoly.practice.dto.EmployeeDto;
import com.edupoly.practice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee emp){
        EmployeeDto employeeDto=new EmployeeDto(
                emp.getId(),
                emp.getName(),
                emp.getEmail()
        );
        return  employeeDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail()
        );
        return employee;
    }
}
