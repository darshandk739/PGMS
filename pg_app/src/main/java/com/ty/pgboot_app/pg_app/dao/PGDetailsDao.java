package com.ty.pgboot_app.pg_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.pgboot_app.pg_app.dto.PGDetails;
import com.ty.pgboot_app.pg_app.repo.PGDetailsRepository;

@Repository
public class PGDetailsDao {
	@Autowired
	private PGDetailsRepository repository;
	
	public PGDetails savePGDetails(PGDetails pgDetails ) {
		return repository.save(pgDetails);
	}
	
	public PGDetails updatePGDetails(PGDetails pgDetails ) {
		return repository.save(pgDetails);
	}
	
	public Optional<PGDetails> getPGDetailsById(int id) {
	return repository.findById(id);
	
	}
	
	public void deletePGDetails(PGDetails pgDetails) {
		repository.delete(pgDetails);
		
	}

	public PGDetails getPGByLocation(String loc) {
		return repository.findByPgLocation(loc);
	}
}
