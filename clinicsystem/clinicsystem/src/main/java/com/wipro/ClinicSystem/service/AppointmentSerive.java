package com.wipro.ClinicSystem.service;

import java.util.List;

import com.wipro.ClinicSystem.model.Appointment;

public interface AppointmentSerive {
	
	Appointment saveAppointment(Appointment appointment);
	
	Appointment findByAppointmentId(int id);

	Appointment updateAppointment(Appointment appointment);

	void deleteAppointment(int id);

	List<Appointment> findAll();
}
