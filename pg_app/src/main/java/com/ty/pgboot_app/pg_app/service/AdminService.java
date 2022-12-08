package com.ty.pgboot_app.pg_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.AdminDao;
import com.ty.pgboot_app.pg_app.dto.Admin;
import com.ty.pgboot_app.pg_app.exception.NoSuchIdFoundException;
import com.ty.pgboot_app.pg_app.exception.UnableToDeleteException;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return responseEntity;
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
			responseStructure.setData(adminDao.getAdminById(id).get());
			return responseEntity;
		}
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		Optional<Admin> optional = adminDao.getAdminById(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			adminDao.deleteAdmin(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Admin Deleted");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new UnableToDeleteException();
	}

}
