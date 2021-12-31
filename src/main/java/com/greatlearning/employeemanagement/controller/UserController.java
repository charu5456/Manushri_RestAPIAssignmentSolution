package com.greatlearning.employeemanagement.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/user")
	public @ResponseBody String getLoggedInUser(Principal principal) {
		return principal.getName();
	}

	@GetMapping("/")
	public String getHomePage() {
		return "redirect:/employee/getList";
	}

	@PostMapping("/setUser")
	@ResponseBody
	public User setUser(@RequestBody User user) {
		return userServiceImpl.setUser(user);
	}
}