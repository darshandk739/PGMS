package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PGDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pgId;
	private String pgName;
	private String pgOwnername;
	private String pgLocation;
	private long pgPhone;
	private String status;
	private String PgFacilities;
	private String pgFoods;

	@OneToMany
	private List<Rooms> rooms;



}
