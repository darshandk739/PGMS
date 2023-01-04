package com.ty.pgboot_app.pg_app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.pgboot_app.pg_app.dto.Admin;
import com.ty.pgboot_app.pg_app.service.AdminService;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@ApiOperation(value = "SaveAdmin", notes = "It is used to Save the Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Valid @RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	
	
	
	@ApiOperation(value = "UpdateAdmin", notes = "It is used to Update the Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@Valid @RequestBody Admin admin, @RequestParam int id) {
		return adminService.updateAdmin(admin, id);
	}

	@ApiOperation(value = "GetAdmin", notes = "It is used to Get the Admin")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@Valid @RequestParam int id) {
		return adminService.getAdminById(id);
	}
	
	@ApiOperation(value = "DeleteAdmin", notes = "It is used to Delete the Admin")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@Valid @RequestParam int id){
		return adminService.deleteAdmin(id);
	}
	
	@ApiOperation(value = "GetAllAdmin", notes = "It is used to Get all the Admins")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PatchMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin(){
		return adminService.getAllAdmin();
	}


}
