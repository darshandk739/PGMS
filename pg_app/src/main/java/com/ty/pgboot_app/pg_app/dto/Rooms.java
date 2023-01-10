package com.ty.pgboot_app.pg_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rooms {
	@Id
	@GenericGenerator(name = "id_generations", strategy = "com.ty.pgboot_app.pg_app.customgeneration.CustomRoomsId")
	@GeneratedValue(generator = "id_generations")
	private String roomsId;
	@NotNull(message="fill valid data")
	private int roomsAvailability;
	@NotNull(message="fill valid data")
	private int roomsCost;
	@NotNull(message="it should not be null")
	private String roomsSharingType;

}
