package com.ty.pgboot_app.pg_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.pgboot_app.pg_app.dto.Admin;
import com.ty.pgboot_app.pg_app.repo.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Optional<Admin> getAdminById(int id) {
		return adminRepository.findById(id);
	}
	
	public void deleteAdmin(Admin admin) {
		adminRepository.delete(admin);	
	}
}
