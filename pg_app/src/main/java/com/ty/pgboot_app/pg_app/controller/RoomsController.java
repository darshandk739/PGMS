package com.ty.pgboot_app.pg_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.pgboot_app.pg_app.dto.Rooms;
import com.ty.pgboot_app.pg_app.service.RoomsService;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("rooms")
public class RoomsController {
	@Autowired
	private RoomsService roomService;

	@ApiOperation(value = "Save Rooms", notes = "It is used to save Rooms")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "NotFound") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Rooms>> saveRooms(Rooms rooms) {
		return roomService.saveRooms(rooms);
	}

	@ApiOperation(value = "Update Rooms", notes = "It is used to update Rooms")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "NotFound") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<Rooms>> updateRooms(@RequestBody Rooms rooms, @RequestParam int id) {
		return roomService.updateRooms(rooms, id);
	}

	@ApiOperation(value = "Get Rooms", notes = "It is used to get Rooms")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "NotFound") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Rooms>> getRooms(int id) {
		return roomService.getRoomsById(id);
	}

	@ApiOperation(value = "Get All Rooms", notes = "It is used to get All Rooms")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "NotFound") })
	@PatchMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<List<Rooms>>> getAllRooms() {
		return roomService.getAllRooms();
	}

	@ApiOperation(value = "Delete Rooms", notes = "It is used to delete Rooms")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "NotFound") })
	@DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Rooms>> deleteRooms(int id) {
		return roomService.deleteRoomsById(id);
	}
}
