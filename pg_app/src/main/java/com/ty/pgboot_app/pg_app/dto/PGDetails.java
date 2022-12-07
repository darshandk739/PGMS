package com.ty.pgboot_app.pg_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
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

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public String getPgName() {
		return pgName;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

	public String getPgOwnername() {
		return pgOwnername;
	}

	public void setPgOwnername(String pgOwnername) {
		this.pgOwnername = pgOwnername;
	}

	public String getPgLocation() {
		return pgLocation;
	}

	public void setPgLocation(String pgLocation) {
		this.pgLocation = pgLocation;
	}

	public long getPgPhone() {
		return pgPhone;
	}

	public void setPgPhone(long pgPhone) {
		this.pgPhone = pgPhone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPgFacilities() {
		return PgFacilities;
	}

	public void setPgFacilities(String pgFacilities) {
		PgFacilities = pgFacilities;
	}

	public String getPgFoods() {
		return pgFoods;
	}

	public void setPgFoods(String pgFoods) {
		this.pgFoods = pgFoods;
	}

	public List<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}

}
