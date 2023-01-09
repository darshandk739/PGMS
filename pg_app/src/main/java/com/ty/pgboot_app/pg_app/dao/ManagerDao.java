package com.ty.pgboot_app.pg_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.pgboot_app.pg_app.dto.Manager;
import com.ty.pgboot_app.pg_app.repo.ManagerReposiratory;

@Repository
public class ManagerDao {
	@Autowired
	private ManagerReposiratory reposiratory;
	
	public Manager saveManager(Manager manager) {
		return reposiratory.save(manager);
	}
	
	public Manager updateManager(Manager manager) {
		return reposiratory.save(manager);
	}
	
	public Optional<Manager> getManagerById(int id){
		return reposiratory.findById(id);
	}
	
	public void deleteAdmin(Manager manager) {
		reposiratory.delete(manager);
	}
	
	public List<Manager> getAllManager(){
		return reposiratory.findAll();
	}
}
