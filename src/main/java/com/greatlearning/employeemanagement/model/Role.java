package com.greatlearning.employeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	public Role(int i, String name) {
		super();
		String Role_name = "ROLE_" + name.toUpperCase();
		this.name = Role_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "ROLE_" + name.toUpperCase();
	}
}