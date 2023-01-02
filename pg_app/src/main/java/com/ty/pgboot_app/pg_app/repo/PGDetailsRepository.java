package com.ty.pgboot_app.pg_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.pgboot_app.pg_app.dto.PGDetails;

public interface  PGDetailsRepository extends JpaRepository<PGDetails, Integer>{
	public PGDetails findByPgLocation(String loc);
}
