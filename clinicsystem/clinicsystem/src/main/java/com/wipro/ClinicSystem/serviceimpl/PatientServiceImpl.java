package com.wipro.ClinicSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ClinicSystem.model.Patient;
import com.wipro.ClinicSystem.repository.PatientRepository;
import com.wipro.ClinicSystem.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient findPatientById(int id) {
		return patientRepository.findByPatientId(id);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatient(int id) {
		patientRepository.deleteById(id);
		
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	

}
