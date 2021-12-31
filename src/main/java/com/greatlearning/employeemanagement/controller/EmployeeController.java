package com.greatlearning.employeemanagement.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/getList")
	public List<Employee> getAll() {
		return employeeServiceImpl.get();
	}

	@PostMapping("/addEmployee")
	public void addEmployee(String firstName, String lastName, String email) {
		employeeServiceImpl.addEmployee(firstName, lastName, email);
	}

	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int theId) {
		employeeServiceImpl.deleteEmployee(theId);
		return "Deleted employee id - " + theId;
	}

	@PostMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeServiceImpl.updateEmployee(employee);
		return employee;
	}

	@GetMapping("/findById")
	public Optional<Employee> findById(@RequestParam("id") int theId) {
		return employeeServiceImpl.searchById(theId);
	}

	@GetMapping("/findByFirstName")
	public List<Employee> findByFirstName(@RequestParam("firstName") String fname) {
		return employeeServiceImpl.searchByFirstName(fname);
	}

	@GetMapping("/getSortedByName")
	public List<Employee> getSortByName(Direction direction) {
		return employeeServiceImpl.getEmployeeByFirstNameOrder(direction);
	}
}