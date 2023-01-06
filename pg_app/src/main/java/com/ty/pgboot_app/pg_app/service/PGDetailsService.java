package com.ty.pgboot_app.pg_app.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.pgboot_app.pg_app.dao.PGDetailsDao;
import com.ty.pgboot_app.pg_app.dto.PGDetails;
import com.ty.pgboot_app.pg_app.exception.NoSuchIdFoundException;
import com.ty.pgboot_app.pg_app.exception.UnableToDeleteException;
import com.ty.pgboot_app.pg_app.exception.UnableToUpdateException;
import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@Service
public class PGDetailsService {

	@Autowired
	PGDetailsDao dao;
	
	private static final Logger logger = Logger.getLogger(PGDetailsService.class);

	public ResponseEntity<ResponseStructure<PGDetails>> savePGDetails(PGDetails  pgDetails) {
		ResponseStructure<PGDetails> responseStructure = new ResponseStructure<PGDetails>();
		ResponseEntity<ResponseStructure<PGDetails>> responseEntity = new ResponseEntity<ResponseStructure<PGDetails>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.savePGDetails(pgDetails));
		logger.debug("PG details added to the database");
		return responseEntity;
		
	}

	public ResponseEntity<ResponseStructure<PGDetails>> updatePGDetails(PGDetails pgDetails, int id) {
		Optional<PGDetails> optional = dao.getPGDetailsById(id);
		ResponseStructure<PGDetails> responseStructure = new ResponseStructure<PGDetails>();
		ResponseEntity<ResponseStructure<PGDetails>> responseEntity = new ResponseEntity<ResponseStructure<PGDetails>>(
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

	public ResponseEntity<ResponseStructure<PGDetails>> getPGDetails(int id) {
		Optional<PGDetails> optional = dao.getPGDetailsById(id);
		ResponseStructure<PGDetails> responseStructure = new ResponseStructure<PGDetails>();
		ResponseEntity<ResponseStructure<PGDetails>> responseEntity = new ResponseEntity<ResponseStructure<PGDetails>>(
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

	public ResponseEntity<ResponseStructure<PGDetails>> deletePGDetails(int id) {
		Optional<PGDetails> optional = dao.getPGDetailsById(id);
		ResponseStructure<PGDetails> responseStructure = new ResponseStructure<PGDetails>();
		ResponseEntity<ResponseStructure<PGDetails>> responseEntity = new ResponseEntity<ResponseStructure<PGDetails>>(
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

	public ResponseEntity<ResponseStructure<List<PGDetails>>> getAllPGDetails() {
		List<PGDetails> pgDetails = dao.getAllPGDetails();
		ResponseStructure<List<PGDetails>> responseStructure = new ResponseStructure<List<PGDetails>>();
		ResponseEntity<ResponseStructure<List<PGDetails>>> responseEntity = new ResponseEntity<ResponseStructure<List<PGDetails>>>(
				responseStructure, HttpStatus.OK);
	
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Retrieved");
			responseStructure.setData(pgDetails);
			logger.debug(" All the PG details retrieved from the database");

			return responseEntity;


	}
	public ResponseEntity<ResponseStructure<PGDetails>> getPGByLocation(String loc) {
		PGDetails pg = dao.getPGByLocation(loc);
		ResponseStructure<PGDetails> responseStructure = new ResponseStructure<PGDetails>();
		ResponseEntity<ResponseStructure<PGDetails>> responseEntity = new ResponseEntity<ResponseStructure<PGDetails>>(
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
