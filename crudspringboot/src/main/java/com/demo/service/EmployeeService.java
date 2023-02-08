package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee,long id);
	
	Employee deleteEmplyeeById(long id);
	
	
}
