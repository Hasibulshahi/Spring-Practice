package com.example.Spring.Practice.JWT_AUTH.Repositories;

import com.example.Spring.Practice.JWT_AUTH.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Employee, Integer> {
    Employee findByUserName(String username);
}
