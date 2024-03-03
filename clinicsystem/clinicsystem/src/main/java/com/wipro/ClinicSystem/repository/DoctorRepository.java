package com.wipro.ClinicSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.ClinicSystem.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
	Doctor findByDocotorId(Integer id);
}