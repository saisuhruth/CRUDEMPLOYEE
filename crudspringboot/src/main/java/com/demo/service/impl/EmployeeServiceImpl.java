package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent())
		{
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee","ID", id);
		}
		
		//Using lambda expression
		//return employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee","ID", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","ID", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public Employee deleteEmplyeeById(long id) {
		
	 employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","ID", id));
	
	 employeeRepository.deleteById(id);
		
		return null;
		
	}

	
	
	
}
