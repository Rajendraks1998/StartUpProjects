package com.wipro.ClinicSystem.service;
import java.util.List;
import  com.wipro.ClinicSystem.model.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);

	Patient findPatientById(int id);

	Patient updatePatient(Patient patient);

	void deletePatient(int id);

	List<Patient> findAll();

}
