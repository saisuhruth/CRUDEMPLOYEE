package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
		@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService){
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee REST API
	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	// build get employee REST API
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getEmpId/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	//build update employee REST API
	@PutMapping("/updateEmpl/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long Id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,Id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteempById(@PathVariable("id") long Id)
	{
		
		employeeService.deleteEmplyeeById(Id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		
	}
	
}

