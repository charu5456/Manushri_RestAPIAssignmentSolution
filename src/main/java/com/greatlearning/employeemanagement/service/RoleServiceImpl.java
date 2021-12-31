package com.greatlearning.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.repository.RoleRepository;

@Service
public class RoleServiceImpl {

	@Autowired
	RoleRepository roleRepository;

	public void addRole(String name) {
		roleRepository.save(new Role(0, name));
	}
}