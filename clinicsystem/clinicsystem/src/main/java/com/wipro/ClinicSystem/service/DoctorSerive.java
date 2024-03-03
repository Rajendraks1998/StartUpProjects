package com.wipro.ClinicSystem.service;

import java.util.List;

import com.wipro.ClinicSystem.model.Doctor;

public interface DoctorSerive {
	
	Doctor saveDoctor(Doctor doctor);

	Doctor findDoctorById(int id);

	Doctor updateDoctor(Doctor doctor);

	void deleteDoctor(int id);

	List<Doctor> findAll();
}
