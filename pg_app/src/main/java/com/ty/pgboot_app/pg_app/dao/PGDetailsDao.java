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
	
	public PGDetails getPGDetailsById(int id) {
		Optional<PGDetails> optional = repository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public String deletePGDetailsById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}
