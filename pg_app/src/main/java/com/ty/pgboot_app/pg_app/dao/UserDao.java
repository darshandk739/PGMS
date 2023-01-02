package com.ty.pgboot_app.pg_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.pgboot_app.pg_app.dto.User;
import com.ty.pgboot_app.pg_app.repo.UserRepository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);	
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
