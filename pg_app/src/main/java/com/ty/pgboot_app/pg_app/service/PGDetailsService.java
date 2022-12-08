package com.ty.pgboot_app.pg_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.PGDetailsDao;
import com.ty.pgboot_app.pg_app.dto.PGDetails;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class PGDetailsService {

	@Autowired
	PGDetailsDao dao;
	
	public ResponseEntity<ResponseStructure<PGDetails>> savePGDetails(PGDetails pgDetails) {
		ResponseStructure<PGDetails> responseStructure = new ResponseStructure<PGDetails>();
		ResponseEntity<ResponseStructure<PGDetails>> responseEntity =new ResponseEntity<ResponseStructure<PGDetails>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.savePGDetails(pgDetails));
		return responseEntity;
	}
	
	
}
