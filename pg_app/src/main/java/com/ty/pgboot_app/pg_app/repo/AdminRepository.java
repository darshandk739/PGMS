package com.ty.pgboot_app.pg_app.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.pgboot_app.pg_app.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	List<Admin> findAll(Sort adminEmail);
	
}
