package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PGDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pgId;
	@NotNull(message = "Please fill the name")
	private String pgName;
	@NotBlank(message = "Please fill the owner name")
	private String pgOwnername;
	@NotBlank(message = "Please fill the location")
	private String pgLocation;
	@NotBlank(message = "Please fill the Phone number")
	@Size(min = 999999999, max = (int) 9999999999l, message = "Phone Number can not be less than 10")
	private long pgPhone;
	private String status;
	private String pgFacilities;
	private String pgFoods;


	@OneToMany(cascade = CascadeType.ALL)

	private List<Rooms> rooms;



}
