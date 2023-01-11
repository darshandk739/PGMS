package com.ty.pgboot_app.pg_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ty.pgboot_app.pg_app.dto.PGOwner;

public interface  PGDetailsRepository extends JpaRepository<PGOwner, Integer>{
	public PGOwner findByPgLocation(String loc);
}
