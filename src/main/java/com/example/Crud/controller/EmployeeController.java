package com.example.Crud.controller;

import com.example.Crud.exception.ResourceNotFoundException;
import com.example.Crud.model.Employee;
import com.example.Crud.repository.EmployeeRepository;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/getall")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping("/add")
    public Employee createEmployee (@RequestBody Employee employee){
        return employeeRepository.save(employee);

    }
    @GetMapping("byid/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id). orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" +id));
        return ResponseEntity.ok(employee);

    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
        Employee employee = employeeRepository.findByName(name);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDEtails) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"+id));
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        return employeeRepository.findById(id).map(employee -> {
            employeeRepository.delete(employee);
            return ResponseEntity.ok("Employee with id " + id + " deleted successfully");
        }).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
    }
}

