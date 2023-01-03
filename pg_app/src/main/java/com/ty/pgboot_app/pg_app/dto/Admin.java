package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotNull
	private String adminName;
	@NotNull
	private String adminUserName;
	@NotNull
	private String adminEmail;
	@NotNull
	private String adminPassword;
	@OneToMany
	private List<PGDetails> pgDetails;
	@OneToMany
	private List<User> users;
	
}
