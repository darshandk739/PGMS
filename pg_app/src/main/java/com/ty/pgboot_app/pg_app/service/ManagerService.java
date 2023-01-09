package com.ty.pgboot_app.pg_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.ManagerDao;
import com.ty.pgboot_app.pg_app.dto.Manager;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;
	
	public ResponseEntity<ResponseStructure<Manager>> saveManger(Manager manager){
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		ResponseEntity<ResponseStructure<Manager>> responseEntity = new ResponseEntity<ResponseStructure<Manager>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Manager Created");
		responseStructure.setData(managerDao.saveManager(manager));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Manager>> updateManager(Manager manager){
		return null;
	}
}
