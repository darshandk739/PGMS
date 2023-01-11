package com.ty.pgboot_app.pg_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.pgboot_app.pg_app.dto.PGOwner;
import com.ty.pgboot_app.pg_app.repo.PGDetailsRepository;

@Repository
public class PGOwnerDao {
	@Autowired
	private PGDetailsRepository repository;

	public PGOwner savePGDetails(PGOwner pgDetails) {
		return repository.save(pgDetails);
	}
	//git

	public PGOwner updatePGDetails(PGOwner pgDetails) {
		return repository.save(pgDetails);
	}

	public Optional<PGOwner> getPGDetailsById(int id) {
		return repository.findById(id);

	}

	public void deletePGDetails(PGOwner pgDetails) {
		repository.delete(pgDetails);

	}

	public List<PGOwner> getAllPGDetails() {
		return repository.findAll();
	}

	public PGOwner getPGByLocation(String loc) {
		return repository.findByPgLocation(loc);
	}
}
