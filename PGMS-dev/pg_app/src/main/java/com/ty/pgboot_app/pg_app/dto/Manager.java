package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Manager {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int managerId;
		@NotBlank(message = "Please fill the Name")
		private String managerName;
		@Email(message = "Please fill the proper email id")
		private String managerEmail;
		@NotBlank(message = "Please fill the password")
		private String managerPassword;
		@OneToMany
		private List<Admin> admins;
}
