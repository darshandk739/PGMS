package com.ty.pgboot_app.pg_app.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.pgboot_app.pg_app.dto.Rooms;
import com.ty.pgboot_app.pg_app.repo.RoomsRepository;

@Repository
public class RoomsDao {
	@Autowired
	private	RoomsRepository roomsRepository;

	public Rooms saveRooms(Rooms rooms) {
		return roomsRepository.save(rooms);
	}
	public Rooms updateRooms(Rooms rooms) {
		return roomsRepository.save(rooms);
	}

	public Rooms getRoomsById(int id) {
		Optional<Rooms> optional = roomsRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteRoomsById(int id) {
		roomsRepository.deleteById(id);
		return "deleted";
	}
}
