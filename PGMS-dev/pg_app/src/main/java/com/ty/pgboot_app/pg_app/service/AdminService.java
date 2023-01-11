package com.ty.pgboot_app.pg_app.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.AdminDao;
import com.ty.pgboot_app.pg_app.dto.Admin;
import com.ty.pgboot_app.pg_app.exception.MustNotBeBlankException;
import com.ty.pgboot_app.pg_app.exception.NoSuchIdFoundException;
import com.ty.pgboot_app.pg_app.exception.UnableToDeleteException;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		if (admin != null) {
			ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
			ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
					responseStructure, HttpStatus.OK);

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Created");
			responseStructure.setData(adminDao.saveAdmin(admin));
			return responseEntity;
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int id) {
		Optional<Admin> admin2 = adminDao.getAdminById(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		if (admin2.isPresent()) {
			admin.setAdminId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(adminDao.updateAdmin(admin));
			return responseEntity;
		}
		throw new UnableToDeleteException();
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		Optional<Admin> optional = adminDao.getAdminById(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Recieved");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		Optional<Admin> optional = adminDao.getAdminById(id);

		if (optional.isPresent()) {
			adminDao.deleteAdmin(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Admin Deleted");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new UnableToDeleteException();
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin(){
		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<List<Admin>>();
		ResponseEntity<ResponseStructure<List<Admin>>> responseEntity = new ResponseEntity<ResponseStructure<List<Admin>>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Admin Details");
		responseStructure.setData(adminDao.getAllAdmin());
		return responseEntity;
		
	}

}
