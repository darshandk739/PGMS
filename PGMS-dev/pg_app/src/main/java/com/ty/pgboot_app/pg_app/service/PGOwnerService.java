package com.ty.pgboot_app.pg_app.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.PGOwnerDao;
import com.ty.pgboot_app.pg_app.dto.PGOwner;
import com.ty.pgboot_app.pg_app.exception.NoSuchIdFoundException;
import com.ty.pgboot_app.pg_app.exception.UnableToDeleteException;
import com.ty.pgboot_app.pg_app.exception.UnableToUpdateException;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class PGOwnerService {

	@Autowired
	PGOwnerDao dao;
	
	private static final Logger logger = Logger.getLogger(PGOwnerService.class);

	public ResponseEntity<ResponseStructure<PGOwner>> savePGDetails(PGOwner  pgDetails) {
		ResponseStructure<PGOwner> responseStructure = new ResponseStructure<PGOwner>();
		ResponseEntity<ResponseStructure<PGOwner>> responseEntity = new ResponseEntity<ResponseStructure<PGOwner>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.savePGDetails(pgDetails));
		logger.debug("PG details added to the database");
		return responseEntity;
		
		
	}
	//git

	public ResponseEntity<ResponseStructure<PGOwner>> updatePGDetails(PGOwner pgDetails, int id) {
		Optional<PGOwner> optional = dao.getPGDetailsById(id);
		ResponseStructure<PGOwner> responseStructure = new ResponseStructure<PGOwner>();
		ResponseEntity<ResponseStructure<PGOwner>> responseEntity = new ResponseEntity<ResponseStructure<PGOwner>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			pgDetails.setPgId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updatePGDetails(pgDetails));
			logger.debug("PG details updated in the database");
			return responseEntity;
		}
		logger.warn("no such id found in database to update");
		throw new UnableToUpdateException();
	}

	public ResponseEntity<ResponseStructure<PGOwner>> getPGDetails(int id) {
		Optional<PGOwner> optional = dao.getPGDetailsById(id);
		ResponseStructure<PGOwner> responseStructure = new ResponseStructure<PGOwner>();
		ResponseEntity<ResponseStructure<PGOwner>> responseEntity = new ResponseEntity<ResponseStructure<PGOwner>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Retrieved");
			responseStructure.setData(optional.get());
			logger.debug("PG details retrieved from the database");
			return responseEntity;
		}
		logger.warn("no such id found in database ");
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<PGOwner>> deletePGDetails(int id) {
		Optional<PGOwner> optional = dao.getPGDetailsById(id);
		ResponseStructure<PGOwner> responseStructure = new ResponseStructure<PGOwner>();
		ResponseEntity<ResponseStructure<PGOwner>> responseEntity = new ResponseEntity<ResponseStructure<PGOwner>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			dao.deletePGDetails(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			logger.debug("PG details deleted from the database");
			return responseEntity;
		}
		logger.warn("no such id found in database to delete");
		throw new UnableToDeleteException();
	}

	public ResponseEntity<ResponseStructure<List<PGOwner>>> getAllPGDetails() {
		List<PGOwner> pgDetails = dao.getAllPGDetails();
		ResponseStructure<List<PGOwner>> responseStructure = new ResponseStructure<List<PGOwner>>();
		ResponseEntity<ResponseStructure<List<PGOwner>>> responseEntity = new ResponseEntity<ResponseStructure<List<PGOwner>>>(
				responseStructure, HttpStatus.OK);
	
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Retrieved");
			responseStructure.setData(pgDetails);
			logger.debug(" All the PG details retrieved from the database");

			return responseEntity;


	}
	public ResponseEntity<ResponseStructure<PGOwner>> getPGByLocation(String loc) {
		PGOwner pg = dao.getPGByLocation(loc);
		ResponseStructure<PGOwner> responseStructure = new ResponseStructure<PGOwner>();
		ResponseEntity<ResponseStructure<PGOwner>> responseEntity = new ResponseEntity<ResponseStructure<PGOwner>>(
				responseStructure, HttpStatus.OK);
		if (pg!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Retrieved");
			responseStructure.setData(pg);
			logger.debug("PG details retrieved from the database by location");
			return responseEntity;
		}
		logger.warn("no such location found in the database");
		throw new NoSuchIdFoundException();
		
	}
	
}
