package com.greatlearning.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username from req " + username);
		User user = repo.getUserByUsername(username);
		List <Role> roles = user.getRoles();
		List <SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		org.springframework.security.core.userdetails.User secureUser = new org.springframework.security.core.userdetails.User(
				user.getUsername(), (user.getPassword()),authorities);
		return secureUser;
	}
}