package com.greatlearning.employeemanagement.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.greatlearning.employeemanagement.service.MyUserDetailsService;

@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/employee/addEmployee", "/setUser", "/roles/add")
				.hasRole("ADMIN")
				.antMatchers("/employee/getList", "/employee/deleteEmployee", "/employee/updateEmployee",
						"/employee/findById", "/employee/findByFirstName", "/employee/getSortedByName")
				.hasAnyRole("ADMIN", "USER").and().formLogin();
	}
}