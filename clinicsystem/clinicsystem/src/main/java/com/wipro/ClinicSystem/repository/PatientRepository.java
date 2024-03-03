package com.wipro.ClinicSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  com.wipro.ClinicSystem.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findByPatientId(int id);

}
