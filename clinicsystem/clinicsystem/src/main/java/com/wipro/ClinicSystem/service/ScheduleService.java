package com.wipro.ClinicSystem.service;

import java.util.List;

import com.wipro.ClinicSystem.model.Schedule;

public interface ScheduleService 
{
	List<Schedule> findAll();
	Schedule saveSchedule(Schedule Schedule);
	Schedule findByScheduleId(int id);
	void deleteSchedule(int id);
	Schedule updateSchedule(Schedule sSchedule);
}
