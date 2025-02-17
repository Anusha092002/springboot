package com.example.demo.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees") 
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;

    // Add Employee (POST)
	@RequestMapping("/add")
    public Employee addEmployee( @RequestParam int id, @RequestParam String name, @RequestParam String role) {
        return employeeService.addEmployee(id, name, role);
    }

    // Get Employee by ID (GET)
	@GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    // Delete Employee by ID (DELETE)
	@DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    // Update Employee (PUT)
	@RequestMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestParam String name, @RequestParam String role) {
        return employeeService.updateEmployee(id, name, role);
    }

    // Get all Employees (GET)
	@RequestMapping("/all")
    public Map<Integer, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
