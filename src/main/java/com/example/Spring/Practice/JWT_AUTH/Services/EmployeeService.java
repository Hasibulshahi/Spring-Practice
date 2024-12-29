package com.example.Spring.Practice.JWT_AUTH.Services;

import com.example.Spring.Practice.JWT_AUTH.Entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllUsers();
    public Employee register(Employee user);
    public String verify(Employee user);
}
