package com.ty.pgboot_app.pg_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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
	@NotNull(message="fill valid data")
	private int roomsAvailability;
	@NotNull(message="fill valid data")
	private int roomsCost;
	@NotNull(message="it should not be null")
	private String roomsSharingType;

}
