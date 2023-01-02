package com.ty.pgboot_app.pg_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rooms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomsId;
	@NotNull
	private int roomsAvailability;
	@NotNull
	private int roomsCost;
	@NotNull
	private String roomsSharingType;

}
