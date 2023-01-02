package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.pgboot_app.pg_app.util.AesEncryption;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	private String username;
	private String userOccupation;
	@NotNull
	//@Convert(converter = AesEncryption.class)
	private long userPhone;
	private String userAddress;
	private int userAge;
	@NotNull
	private String userProofId;
	@OneToMany
	@JsonIgnore
	private List<PGDetails> pgDetails;
}
