package com.ty.pgboot_app.pg_app.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.pgboot_app.pg_app.dto.Admin;
import com.ty.pgboot_app.pg_app.repo.AdminRepository;

@SpringBootTest
class AdminControllerTest {
	@Autowired
	AdminRepository repo;

	@Test
	void testSaveAdmin() {
		Admin admin = new Admin();
		admin.setAdminId(17);
		admin.setAdminName("kirankiran");
		admin.setAdminEmail("kiran@mail.com");
		admin.setAdminPassword("789");
		admin.setAdminUserName("kiran56");
		repo.save(admin);
		assertNotNull(repo.findById(17).get());
	}

	@Test
	void testUpdateAdmin() {
		Admin admin = repo.findById(17).get();
		admin.setAdminName("OnlyKiran");
		repo.save(admin);
		assertNotEquals("kirankiran5656", repo.findById(17).get().getAdminName());
	}

	@Test
	void testGetAdminById() {
		Admin admin = repo.findById(17).get();
		assertEquals("789", repo.findById(17).get().getAdminPassword());
	}

	@Test
	void testDeleteAdmin() {
		repo.deleteById(17);
	}

}
