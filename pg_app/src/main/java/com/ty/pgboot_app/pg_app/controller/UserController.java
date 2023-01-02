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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.pgboot_app.pg_app.dto.User;
import com.ty.pgboot_app.pg_app.service.UserService;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "SaveUser", notes = "It is used to Save the User")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@ApiOperation(value = "UpdateUser", notes = "It is used to Update the User")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user, @RequestParam int id){
		return userService.updateUser(user, id);
	}
	
	@ApiOperation(value = "GetUser", notes = "It is used to Get the User")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id){
		return userService.getUserById(id);
	}
	
	@ApiOperation(value = "DeleteUser", notes = "It is used to Delete the User")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		return userService.deleteUser(id);
	}
	
	
	@ApiOperation(value = "GetAllUsers", notes = "It is used to get all Users")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PatchMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers(){
		return userService.getAllUsers();
	}
}
