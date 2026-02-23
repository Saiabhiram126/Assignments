package com.example.employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<String> getEmployeesWithHighSalary(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list cannot be null");
        }

        return employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }
}