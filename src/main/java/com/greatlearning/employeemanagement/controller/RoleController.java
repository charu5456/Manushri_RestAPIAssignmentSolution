package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.service.RoleServiceImpl;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleServiceImpl roleServiceImpl;

	@PostMapping("/add")
	public String addRole(@RequestParam("name") String name) {
		roleServiceImpl.addRole(name);
		return "New Role Added";
	}
}