package com.wipro.ClinicSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.ClinicSystem.model.Appointment;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>
{

	Appointment findByAppointmentId(int id);
	
}