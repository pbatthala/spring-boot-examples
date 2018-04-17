package com.example.spring.boot.dto;

import javax.validation.constraints.NotNull;

import com.example.spring.boot.model.Role;
import org.hibernate.validator.constraints.NotEmpty;

public class UserCreateForm {

	@NotEmpty
	private String username = "";

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String password = "";

	@NotEmpty
	private String passwordRepeated = "";

	@NotNull
	private Role role = Role.USER;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}