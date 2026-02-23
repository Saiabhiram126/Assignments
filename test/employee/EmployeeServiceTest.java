package com.example.employee;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private final EmployeeService service = new EmployeeService();

    @Test
    void shouldFilterEmployeesWithSalaryGreaterThan50000() {
        List<Employee> employees = Arrays.asList(
                new Employee("Abhi", 60000),
                new Employee("John", 40000),
                new Employee("Sara", 70000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertEquals(2, result.size());
        assertTrue(result.contains("Abhi"));
        assertTrue(result.contains("Sara"));
    }

    @Test
    void shouldExcludeEmployeesWithSalaryLessOrEqual50000() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Mike", 30000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnOnlyNamesNotObjects() {
        List<Employee> employees = Arrays.asList(
                new Employee("Abhi", 60000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertEquals(String.class, result.get(0).getClass());
    }

    @Test
    void shouldHandleEmptyEmployeeList() {
        List<String> result =
                service.getEmployeesWithHighSalary(Collections.emptyList());

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnAllWhenAllMeetCondition() {
        List<Employee> employees = Arrays.asList(
                new Employee("A", 80000),
                new Employee("B", 90000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertEquals(2, result.size());
    }
}
