package com.ty.pgboot_app.pg_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.RoomsDao;
import com.ty.pgboot_app.pg_app.dto.Rooms;
import com.ty.pgboot_app.pg_app.exception.NoSuchIdFoundException;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class RoomsService {
	@Autowired
	
	private RoomsDao roomsDao;
	
	public ResponseEntity<ResponseStructure<Rooms>> saveRooms(Rooms rooms){
		
		ResponseStructure<Rooms> responseStructure = new ResponseStructure<Rooms>();
		
		ResponseEntity<ResponseStructure<Rooms>> responseEntity = new ResponseEntity<ResponseStructure<Rooms>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(roomsDao.saveRooms(rooms));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Rooms>> updateRooms(Rooms rooms,int id){
		
		ResponseStructure<Rooms> responseStructure = new ResponseStructure<Rooms>();
		
		ResponseEntity<ResponseStructure<Rooms>> responseEntity = new ResponseEntity<ResponseStructure<Rooms>>(responseStructure,HttpStatus.OK);
		Optional<Rooms> rooms2 = roomsDao.getRoomsById(id);
		if(rooms2!=null) {
			rooms.setRoomsId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(roomsDao.updateRooms(rooms));
		}else {
			throw new NoSuchIdFoundException("no such id found in database") ;
		}
		
		return responseEntity;
		
		
	}
	
	

}
