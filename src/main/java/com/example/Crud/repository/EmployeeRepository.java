package com.example.Crud.repository;

import com.example.Crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);
}
