package com.example.Spring.Practice.JWT_AUTH.Controller;

import com.example.Spring.Practice.JWT_AUTH.Entities.Employee;
import com.example.Spring.Practice.JWT_AUTH.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JWTController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/register")
    public Employee register(@RequestBody Employee user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Employee user) {
        return service.verify(user);
    }

    @GetMapping("/api/employees")
    public List<Employee> getUsers() {
        return service.getAllUsers();
    }
    
}
