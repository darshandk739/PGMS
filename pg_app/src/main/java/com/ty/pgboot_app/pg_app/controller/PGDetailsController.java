package com.ty.pgboot_app.pg_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ty.pgboot_app.pg_app.dto.PGDetails;
import com.ty.pgboot_app.pg_app.service.PGDetailsService;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("pgdetails")
public class PGDetailsController {

	@Autowired
	PGDetailsService service;
	
	@ApiOperation(value = "Save PGDetails", notes = "It is used to save PGDetails")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
	MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<PGDetails>> savePGDetails(@RequestBody @Valid PGDetails pgDetails) {
		return service.savePGDetails(pgDetails);
	}
	
	@ApiOperation(value = "Get PGDetails", notes = "It is used to get the PGDetails")
	@ApiResponses(value = {
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<PGDetails>> getPGDetailsById(@RequestParam int id) {
		return service.getPGDetails(id);
	}
	
	@ApiOperation(value = "Update PGDetails", notes = "It is used to Update the PGDetails")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<PGDetails>> updatePGDetailsById(@RequestBody PGDetails pgDetails, @RequestParam int id) {
		return service.updatePGDetails(pgDetails, id);
	}
	
	@ApiOperation(value = "Delete PGDetails", notes = "It is used to delete PGDetails")
	@ApiResponses(value = {
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<PGDetails>> deletePGDetailsById(@RequestParam int id) {
		return service.deletePGDetails(id);
	}

	
}
