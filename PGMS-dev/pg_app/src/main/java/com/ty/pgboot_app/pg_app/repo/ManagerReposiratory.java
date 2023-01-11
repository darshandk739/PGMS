package com.ty.pgboot_app.pg_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.pgboot_app.pg_app.dto.Manager;

public interface ManagerReposiratory extends JpaRepository<Manager, Integer> {

}
