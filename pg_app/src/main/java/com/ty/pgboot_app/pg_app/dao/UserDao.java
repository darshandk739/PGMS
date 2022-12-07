package com.ty.pgboot_app.pg_app.dao;

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
	
	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "Deleted";
	}
}
