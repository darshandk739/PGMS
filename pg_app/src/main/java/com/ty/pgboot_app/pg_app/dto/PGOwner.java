package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PGOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pgId;
	@NotBlank(message="Please enter a valid PG name")
	private String pgName;
	@NotBlank(message="Please enter a valid PG owner name")
	private String pgOwnername;
	@NotBlank(message="Please enter a valid PG location")
	private String pgLocation;
	@NotBlank(message="Please enter a valid PG Phone number")
	private long pgPhone;
	@NotBlank(message="Please enter a valid status")
	private String status;
	@NotBlank(message="Please  enter valid PG facilities")
	private String pgFacilities;
	@NotBlank(message="Please enter valid PG Foods")
	private String pgFoods;   


	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
	private List<Rooms> rooms;



}
