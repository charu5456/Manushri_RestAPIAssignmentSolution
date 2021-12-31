package com.greatlearning.employeemanagement;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.repository.RoleRepository;
import com.greatlearning.employeemanagement.repository.UserRepository;

@SpringBootApplication
public class EmployeeManagementApplication {

	@Autowired
	RoleRepository roleRepsitory;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	@Bean
	public void createEntries() {
		Role r1 = new Role(1, "ROLE_ADMIN");
		roleRepsitory.save(r1);

		User u1 = new User();
		u1.setUsername("Admin");
		u1.setPassword(("Admin"));
		u1.setRoles(Arrays.asList(r1));
		userRepository.save(u1);
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
