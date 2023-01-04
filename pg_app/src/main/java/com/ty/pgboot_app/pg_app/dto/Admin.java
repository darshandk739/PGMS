package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotBlank(message = "Please fill the admin name")
	private String adminName;
	@NotBlank(message = "User name can not be blank, Please fill the valid Name")
	private String adminUserName;
	@Email(message = "Please enter the valid email address")
	private String adminEmail;
	@NotBlank(message = "Please enter the Password")
	private String adminPassword;
	@OneToMany
	@JsonIgnore
	private List<PGDetails> pgDetails;
	@OneToMany
	@JsonIgnore
	private List<User> users;

}
