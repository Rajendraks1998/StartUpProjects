package com.wipro.ClinicSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ClinicSystem.model.Doctor;
import com.wipro.ClinicSystem.repository.DoctorRepository;

import com.wipro.ClinicSystem.service.DoctorSerive;

@Service
public class DoctorServiceImpl implements DoctorSerive{

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor findDoctorById(int id) {
		
		return doctorRepository.findByDocotorId(id);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctor(int id) {
		doctorRepository.deleteById(id);
		
	}

	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	

}
