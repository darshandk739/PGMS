package com.ty.pgboot_app.pg_app.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.pgboot_app.pg_app.dao.RoomsDao;
import com.ty.pgboot_app.pg_app.dto.Rooms;
import com.ty.pgboot_app.pg_app.exception.NoSuchIdFoundException;
import com.ty.pgboot_app.pg_app.exception.UnableToDeleteException;
import com.ty.pgboot_app.pg_app.exception.UnableToUpdateException;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class RoomsService {
	@Autowired
	private RoomsDao roomsDao;
	//log4j
	private static final Logger logger = Logger.getLogger(RoomsService.class);

	public ResponseEntity<ResponseStructure<Rooms>> saveRooms(Rooms rooms) {

		ResponseStructure<Rooms> responseStructure = new ResponseStructure<Rooms>();
		ResponseEntity<ResponseStructure<Rooms>> responseEntity = new ResponseEntity<ResponseStructure<Rooms>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(roomsDao.saveRooms(rooms));
		logger.info("rooms added to database");
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Rooms>> updateRooms(Rooms rooms, String id) {

		ResponseStructure<Rooms> responseStructure = new ResponseStructure<Rooms>();
		ResponseEntity<ResponseStructure<Rooms>> responseEntity = new ResponseEntity<ResponseStructure<Rooms>>(
				responseStructure, HttpStatus.OK);
		Optional<Rooms> rooms2 = roomsDao.getRoomsById(id);
		if (rooms2 != null) {
			rooms.setRoomsId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Rooms Updated");
			responseStructure.setData(roomsDao.updateRooms(rooms));
			logger.debug("rooms updated to database");
			return responseEntity;
		}
		logger.warn("no such id found in database to update");
		throw new UnableToUpdateException("no such id found in database to update");
	}

	public ResponseEntity<ResponseStructure<Rooms>> getRoomsById(String id) {
		ResponseStructure<Rooms> responseStructure = new ResponseStructure<Rooms>();
		ResponseEntity<ResponseStructure<Rooms>> responseEntity = new ResponseEntity<ResponseStructure<Rooms>>(
				responseStructure, HttpStatus.OK);
		Optional<Rooms> optional = roomsDao.getRoomsById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Get Rooms");
			responseStructure.setData(optional.get());
			logger.debug("rooms found");
			return responseEntity;
		}
		logger.warn("no such id found in database");
		throw new NoSuchIdFoundException("no such id found in database");
	}

	public ResponseEntity<ResponseStructure<Rooms>> deleteRoomsById(String id) {
		ResponseStructure<Rooms> responseStructure = new ResponseStructure<Rooms>();
		ResponseEntity<ResponseStructure<Rooms>> responseEntity = new ResponseEntity<ResponseStructure<Rooms>>(
				responseStructure, HttpStatus.OK);
		Optional<Rooms> optional = roomsDao.getRoomsById(id);
		if (optional.isPresent()) {
			roomsDao.deleteRooms(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Rooms Deleted");
			responseStructure.setData(optional.get());
			logger.debug("rooms deleted");
			return responseEntity;
		}
		logger.warn("no such id found in database to delete");
		throw new UnableToDeleteException("no such id found in database to delete");
	}

	public ResponseEntity<ResponseStructure<List<Rooms>>> getAllRooms() {
		ResponseStructure<List<Rooms>> responseStructure = new ResponseStructure<List<Rooms>>();
		ResponseEntity<ResponseStructure<List<Rooms>>> responseEntity = new ResponseEntity<ResponseStructure<List<Rooms>>>(
				responseStructure, HttpStatus.OK);
		List<Rooms> optional = roomsDao.getAllRooms();
		if (optional != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Get Rooms");
			responseStructure.setData(optional);
			logger.debug("rooms found");
			return responseEntity;
		}
		logger.warn("no such id found in database");
		throw new NoSuchIdFoundException("no such id found in database");
	}
}
