package com.greatlearning.employeemanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository userRepository;

	public User setUser(User user) {
		return userRepository.save(user);
	}
}