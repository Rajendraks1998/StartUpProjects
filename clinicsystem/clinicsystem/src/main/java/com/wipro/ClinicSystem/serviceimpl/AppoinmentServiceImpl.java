package com.wipro.ClinicSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ClinicSystem.model.Appointment;
import com.wipro.ClinicSystem.repository.AppointmentRepository;
import com.wipro.ClinicSystem.service.AppointmentSerive;

@Service
public class AppoinmentServiceImpl implements AppointmentSerive{

	@Autowired
	private AppointmentRepository appoinmentRepository;
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appoinmentRepository.save(appointment);
	}

	@Override
	public Appointment findByAppointmentId(int id) {
		return appoinmentRepository.findByAppointmentId(id);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return appoinmentRepository.save(appointment);
	}

	@Override
	public void deleteAppointment(int id) {
		appoinmentRepository.deleteById(id);
	}

	@Override
	public List<Appointment> findAll() {
		return appoinmentRepository.findAll();
	}

	
}
