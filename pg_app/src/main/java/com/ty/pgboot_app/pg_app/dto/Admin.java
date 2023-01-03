package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.pgboot_app.pg_app.util.AesEncryption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotBlank
	private String adminName;
	private String adminUserName;
	@NotNull
	@Convert(converter = AesEncryption.class)
	private String adminEmail;
	@NotNull
	@Convert(converter = AesEncryption.class)
	private String adminPassword;
	@OneToMany(cascade = CascadeType.ALL)
	private List<PGDetails> pgDetails;
	@OneToMany
	@JsonIgnore
	private List<User> users;
	
}
