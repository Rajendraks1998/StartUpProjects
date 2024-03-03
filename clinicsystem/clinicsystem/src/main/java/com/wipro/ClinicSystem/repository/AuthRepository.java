package com.wipro.ClinicSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ClinicSystem.model.Admin;

public interface AuthRepository extends JpaRepository<Admin,Integer>{

	Optional<Admin> findByAdminnameAndAdminpassword(String adminName, String adminpassword);

}
