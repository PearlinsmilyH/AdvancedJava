package com.example.namingconvention.controller;                                  // package name should be in lowercase

import com.example.namingconvention.model.Employee;
import com.example.namingconvention.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/users")                                                     /*Use forward slashes. ...
                                                                                   Separate words with hyphens. ...
                                                                                   Use lowercase letters. ...
                                                                                    Avoid special characters. ...
                                                                                     */
public class EmployeeController {                                                   //class name should started with uppercase
    @Autowired
    private EmployeeRepo employeeRepository;
    @GetMapping                                               //get all
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping                                            //add
    public Employee createEmployee (@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping("/{id}")                                   //get employee by id
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        return ResponseEntity.ok(employee);

    }
    }

