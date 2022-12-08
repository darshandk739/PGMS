package com.ty.pgboot_app.pg_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.UserDao;
import com.ty.pgboot_app.pg_app.dto.User;
import com.ty.pgboot_app.pg_app.exception.NoSuchIdFoundException;
import com.ty.pgboot_app.pg_app.exception.UnableToDeleteException;
import com.ty.pgboot_app.pg_app.exception.UnableToUpdateException;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(userDao.saveUser(user));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user, int id){
		Optional<User> optional = userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.OK);
		if(optional.isPresent()) {
			user.setUserId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(userDao.updateUser(user));
		return responseEntity;
		}
		throw new UnableToUpdateException();
	}
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int id){
		Optional<User> optional = userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.OK);
		if(optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User Found");
			responseStructure.setData(userDao.getUserById(id).get());
			return responseEntity;
		}
		throw new NoSuchIdFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		Optional<User> optional = userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.OK);
		if(optional.isPresent()) {
			userDao.deleteUser(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User Deleted");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new UnableToDeleteException();
	}
}
