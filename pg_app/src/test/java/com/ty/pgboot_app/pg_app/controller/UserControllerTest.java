package com.ty.pgboot_app.pg_app.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.pgboot_app.pg_app.dto.User;
import com.ty.pgboot_app.pg_app.repo.UserRepository;

@SpringBootTest
class UserControllerTest {
	@Autowired
	UserRepository repo;
	
	@Test
	void testSaveUser() {
		User user = new User();
		user.setUserId(3);
		user.setUsername("ramu");
		user.setUserOccupation("student");
		user.setUserAge(26);
		user.setUserPhone(2368);
		user.setUserProofId("Aadhar");
		user.setUserAddress("Mysore");
		repo.save(user);
		//assertNotNull(repo.findById(3).get());
	}

	@Test
	void testUpdateUser() {
		User user = repo.findById(11).get();
		user.setUsername("hello");
		repo.save(user);
		assertNotEquals("ramu", repo.findById(11).get().getUsername());
	}

	@Test
	void testGetUserById() {
		User user = repo.findById(11).get();
		assertEquals("student", repo.findById(11).get().getUserOccupation());
	}

	@Test
	void testDeleteUser() {
		repo.deleteById(10);
	}

}
