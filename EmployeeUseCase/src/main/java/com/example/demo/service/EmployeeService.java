package com.example.demo.service;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	 private Map<Integer, Employee> employeeMap = new HashMap<>();

	    // Add Employee
	    public Employee addEmployee(int id, String name, String role) {
	        String designation = getDesignationBasedOnRole(role);  // Automatically assign designation based on role
	        Employee employee = new Employee(id, name, designation, role);
	        employeeMap.put(id, employee);
	        return employee;
	    }

	    // Get Employee by ID
	    public Employee getEmployee(int id) {
	        return employeeMap.get(id);
	    }

	    // Delete Employee by ID
	    public String deleteEmployee(int id) {
	        if (employeeMap.containsKey(id)) {
	            employeeMap.remove(id);
	            return "Employee with ID " + id + " has been deleted.";
	        }
	        return "Employee not found.";
	    }

	    // Update Employee
	    public Employee updateEmployee(int id, String name, String role) {
	        if (employeeMap.containsKey(id)) {
	            Employee employee = employeeMap.get(id);
	            employee.setName(name);
	            employee.setRole(role);
	            employee.setDesignation(getDesignationBasedOnRole(role));  // Update designation based on role
	            return employee;
	        }
	        return null;  // Employee not found
	    }

	    // Get all Employees
	    public Map<Integer, Employee> getAllEmployees() {
	        return employeeMap;
	    }

	    // Helper method to determine the designation based on role
	    private String getDesignationBasedOnRole(String role) {
	        switch (role.toLowerCase()) {
	            case "developer":
	                return "Software Developer";
	            case "tester":
	                return "QA Tester";
	            case "architect":
	                return "System Architect";
	            default:
	                return "Unknown Role";  // Default designation
	        }
	    }
    

}
