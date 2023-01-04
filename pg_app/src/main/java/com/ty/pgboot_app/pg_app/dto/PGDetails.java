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
<<<<<<< HEAD

import com.fasterxml.jackson.annotation.JsonIgnore;
=======
import javax.validation.constraints.Size;
>>>>>>> a669515d8d2fe77927e6631a272822f880b52d74

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PGDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pgId;
<<<<<<< HEAD
	@NotNull(message="Name should not be null, please the enter the name")
	private String pgName;
	@NotBlank(message="Please enter a valid PG owner name")
	private String pgOwnername;
	@NotBlank(message="Please enter a valid PG location")
	private String pgLocation;
	@NotBlank(message="Please enter a valid PG Phone number")
=======
	@NotNull(message = "Please fill the name")
	private String pgName;
	@NotBlank(message = "Please fill the owner name")
	private String pgOwnername;
	@NotBlank(message = "Please fill the location")
	private String pgLocation;
	@NotBlank(message = "Please fill the Phone number")
	@Size(min = 999999999, max = (int) 9999999999l, message = "Phone Number can not be less than 10")
>>>>>>> a669515d8d2fe77927e6631a272822f880b52d74
	private long pgPhone;
	@NotBlank(message="Please enter a valid status")
	private String status;
	@NotBlank(message="Please enter valid PG facilities")
	private String pgFacilities;
	@NotBlank(message="Please enter valid PG Foods")
	private String pgFoods;   


	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
	private List<Rooms> rooms;



}
