package com.example.Spring.Practice.JWT_AUTH.Services;

import com.example.Spring.Practice.JWT_AUTH.Entities.Employee;
import com.example.Spring.Practice.JWT_AUTH.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public Employee register(Employee user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    @Override
    public String verify(Employee user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName())  ;
        } else {
            return "fail";
        }
    }

    @Override
    public List<Employee> getAllUsers() {
        return repo.findAll();
    }
}
